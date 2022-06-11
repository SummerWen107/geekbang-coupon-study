package com.summerwen.coupon.calculation.template;

import com.google.common.collect.Maps;
import com.summerwen.coupon.calculation.api.beans.Product;
import com.summerwen.coupon.calculation.api.beans.ShoppingCart;
import com.summerwen.coupon.template.api.beans.CouponTemplateInfo;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 抽象模板类
 * 通用计算逻辑
 *
 * @author wenjunpu
 * @Date 2022/06/11/15:47
 * @Description
 */
@Slf4j
public abstract class AbstractRuleTemplate implements RuleTemplate {

    /**
     * 模板计算逻辑
     *
     * @param order 结账时提交的购物车明细,也就是订单信息
     * @return
     */
    @Override
    public ShoppingCart calculate(ShoppingCart order) {
        //获取订单中的全部商品
        List<Product> products = order.getProducts();
        //根据商品获取总价格
        long orderTotalAmount = getTotalPrice(products);
        //根据门店来获取每个门店下的价格总和
        Map<Long, Long> sumAmountGroup = getTotalPriceGroupByShop(products);
        //获取优惠券信息
        // TODO: 2022.6.11 这里可能需要处理没有优惠券的情况，还有多重优惠券混合情况
        CouponTemplateInfo template = order.getCouponInfos().get(0).getTemplate();
        //最低消费限制
        Long threshold = template.getRule().getDiscount().getThreshold();
        //优惠金额或者打折比例
        Long quota = template.getRule().getDiscount().getQuota();
        //当前优惠券适用的门店，如果为空则用户整个商城
        Long shopId = template.getShopId();
        //如果优惠券无限制，那么shopTotalAmount对应的是全部金额
        //如果有限制，那就获取指定门店的订单金额
        Long shopTotalAmount = (shopId == null) ? orderTotalAmount : sumAmountGroup.get(shopId);

        if (shopTotalAmount == null || shopTotalAmount < threshold){
            log.warn("Totals of amount not meet, ur coupons are not applicable to this order");
            order.setCost(shopTotalAmount);
            order.setCouponInfos(Collections.emptyList());
            return order;
        }

        // 子类中计算新的价格
        Long newCost = calculateNewPrice(orderTotalAmount, shopTotalAmount, quota);
        if (newCost < minCost()){
            newCost = minCost();
        }
        order.setCost(newCost);
        log.debug("原始价格={}, 优惠后价格={}", orderTotalAmount, newCost);
        log.debug("original price={}, new price={}", orderTotalAmount, newCost);
        return order;
    }

    /**
     * 金额计算具体逻辑，延迟到子类实现
     * @param orderTotalAmount 订单总金额
     * @param shopTotalAmount   店铺的金额
     * @param quota             优惠比例
     * @return  优惠后的价钱
     */
    abstract protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota);


    /**
     * 将商品安装门店进行分组，然后分组计算每个门店的价格总和
     * @param products 要计算的商品集合
     * @return  key为门店ID，value为该门店的商品总价格
     */
    protected Map<Long, Long> getTotalPriceGroupByShop(List<Product> products) {
        //HashMap<Long, Long> map = Maps.newHashMap();
        //for (Product product : products) {
        //    map.computeIfAbsent(product.getShopId(),shopId->map.get(shopId) + (product.getPrice() * product.getCount()));
        //}
        //return map;
        return products.stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getShopId,
                                Collectors.summingLong(product -> product.getPrice() * product.getCount())
                        )
                );
    }

    /**
     * 计算商品总价格
     * @param products  要计算的商品集合
     * @return  商品总价格
     */
    protected long getTotalPrice(List<Product> products) {
        return products.stream()
                .mapToLong(product -> product.getPrice() * product.getCount())
                .sum();
    }

    // 每个订单最少必须支付1分钱
    protected long minCost() {
        return 1L;
    }

    protected long convertToDecimal(Double value) {
        return new BigDecimal(value).setScale(0, RoundingMode.HALF_UP).longValue();
    }
}
