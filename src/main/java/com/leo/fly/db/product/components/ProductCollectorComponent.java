package com.leo.fly.db.product.components;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.leo.fly.baidu.utils.FileUtil;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.python.components.ImageStandardPsComponent;
import com.leo.fly.db.product.entity.Product;
import com.leo.fly.db.product.entity.ProductAttributes;
import com.leo.fly.db.product.entity.ProductJson;
import com.leo.fly.db.product.service.ProductAttributesService;
import com.leo.fly.db.product.service.ProductJsonService;
import com.leo.fly.db.product.service.ProductService;
import com.leo.fly.python.params.PythonImageParams;
import com.leo.fly.spider.AlibabaSpider;
import com.leo.fly.spider.SpiderForm;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductCollectorComponent {
    @Value("${file.photo.dir}")
    private String basePath;
    @Autowired
    ProductService productService;
    @Autowired
    ProductJsonService jsonService;
    @Autowired
    ImageService imageService;
    @Autowired
    ProductAttributesService attributesService;
    @Autowired
    AlibabaSpider alibabaSpider;
    @Autowired
    ImageStandardPsComponent imageStandardPsComponent;

    @SneakyThrows
    @Transactional
    public void execute(SpiderForm spiderForm) {
        if (ObjectUtils.isNotEmpty(spiderForm.getId())) {
            Product product = productService.getById(spiderForm.getId());
            JSONObject object = alibabaSpider.searchInShopUrl(spiderForm);
            execute(product, object, spiderForm);
        }
    }

    @Transactional
    @SneakyThrows
    public void execute(Product product, JSONObject object, SpiderForm spiderForm) {
        ProductJson json = new ProductJson();
        json.setJson(object);
        json.setProductId(product.getId());
        json.setPlatform("alibaba");
        Collection<ProductAttributes> attributes = new ArrayList<>();
        if (StringUtils.isNotBlank(object.getString("refNo"))) {
            List<String> refNo = Arrays.asList(object.getString("refNo").split(","));
            if (ObjectUtils.isNotEmpty(refNo)) {
                refNo.forEach(c -> {
                    ProductAttributes attr = new ProductAttributes();
                    attr.setValue(c);
                    attr.setProductId(product.getId());
                    attr.setAttributeName("refNo");
                    attributes.add(attr);
                });
                product.setRefNo(refNo);
            }
        }

        List<String> code = Arrays.asList(object.getString("code").split(","));
        if (ObjectUtils.isNotEmpty(code)) {
            code.forEach(c -> {
                ProductAttributes attr = new ProductAttributes();
                attr.setValue(c);
                attr.setProductId(product.getId());
                attr.setAttributeName("oe");
                attributes.add(attr);
            });
        }
        product.setModel(JSON.toJSONString(object.get("carFitment")));
        product.setCategoryId(Long.parseLong(object.getString("categoryId")));
        JSONObject base = object.getJSONObject("base");
        product.setWeight(base.getString("weight"));
        product.setName(base.getString("name"));
        product.setBrand(base.getString("brand"));
        product.setWarranty(base.getString("warranty"));
        product.setStatus(300);
        List<String> images = object.getJSONArray("images").stream().map(e -> e.toString()).collect(Collectors.toList());
        spiderForm.setImageUrls(images);
        spiderForm.setModuleType("PS");
        List<Number> numbers = saveImages(spiderForm,product);
        product.setMainImage(numbers.get(0)+"");
        jsonService.save(json);
        attributesService.saveBatch(attributes);
        productService.updateById(product);
    }

    @SneakyThrows
    @Async
    public List<Number> saveImages(SpiderForm spiderForm,Product product) {
        List<Image> images = new ArrayList<>();
        for (int i = 0; i < spiderForm.getImageUrls().size(); i++) {
            String img = spiderForm.getImageUrls().get(i);
            String fileType = img.substring(img.lastIndexOf("."));
            int indexOf = fileType.indexOf("?");
            if(indexOf>=0){
                fileType = fileType.substring(0,indexOf);
            }
            Image image = new Image();
            image.setType("PE");
            image.setFileType(fileType);
            image.setCode(product.getId() + "");
            image.setStatus(1);
            if (i == 0&&spiderForm.getModuleType().equals("PE")) {
                image.setIsMain(true);
            }
            imageService.save(image);
            image.setName(image.getId() + fileType);
            image.setPath(basePath + product.getId() + "/" + image.getId() + fileType);
            image.setIcon("/img/" + product.getId() + "/" + image.getId() + fileType);
            imageService.updateById(image);
            try{
                FileUtil.downLoadByUrl(spiderForm.getImageUrls().get(i), basePath + product.getId(), image.getId() + fileType);
            }catch (Exception e){
                imageService.removeById(image.getId());
                continue;
            }
            images.add(image);
            if (i == 0) {
                product.setMainImage(image.getId() + "");
            }
        }
        product.setStatus(600);
        productService.updateById(product);
        if (spiderForm.getIsAutoPs()&&ObjectUtils.isNotEmpty(images)) {
            PythonImageParams params = new PythonImageParams();
            params.setImages(images);
            params.setMini(true);
            params.setMiddle(true);
            params.setLarge(true);
            params.setWhite(true);
            params.setMiniLogo(true);
            params.setCenterLogo(true);
            imageStandardPsComponent.execute(params);
        }
        return images.stream().map(image -> image.getId()).collect(Collectors.toList());
    }

}
