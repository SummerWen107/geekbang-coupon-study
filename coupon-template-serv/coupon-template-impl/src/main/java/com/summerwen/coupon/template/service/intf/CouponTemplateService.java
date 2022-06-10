package com.summerwen.coupon.template.service.intf;

import com.summerwen.coupon.template.api.beans.CouponTemplateInfo;
import com.summerwen.coupon.template.api.beans.PagedCouponTemplateInfo;
import com.summerwen.coupon.template.api.beans.TemplateSearchParams;

import java.util.Collection;
import java.util.Map;

/**
 * 定义 Service 层的接口类
 *
 * @author wenjunpu
 * @Date 2022/06/10/18:13
 * @Description
 */
public interface CouponTemplateService {

    // 创建优惠券模板
    CouponTemplateInfo createTemplate(CouponTemplateInfo request);

    CouponTemplateInfo cloneTemplate(Long templateId);

    // 模板查询（分页）
    PagedCouponTemplateInfo search(TemplateSearchParams request);

    // 通过模板ID查询优惠券模板
    CouponTemplateInfo loadTemplateInfo(Long id);

    // 让优惠券模板无效
    void deleteTemplate(Long id);

    // 批量查询
    // Map是模板ID，key是模板详情
    Map<Long, CouponTemplateInfo> getTemplateInfoMap(Collection<Long> ids);
}
