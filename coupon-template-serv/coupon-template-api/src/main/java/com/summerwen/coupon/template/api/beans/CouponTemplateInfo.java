package com.summerwen.coupon.template.api.beans;


import com.summerwen.coupon.template.api.beans.rules.TemplateRule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 创建优惠券模板
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponTemplateInfo {

    private Long id;

    // @NotNull，对参数是否为
    //Null 进行了校验。如果请求参数为空，那么接口会自动返回 Bad Request 异常。当然，
    //jakarta 组件还有很多可以用来做判定验证的注解，合理使用可以节省大量编码工作，提高
    //代码可读性
    @NotNull
    private String name;

    // 优惠券描述
    @NotNull
    private String desc;

    // 优惠券类型
    @NotNull
    private String type;

    // 适用门店 - 若无则为全店通用券
    private Long shopId;

    /** 优惠券规则 */
    @NotNull
    private TemplateRule rule;

    private Boolean available;

}
