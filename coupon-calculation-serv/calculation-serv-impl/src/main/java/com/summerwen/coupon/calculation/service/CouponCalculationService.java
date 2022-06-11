package com.summerwen.coupon.calculation.service;

import com.summerwen.coupon.calculation.api.beans.ShoppingCart;
import com.summerwen.coupon.calculation.api.beans.SimulationOrder;
import com.summerwen.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 类描述
 *
 * @author wenjunpu
 * @Date 2022/06/11/19:58
 * @Description
 */
public interface CouponCalculationService {

    ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart cart);

    SimulationResponse simulateOrder(@RequestBody SimulationOrder cart);
}
