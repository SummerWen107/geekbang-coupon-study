package com.summerwen.coupon.template.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * 优惠券类型
 *
 * @author wenjunpu
 * @Date 2022/06/10/17:38
 * @Description
 */
@Getter
@AllArgsConstructor
public enum CouponType {
    /**
     * 它专门用来对付故意输错 code
     * 的恶意请求
     */
    UNKNOWN("unknown", "0"),
    MONEY_OFF("满减券", "1"),
    DISCOUNT("打折", "2"),
    RANDOM_DISCOUNT("随机减", "3"),
    LONELY_NIGHT_MONEY_OFF("寂寞午夜double券", "4"),
    ANTI_PUA("PUA加倍奉还券", "5");

    /**
     * 描述信息
     */
    private String description;

    /**
     * 存在数据库里的最终code
     */
    private String code;

    /**
     * 根据优惠券的编码返回对应的枚举对象
     * @param code  优惠券编号
     * @return  优惠券类型
     */
    public static CouponType convert(String code) {
        return Stream.of(values())
                .filter(couponType -> couponType.code.equalsIgnoreCase(code))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
