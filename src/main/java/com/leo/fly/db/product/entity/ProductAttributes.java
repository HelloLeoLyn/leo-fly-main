package com.leo.fly.db.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leo_product_attributes")
public class ProductAttributes implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "attribute_id", type = IdType.AUTO)
    private Long attributeId;

    private String attributeName;

    private String value;

    private Long valueId;

    private Long productId;


}
