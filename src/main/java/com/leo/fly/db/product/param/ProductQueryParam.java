package com.leo.fly.db.product.param;

import com.leo.fly.db.product.entity.Product;
import com.leo.fly.web.param.BaseParam;
import lombok.Data;

import java.util.List;

@Data
public class ProductQueryParam extends BaseParam<Product> {
    private Long id;
    private Integer status;
    private String name;
    private String website;
    private Long groupId;
    private List<Long> groupIdList;
    private List<Long> categoryIdList;
    private String subject;
    private Long categoryId;
    private String code;
    private String attributeName;
    private List<Long> idList;
    private String type;
    private List<String> columns;
    private String referStatus;
}
