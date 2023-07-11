package com.leo.fly.db.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.product.entity.Product;
import com.leo.fly.db.product.entity.ProductAttributes;
import com.leo.fly.db.product.mapper.ProductMapper;
import com.leo.fly.db.product.param.ProductAttributesParam;
import com.leo.fly.db.product.param.ProductQueryParam;
import com.leo.fly.db.product.service.ProductAttributesService;
import com.leo.fly.db.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    ProductAttributesService attributesService;
    @Override
    public Page query(Page page, ProductQueryParam params) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ObjectUtils.isNotEmpty(params.getId()),Product::getId,params.getId());
        if(StringUtils.isNotBlank(params.getCode())) {
            LambdaQueryWrapper<ProductAttributes> attrWrapper = new LambdaQueryWrapper<>();
            attrWrapper.like(ProductAttributes::getValue,params.getCode().toUpperCase());
            ProductAttributesParam attrParams = new ProductAttributesParam();
            attrParams.setValue(params.getCode());
            attrParams.setAttributeName(params.getAttributeName());
            List<ProductAttributes> attrList = attributesService.query(attrParams);
            if(!attrList.isEmpty()) {
                List<Long> idList = attrList.stream().map(p -> p.getProductId()).collect(Collectors.toList());
                queryWrapper.lambda().in(Product::getId,idList);
            } else {
                queryWrapper.lambda().like(Product::getCode,params.getCode());
//                return page;
            }
        }
        if(params.getStatus() != null && params.getStatus()!=-1){
            queryWrapper.lambda().eq(Product::getStatus, params.getStatus());
        }
        if(ObjectUtils.isNotEmpty(params.getColumns())) {
            queryWrapper.lambda().select(Product.class,product->params.getColumns().contains(product.getColumn()));
        }
        queryWrapper.lambda().eq(StringUtils.isNotBlank(params.getReferStatus()),Product::getReferStatus,params.getReferStatus());
        queryWrapper.lambda().eq(ObjectUtils.isNotEmpty(params.getCategoryId()),Product::getCategoryId,params.getCategoryId());
        queryWrapper.lambda().like(StringUtils.isNotBlank(params.getSubject()),Product::getSubject,params.getSubject());
        queryWrapper.lambda().like(StringUtils.isNotBlank(params.getName()),Product::getName,params.getName());
        page = this.page(page, queryWrapper);
        return page;
    }

    @Override
    public List<Product> list(ProductQueryParam params) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ObjectUtils.isNotEmpty(params.getId()),Product::getId,params.getId());
        if(StringUtils.isNotBlank(params.getCode())) {
            LambdaQueryWrapper<ProductAttributes> attrWrapper = new LambdaQueryWrapper<>();
            attrWrapper.like(ProductAttributes::getValue,params.getCode().toUpperCase());
            ProductAttributesParam attrParams = new ProductAttributesParam();
            attrParams.setValue(params.getCode());
            List<ProductAttributes> attrList = attributesService.query(attrParams);
            if(!attrList.isEmpty()) {
                List<Long> idList = attrList.stream().map(p -> p.getProductId()).collect(Collectors.toList());
                queryWrapper.lambda().in(Product::getId,idList);
            } else {
                return this.list(queryWrapper);
            }
        }
        if(params.getStatus() != null && params.getStatus()!=-1){
            queryWrapper.lambda().eq(Product::getStatus, params.getStatus());
        }
        if(ObjectUtils.isNotEmpty(params.getColumns())) {
            queryWrapper.lambda().select(Product.class,product->params.getColumns().contains(product.getColumn()));
        }
        queryWrapper.lambda().like(StringUtils.isNotBlank(params.getSubject()),Product::getSubject,params.getSubject());
        queryWrapper.lambda().like(StringUtils.isNotBlank(params.getName()),Product::getName,params.getName());
        return this.list(queryWrapper);
    }

    @Override
    public List<Product> getByCode(String code) {
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.like(Product::getCode, code);
        return list(queryWrapper);
    }

    @Override
    public List<Product> findByStatus(int status) {
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Product::getStatus, status);
        return this.list(queryWrapper);
    }
}
