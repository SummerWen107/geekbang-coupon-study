package com.summerwen.coupon.calculation.template;

import com.summerwen.coupon.calculation.api.beans.ShoppingCart;

/**
 * 规则模板接口
 *
 * @author wenjunpu
 * @Date 2022/06/11/15:45
 * @Description
 */
public interface RuleTemplate {

    /**
     * 计算优惠券
     * @param settlement 结账时提交的购物车明细
     * @return  计算后的购物车明细
     */
    ShoppingCart calculate(ShoppingCart settlement);
}
