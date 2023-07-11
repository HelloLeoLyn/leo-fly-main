package com.leo.fly.db.product.components;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.leo.fly.common.util.MathUtils;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.db.product.entity.Product;
import com.leo.fly.db.product.entity.ProductAttributes;
import com.leo.fly.db.product.mapper.ProductMapper;
import com.leo.fly.db.product.param.ProductMergeForm;
import com.leo.fly.db.product.service.ProductAttributesService;
import com.leo.fly.db.product.service.ProductJsonService;
import com.leo.fly.db.product.service.ProductService;
import com.leo.fly.db.warehouse.entity.Warehouse;
import com.leo.fly.db.warehouse.service.WarehouseService;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductMergeComponent {
    @Autowired
    ProductService productService;
    @Autowired
    ImageService imageService;
    @Autowired
    ProductJsonService productJsonService;
    @Autowired
    ProductAttributesService attributesService;
    @Autowired
    WarehouseService warehouseService;
    @Autowired
    ProductMapper productMapper;
    @Transactional
    public void execute(ProductMergeForm mergeForm){

        mergeForm.getProductIdList();
        List<Product> list = productService.listByIds(mergeForm.getProductIdList());
        if(ObjectUtils.isNotEmpty(list)) {
            list.sort((a,b)-> MathUtils.compare(a.getId(),b.getId()));
            for(Product product : list){
                if(MathUtils.compare(product.getId(),mergeForm.getProductId())!=0){
                    productService.removeById(product.getId());
                    updateImages(product.getId(),mergeForm.getProductId());
                }
            }
            attributesService.deleteByProductId(mergeForm.getProductIdList());
            productJsonService.deleteByProductId(mergeForm.getProductIdList());
            updateWarehouse(mergeForm,mergeForm.getProductId());
            List<ProductAttributes> attributes = mergeForm.getCode().stream().map(code -> {
                ProductAttributes oe = new ProductAttributes().setProductId(mergeForm.getProductId()).setAttributeName("oe").setValue(code);
                return oe;
            }).collect(Collectors.toList());
            attributesService.saveBatch(attributes);
            List<ProductAttributes> attributes2 = mergeForm.getRefNo().stream().map(refNo -> {
                ProductAttributes oe = new ProductAttributes().setProductId(mergeForm.getProductId()).setAttributeName("refNo").setValue(refNo);
                return oe;
            }).collect(Collectors.toList());
            attributesService.saveBatch(attributes2);
            Product product = new Product();
            product.setCode(new ArrayList(mergeForm.getCode()));
            product.setRefNo(new ArrayList(mergeForm.getRefNo()));
            product.setModel(mergeForm.getModel());
            product.setImages(mergeForm.getImages());
            product.setPackageSize(mergeForm.getPackageSize());
            product.setWeight(mergeForm.getWeight());
            productService.updateById(product);
        }
    }

    @Value("${file.photo.dir}")
    String imageBaseDir;
    @SneakyThrows
    private void updateImages(Long srcId, Long targetId) {
        File src = new File(imageBaseDir+srcId);
        if(!src.exists()){
            return;
        }
        File target = new File(imageBaseDir+targetId);
        if(!target.exists()){
            return;
        }
        List<Image> newImages = imageService.getByCode(srcId + "");
        newImages.forEach(image -> {
            image.setPath(imageBaseDir+File.separator+targetId+"/"+image.getName());
            image.setCode(targetId+"");
        });
        imageService.updateBatchById(newImages);
        Arrays.stream(src.listFiles()).forEach( file -> {
            try {
                FileUtils.moveToDirectory(file, target, false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }



    private void updateWarehouse(ProductMergeForm mergeForm, Long productId) {
        UpdateWrapper<Warehouse> updateWrapper = new UpdateWrapper();
        updateWrapper.lambda().set(true,Warehouse::getProductId,mergeForm.getProductId()).in(Warehouse::getProductId,mergeForm.getProductIdList());
        warehouseService.update(updateWrapper);
    }

    public List pre(){
        LambdaQueryWrapper<ProductAttributes> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(ProductAttributes::getValue);
        queryWrapper.eq(ProductAttributes::getAttributeName,"oe");
        queryWrapper.groupBy(ProductAttributes::getValue).having("count(0)>1");
        List<Object> objects = attributesService.listObjs(queryWrapper);
        return objects;
    }
}
