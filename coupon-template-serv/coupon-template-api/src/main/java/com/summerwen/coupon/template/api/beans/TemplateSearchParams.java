package com.summerwen.coupon.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

//import javax.validation.constraints.NotNull;

/**
 * 优惠券查询的入参
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemplateSearchParams {

    private Long id;

    private String name;

    private String type;

    private Long shopId;

    private Boolean available;

    //应该给个默认值，否则不传的话会报错
    private int page = 0;
    //应该给个默认值，否则不传的话会报错
    private int pageSize = 10;

}
