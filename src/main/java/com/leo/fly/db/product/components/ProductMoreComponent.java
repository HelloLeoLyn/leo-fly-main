package com.leo.fly.db.product.components;

import com.leo.fly.common.util.BeanUtils;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.db.product.entity.Product;
import com.leo.fly.db.product.entity.ProductJson;
import com.leo.fly.db.product.param.ProductVo;
import com.leo.fly.db.product.service.ProductJsonService;
import com.leo.fly.db.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMoreComponent {
    @Autowired
    ProductService productService;
    @Autowired
    ProductJsonService productJsonService;
    @Autowired
    ImageService imageService;

    public ProductVo getById(long id) {
        Product product = productService.getById(id);
        List<ProductJson> jsonList = productJsonService.findByProductId(id);
        ProductVo vo = new ProductVo();
        BeanUtils.copyProperties(product,vo);
        vo.setJsonList(jsonList);
        List<Image> images = imageService.getByCode(product.getId()+"",1);
        vo.setImages(images);
        return vo;
    }

}
