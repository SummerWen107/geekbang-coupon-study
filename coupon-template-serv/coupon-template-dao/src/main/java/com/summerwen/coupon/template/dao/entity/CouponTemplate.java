package com.summerwen.coupon.template.dao.entity;

import com.summerwen.coupon.template.api.beans.rules.TemplateRule;
import com.summerwen.coupon.template.api.enums.CouponType;
import com.summerwen.coupon.template.dao.converter.CouponTypeConverter;
import com.summerwen.coupon.template.dao.converter.RuleConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 优惠券模板
 *
 * @author wenjunpu
 * @Date 2022/06/10/18:01
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity//声明了"数据库实体"对象，它是数据库 Table 在程序中的映射对象
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "coupon_template")//指定了 CouponTemplate 对应的数据库表的名称
public class CouponTemplate {
    //ID 注解将某个字段定义为唯一主键
    @Id
    //GeneratedValue 注解指定了主键生成策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //指定了每个类属性和数据库字段的对应关系，
    //该注解还支持非空检测、对update 和 create 语句进行限制等功能
    @Column(name = "id", nullable = false)
    private Long id;

    // 状态是否可用
    @Column(name = "available", nullable = false)
    private Boolean available;

    @Column(name = "name", nullable = false)
    private String name;

    // 适用门店-如果为空，则为全店满减券
    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "description", nullable = false)
    private String description;

    // 优惠券类型
    @Column(name = "type", nullable = false)

    @Convert(converter = CouponTypeConverter.class)
    private CouponType category;

    // 创建时间，通过@CreateDate注解自动填值（需要配合@JpaAuditing注解在启动类上生效）
    @CreatedDate
    @Column(name = "created_time", nullable = false)
    private Date createdTime;

    // 优惠券核算规则，平铺成JSON字段
    @Column(name = "rule", nullable = false)
    @Convert(converter = RuleConverter.class)
    private TemplateRule rule;
}
