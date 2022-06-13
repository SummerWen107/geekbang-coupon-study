package com.summerwen.coupon.customer.service.intf;


import com.summerwen.coupon.calculation.api.beans.ShoppingCart;
import com.summerwen.coupon.calculation.api.beans.SimulationOrder;
import com.summerwen.coupon.calculation.api.beans.SimulationResponse;
import com.summerwen.coupon.customer.api.beans.RequestCoupon;
import com.summerwen.coupon.customer.api.beans.SearchCoupon;
import com.summerwen.coupon.customer.dao.entity.Coupon;
import com.summerwen.coupon.template.api.beans.CouponInfo;
import io.micrometer.core.instrument.search.Search;

import java.util.List;

// 用户对接服务
public interface CouponCustomerService {

    // 领券接口
    Coupon requestCoupon(RequestCoupon request);

    // 核销优惠券
    ShoppingCart placeOrder(ShoppingCart info);

    // 优惠券金额试算
    SimulationResponse simulateOrderPrice(SimulationOrder order);

    void deleteCoupon(Long userId, Long couponId);

    // 查询用户优惠券
    List<CouponInfo> findCoupon(SearchCoupon request);
}
