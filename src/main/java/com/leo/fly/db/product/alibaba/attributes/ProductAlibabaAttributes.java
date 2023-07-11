package com.leo.fly.db.product.alibaba.attributes;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "leo_product_alibaba_attributes",autoResultMap = true)
public class ProductAlibabaAttributes {
    private Long id;
    private Long parentId;
    private String key;
    private String value;
    private String type;
    private String label;
    private Long productId;
    private Boolean isLeaf;
    @TableField(exist = false)
    private List<ProductAlibabaAttributes> children;
}
