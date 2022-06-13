package com.summerwen.coupon.customer.api.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 类描述
 *
 * @author wenjunpu
 * @Date 2022/06/11/20:54
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCoupon {
    // 用户领券
    @NotNull
    private Long userId;

    // 券模板ID
    @NotNull
    private Long couponTemplateId;
}
