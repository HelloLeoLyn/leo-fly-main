package com.leo.fly.db.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.product.entity.ProductAttributes;
import com.leo.fly.db.product.mapper.ProductAttributesMapper;
import com.leo.fly.db.product.param.ProductAttributesParam;
import com.leo.fly.db.product.service.ProductAttributesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-05
 */
@Service
public class ProductAttributesServiceImpl extends ServiceImpl<ProductAttributesMapper, ProductAttributes> implements ProductAttributesService {

    @Override
    public void deleteByProductId(Long productId) {
        QueryWrapper<ProductAttributes> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ProductAttributes::getProductId,productId);
        remove(wrapper);
    }

    @Override
    public void deleteByProductId(Long productId, String attributeName) {
        QueryWrapper<ProductAttributes> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ProductAttributes::getProductId,productId);
        wrapper.lambda().eq(ProductAttributes::getAttributeName,attributeName);
        remove(wrapper);

    }

    @Override
    public void deleteByProductId(List<Long> idList) {
        QueryWrapper<ProductAttributes> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(ProductAttributes::getProductId,idList);
        remove(wrapper);
    }

    @Override
    public List<ProductAttributes> query(ProductAttributesParam param) {
        QueryWrapper<ProductAttributes> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ObjectUtils.isNotEmpty(param.getProductId()),ProductAttributes::getProductId,param.getProductId());
        wrapper.lambda().eq(StringUtils.isNotBlank(param.getAttributeName()),ProductAttributes::getAttributeName,param.getAttributeName());
        wrapper.lambda().like(StringUtils.isNotBlank(param.getValue()),ProductAttributes::getValue,param.getValue());
        return list(wrapper);
    }

    @Override
    public List<ProductAttributes> findByProductIds(Set<Long> idList) {
        QueryWrapper<ProductAttributes> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(ProductAttributes::getProductId,idList);
        return list(wrapper);
    }

    @Override
    public List<ProductAttributes> findByProductId(Long id) {
        QueryWrapper<ProductAttributes> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ProductAttributes::getProductId,id);
        return list(wrapper);
    }

    @Override
    public List<ProductAttributes> findByValue(String value) {
        QueryWrapper<ProductAttributes> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(ProductAttributes::getValue,value);
        return list(wrapper);
    }

    @Override
    public void update(Long productId, List<String> values, String type) {
        this.deleteByProductId(productId,type);
        List<ProductAttributes> attributesList = new ArrayList<>();
        for (String value :
                values) {
            ProductAttributes attr = new ProductAttributes();
            attr.setAttributeName(type);
            attr.setProductId(productId);
            attr.setValue(value);
        }
        this.saveBatch(attributesList);
    }
}
