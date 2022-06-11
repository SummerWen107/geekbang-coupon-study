package com.summerwen.coupon.calculation.api.beans;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 价格计算的返回值
 *
 * @author wenjunpu
 * @Date 2022/06/11/15:09
 * @Description
 */
@Data
@NoArgsConstructor
public class SimulationResponse {

    // 最省钱的coupon
    private Long bestCouponId;

    // 每一个coupon对应的order价格
    private Map<Long, Long> couponToOrderPrice = Maps.newHashMap();
}
