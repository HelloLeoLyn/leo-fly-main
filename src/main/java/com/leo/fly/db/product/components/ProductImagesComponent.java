package com.leo.fly.db.product.components;

import com.leo.fly.baidu.utils.FileUtil;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.db.product.entity.Product;
import com.leo.fly.db.product.param.ProductEditForm;
import com.leo.fly.db.product.service.ProductAttributesService;
import com.leo.fly.db.product.service.ProductService;
import com.leo.fly.python.components.ImageStandardPsComponent;
import com.leo.fly.python.params.PythonImageParams;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductImagesComponent {
    @Autowired
    ProductService productService;

    @Autowired
    ProductAttributesService attributesService;
    @Autowired
    ImageService imageService;

    @Autowired
    ImageStandardPsComponent imageStandardPsComponent;
    @Value("${file.photo.dir}")
    String imageBaseDir;
    public void saveMain(ProductEditForm form){
        Product product = productService.getById(form.getId());
        Image image = new Image();
        if(StringUtils.isNotBlank(product.getMainImage())){
            image.setId(Long.parseLong(product.getMainImage()));
            image.setIsMain(false);
            imageService.updateById(image);
        }
        image.setId(Long.parseLong(form.getMainImage()));
        image.setIsMain(true);
        imageService.updateById(image);
        product.setMainImage(form.getMainImage());
        productService.updateById(product);
    }

    @Async
    public void addImages(Long id, List<String> imagesUrl, String type){
        List<Image> imageList = new ArrayList<>();
        if(type.equals("group")){
            for (String url :imagesUrl){
                Image image = saveImage(url, imageBaseDir + id,id);
                imageList.add(image);
            }
            imageService.updateBatchById(imageList);
            PythonImageParams params = new PythonImageParams();
            params.setImages(imageList);
            params.setMiddle(false);
            params.setCenterLogo(false);
            params.setMiniLogo(false);
            params.setLarge(true);
            params.setWhite(true);
            params.setMini(true);
            imageStandardPsComponent.execute(params);
            Product product = new Product();
            product.setId(id);
            product.setImages(imageList.stream().map(image->image.getId()).collect(Collectors.toList()));
            product.setMainImage(imageList.get(0).getId()+"");
            productService.updateById(product);
        }
    }

    @SneakyThrows
    private Image saveImage(String url, String targetPath, Long productId) {
        Image image  = new Image();
        image.setCode(productId+"");
        String fileType = url.substring(url.lastIndexOf("."));
        image.setStatus(1);
        image.setFileType(fileType);
        image.setType("PE");
        imageService.save(image);
        image.setName(image.getId()+fileType);
        image.setPath(imageBaseDir+productId+"/"+image.getId() + fileType);
        FileUtil.downLoadByUrl(url, targetPath, image.getId() + fileType);
        return image;
    }
}
