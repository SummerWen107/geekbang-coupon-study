package com.summerwen.coupon.calculation.template.impl;

import com.summerwen.coupon.calculation.api.beans.ShoppingCart;
import com.summerwen.coupon.calculation.template.AbstractRuleTemplate;
import com.summerwen.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 没有优惠券
 *
 * @author wenjunpu
 * @Date 2022/06/11/20:02
 * @Description
 */
@Slf4j
@Component
public class DummyTemplate extends AbstractRuleTemplate implements RuleTemplate {

    @Override
    public ShoppingCart calculate(ShoppingCart order) {
        // 获取订单总价
        order.setCost(getTotalPrice(order.getProducts()));
        return order;
    }

    //计算优惠后的价钱
    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        return orderTotalAmount;
    }
}
