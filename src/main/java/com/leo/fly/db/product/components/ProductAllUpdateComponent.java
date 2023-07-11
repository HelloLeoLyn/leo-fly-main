package com.leo.fly.db.product.components;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.db.product.entity.Product;
import com.leo.fly.db.product.entity.ProductAttributes;
import com.leo.fly.db.product.service.ProductAttributesService;
import com.leo.fly.db.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductAllUpdateComponent {
    @Autowired
    ProductService productService;
    @Autowired
    ProductAttributesService productAttributesService;
    @Autowired
    ImageService imageService;

    public void execute(Product product) {
        List<ProductAttributes> attributes = new ArrayList<>();
        for (String code : product.getCode()) {
            if (code.trim().length() == 0) {
                continue;
            }
            ProductAttributes attribute = new ProductAttributes();
            attribute.setAttributeName("oe");
            attribute.setValue(code.trim());
            attribute.setProductId(product.getId());
            attributes.add(attribute);
        }
        if (ObjectUtils.isNotEmpty(product.getRefNo())) {
            for (String refNo : product.getRefNo()) {
                if (refNo.trim().length() == 0) {
                    continue;
                }
                ProductAttributes attribute = new ProductAttributes();
                attribute.setAttributeName("refNo");
                attribute.setValue(refNo.trim());
                attribute.setProductId(product.getId());
                attributes.add(attribute);
            }
        }
        productAttributesService.deleteByProductId(product.getId());
        productAttributesService.saveBatch(attributes);
        productService.updateById(product);
        imageService.saveOrUpdateByCode(product.getId() + "");
    }
}
