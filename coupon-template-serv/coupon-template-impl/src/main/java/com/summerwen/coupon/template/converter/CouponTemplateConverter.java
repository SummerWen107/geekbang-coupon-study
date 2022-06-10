package com.summerwen.coupon.template.converter;

import com.summerwen.coupon.template.api.beans.CouponTemplateInfo;
import com.summerwen.coupon.template.dao.entity.CouponTemplate;

/**
 * 类描述
 *
 * @author wenjunpu
 * @Date 2022/06/10/18:17
 * @Description
 */
public class CouponTemplateConverter {

    public static CouponTemplateInfo convertToTemplateInfo(CouponTemplate template){
        return CouponTemplateInfo.builder()
                .id(template.getId())
                .name(template.getName())
                .desc(template.getDescription())
                .type(template.getCategory().getCode())
                .shopId(template.getShopId())
                .available(template.getAvailable())
                .rule(template.getRule())
                .build();
    }
}
