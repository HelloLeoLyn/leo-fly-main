package com.leo.fly.db.product.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.leo.fly.baidu.utils.FileUtil;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.db.product.entity.Product;
import com.leo.fly.db.product.param.ProductCollectorForm;
import com.leo.fly.db.product.param.ProductEditForm;
import com.leo.fly.db.product.service.ProductService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product/image")
@Slf4j
public class ProductImageController {
    @Value("${file.photo.dir}")
    private String basePath;
    @Autowired
    ImageService imageService;
    @Autowired
    ProductService productService;

    @DeleteMapping()
    @ResponseBody
    public JsonResult delete(@RequestBody ProductEditForm form) {
        imageService.delete(form.getId() + "",form.getImages());
        return JsonResult.success();
    }


    @GetMapping(value = "/main/{productId}/{pixel}")
    public String mainByProductId(@PathVariable Long productId, @PathVariable String pixel) {
        return "redirect:"+imageService.getMainImageWithProductId(productId, pixel);
    }

    @PutMapping(value = "/main")
    @ResponseBody
    public JsonResult setMain(@RequestParam Long productId,@RequestParam Long imageId) {
        productService.updateById(new Product().setId(productId).setMainImage(String.valueOf(imageId)));
        LambdaUpdateWrapper<Image> updateWrapper = new LambdaUpdateWrapper();
        updateWrapper.set(Image::getIsMain,Boolean.FALSE).eq(Image::getCode,String.valueOf(productId));
        imageService.update(updateWrapper);
        imageService.updateById(new Image().setIsMain(Boolean.TRUE).setId(imageId));
        return JsonResult.success();
    }
    @GetMapping(value = "/{id}/{pixel}")
    public String getById(@PathVariable Long id, @PathVariable String pixel) {
        Image image = imageService.getById(id);
        String format = String.format("redirect:http://localhost:8080/img/%s/%s_%s%s", image.getCode(), image.getId(), pixel, image.getFileType());
        return format;
    }
    @GetMapping(value = "/{id}")
    public String getById(@PathVariable Long id) {
        Image image = imageService.getById(id);
        return String.format("/img/%s/%s%s", image.getCode(), image.getId(),  image.getFileType());
    }
    @SneakyThrows
    @PutMapping(value = "/collector")
    @ResponseBody
    public JsonResult collector(@RequestBody ProductCollectorForm collectorForm) {
        List<String> imageUrls = collectorForm.getImageUrls();
        if (ObjectUtils.isNotEmpty(imageUrls)) {
            for (int i = 0; i < imageUrls.size(); i++) {
                String url = imageUrls.get(i);
                Image image = new Image();
                image.setType("PE");
                image.setCode(collectorForm.getCode());
                image.setStatus(1);

                imageService.save(image);
                String fileType = url.substring(url.lastIndexOf("."));
                FileUtil.downLoadByUrl(url, basePath + collectorForm.getCode(), image.getId() + fileType);
                image.setName(image.getId() + fileType + "");
                image.setPath(basePath + collectorForm.getCode() + "/" + image.getId() + fileType);
                image.setFileType(fileType);
                image.setIcon("/img/" + collectorForm.getCode() + "/" + image.getId() + fileType);
                if (i == imageUrls.size() - 1) {
                    image.setIsMain(true);
                    Product product = new Product();
                    product.setMainImage(image.getId() + "");
                    product.setId(Long.parseLong(collectorForm.getCode()));
                    productService.updateById(product);
                }
                imageService.updateById(image);
            }
        }
        return JsonResult.success();
    }

}

