package com.leo.fly.db.product.alibaba.attributes;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductAlibabaAttributesServiceImpl extends ServiceImpl<ProductAlibabaAttributesMapper, ProductAlibabaAttributes> implements ProductAlibabaAttributesService {
    @Override
    public boolean deleteByProductId(Long productId) {
        LambdaQueryWrapper<ProductAlibabaAttributes> delete = new LambdaQueryWrapper<>();
        delete.eq(ProductAlibabaAttributes::getParentId, productId);
        return this.remove(delete);
    }

    @Override
    public boolean deleteByParentId(Long parentId) {
        LambdaQueryWrapper<ProductAlibabaAttributes> delete = new LambdaQueryWrapper<>();
        delete.eq(ProductAlibabaAttributes::getParentId, parentId);
        return this.remove(delete);
    }

    @Override
    public boolean deleteByProductId(Long productId, boolean loop) {
        HashSet<Long> idList = new HashSet<>();
        List<ProductAlibabaAttributes> list = getByProductId(productId);
        list.forEach(p-> getAndPush(idList,p.getId()));
        return this.removeByIds(idList);
    }

    @Override
    public boolean deleteByParentId(Long productId, boolean loop) {
        HashSet<Long> idList = new HashSet<>();
        getAndPush(idList,productId);
        return this.removeByIds(idList);
    }

    @Override
    public List<ProductAlibabaAttributes> getByProductId(Long productId, boolean loop) {
        List<ProductAlibabaAttributes> productList = this.getByProductId(productId);
        productList.forEach(productAlibabaAttributes -> {
            if (!productAlibabaAttributes.getIsLeaf()) {
                List<ProductAlibabaAttributes> children = getByParentId(productAlibabaAttributes.getId(), loop);
                productAlibabaAttributes.setChildren(children);
            }
        });
        return productList;
    }
    private void getAndPush(Set<Long> idList,Long parentId){
        LambdaQueryWrapper<ProductAlibabaAttributes> query = new LambdaQueryWrapper<>();
        query.select(ProductAlibabaAttributes::getIsLeaf,ProductAlibabaAttributes::getId);
        query.eq(ProductAlibabaAttributes::getParentId, parentId);
        List<ProductAlibabaAttributes> list = this.list(query);
        list.forEach(p->{
            if(p.getIsLeaf()){
                idList.add(p.getId());
            }else{
                getAndPush(idList,p.getId());
            }
        });
    }


    @Override
    public List<ProductAlibabaAttributes> getByProductId(Long productId) {
        LambdaQueryWrapper<ProductAlibabaAttributes> query = new LambdaQueryWrapper<>();
        query.eq(ProductAlibabaAttributes::getProductId, productId);
        return this.list(query);
    }

    @Override
    public List<ProductAlibabaAttributes> getByParentId(Long parentId) {
        LambdaQueryWrapper<ProductAlibabaAttributes> query = new LambdaQueryWrapper<>();
        query.eq(ProductAlibabaAttributes::getParentId, parentId);
        return list(query);
    }

    @Override
    public List<ProductAlibabaAttributes> getByParentId(Long parentId, boolean loop) {
        List<ProductAlibabaAttributes> productList = this.getByParentId(parentId);
        productList.forEach(productAlibabaAttributes -> {
            if (!productAlibabaAttributes.getIsLeaf()) {
                List<ProductAlibabaAttributes> children = getByParentId(productAlibabaAttributes.getId(), loop);
                productAlibabaAttributes.setChildren(children);
            }
        });
        return productList;
    }
}
