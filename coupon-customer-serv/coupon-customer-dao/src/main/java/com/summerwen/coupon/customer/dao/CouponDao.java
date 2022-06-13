package com.summerwen.coupon.customer.dao;

import com.summerwen.coupon.customer.dao.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 类描述
 *
 * @author wenjunpu
 * @Date 2022/06/11/20:58
 * @Description
 */
public interface CouponDao extends JpaRepository<Coupon, Long> {

    long countByUserIdAndTemplateId(Long userId, Long templateId);

}
