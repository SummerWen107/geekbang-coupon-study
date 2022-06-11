package com.summerwen.coupon.calculation.template.impl;

import com.summerwen.coupon.calculation.template.AbstractRuleTemplate;
import com.summerwen.coupon.calculation.template.RuleTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 打折优惠券
 *
 * @author wenjunpu
 * @Date 2022/06/11/19:50
 * @Description
 */
@Slf4j
@Component
public class DiscountTemplate extends AbstractRuleTemplate implements RuleTemplate {
    @Override
    protected Long calculateNewPrice(Long totalAmount, Long shopTotalAmount, Long quota) {
        long newPrice = convertToDecimal(shopTotalAmount * (quota.doubleValue() / 100));
        log.debug("original price={}, new price={}", totalAmount, newPrice);
        return newPrice;
    }
}
