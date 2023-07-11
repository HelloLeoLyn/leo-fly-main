package com.leo.fly.db.product.param;

import com.leo.fly.web.form.BaseQueryForm;
import lombok.Data;

import java.util.List;

@Data
public class ProductQueryForm extends BaseQueryForm<ProductQueryParam> {
    private Long id;
    private String name;
    private String oe;
    private String carBrand;
    private Integer status;
    private String code;
    private String attributeName;
    private Long categoryId;
    /**
     * 1688 1688, local local
     */
    private String website;

    private Integer[] lcGroup;
    private String subject;
    /**
     * localhost internet
     */
    private String location;

    private Long groupId;

    private List<Long> groupIdList;

    private List<String> columns;

    private String referStatus;

    private List<Long> idList;
}
