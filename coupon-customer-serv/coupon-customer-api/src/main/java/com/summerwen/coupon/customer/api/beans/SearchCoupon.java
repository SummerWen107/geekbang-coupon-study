package com.summerwen.coupon.customer.api.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 查询优惠券
 *
 * @author wenjunpu
 * @Date 2022/06/11/20:55
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCoupon {

    @NotNull
    private Long userId;
    private Long shopId;
    private Integer couponStatus;

}
