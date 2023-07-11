package com.leo.fly.db.product.components;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.db.product.entity.Product;
import com.leo.fly.db.product.entity.ProductAttributes;
import com.leo.fly.db.product.param.ProductResetForm;
import com.leo.fly.db.product.service.ProductAttributesService;
import com.leo.fly.db.product.service.ProductJsonService;
import com.leo.fly.db.product.service.ProductService;
import com.leo.fly.db.warehouse.entity.Warehouse;
import com.leo.fly.db.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProductResetComponent {
    @Autowired
    ProductService productService;
    @Autowired
    ProductJsonService productJsonService;
    @Autowired
    ImageService imageService;
    @Autowired
    ProductAttributesService attributesService;
    @Autowired
    WarehouseService warehouseService;

    public void execute(ProductResetForm resetForm) {
        if (resetForm.getJson()) {
            productJsonService.deleteByProductId(resetForm.getId());
        }
        Product product = null;
        if (resetForm.getImage()) {
            product = new Product();
            product.setId(resetForm.getId());
            product.setImages(new ArrayList<>());
            imageService.deleteByCode(resetForm.getId() + "");
        }
        if (resetForm.getRefNo()) {
            LambdaQueryWrapper<ProductAttributes> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ProductAttributes::getProductId, resetForm.getId());
            wrapper.eq(ProductAttributes::getAttributeName, "refNo");
            if (product == null) {
                product = new Product();
                product.setId(resetForm.getId());
            }
            product.setRefNo(new ArrayList<>());
            attributesService.remove(wrapper);
        }
        if (resetForm.getOe()) {
            LambdaQueryWrapper<ProductAttributes> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ProductAttributes::getProductId, resetForm.getId());
            wrapper.eq(ProductAttributes::getAttributeName, "oe");
            if (product == null) {
                product = new Product();
                product.setId(resetForm.getId());
            }
            product.setRefNo(new ArrayList<>());
            attributesService.remove(wrapper);
        }
        LambdaQueryWrapper<Warehouse> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.select(Warehouse::getNno, Warehouse::getProductId).groupBy(Warehouse::getNno, Warehouse::getProductId);
        lambdaQueryWrapper.eq(Warehouse::getProductId, resetForm.getId());
        List<Warehouse> list = warehouseService.list(lambdaQueryWrapper);
        if (ObjectUtils.isNotEmpty(list)) {
            List<ProductAttributes> npalist = new ArrayList();
            for (Warehouse w :
                    list) {
                ProductAttributes npa = new ProductAttributes();
                npa.setValue(w.getNno().replaceAll(" ", ""));
                npa.setProductId(w.getProductId());
                npa.setAttributeName("oe");
                npalist.add(npa);
            }
            product.setCode(npalist.stream().map(w->w.getValue()).collect(Collectors.toList()));
            attributesService.saveBatch(npalist);
        }

        if (product != null) {
            productService.updateById(product);
        }
    }
}
