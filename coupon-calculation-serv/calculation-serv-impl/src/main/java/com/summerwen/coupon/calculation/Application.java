package com.summerwen.coupon.calculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 类描述
 *
 * @author wenjunpu
 * @Date 2022/06/11/15:29
 * @Description
 */
@SpringBootApplication
public class Application {
    /*
    优惠券应该是先计算店铺优惠，然后再计算全局优惠，这样才能得出最终结果
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
