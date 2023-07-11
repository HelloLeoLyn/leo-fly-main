package com.leo.fly.spider;

import com.alibaba.fastjson.JSONObject;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.db.product.components.ProductCollectorComponent;
import com.leo.fly.db.product.entity.Product;
import com.leo.fly.db.product.param.ProductQueryParam;
import com.leo.fly.db.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spider")
public class SpiderController {
    @Autowired
    AlibabaSpider alibabaSpider;

    @Autowired
    AlibabaJsoup alibabaJsoup;
    @Autowired
    EbaySpider ebaySpider;

    @Autowired
    YiPeiSpider yiPeiSpider;
    @Autowired
    ProductService productService;

    @Autowired
    ProductCollectorComponent collectorComponent;

    @PostMapping("/alibaba")
    public JsonResult alibaba(@RequestBody SpiderForm spiderForm) {
        Product product = productService.getById(spiderForm.getId());
        if (spiderForm.getModel().equals("jsoup")) {
            if (spiderForm.getIsShop()) {
            } else {
                if (spiderForm.getIsSearchItems()) {
                    JSONObject json = alibabaJsoup.getByDetailUrl(spiderForm);
                    collectorComponent.execute(product, json, spiderForm);
                    return JsonResult.success();
                } else {
                }
            }
        } else {
            if (spiderForm.getIsShop()) {
            } else {
                if (spiderForm.getIsSearchItems()) {
                } else {
                }
            }
        }
        return JsonResult.success();
    }

    @PostMapping("/yipei")
    public JsonResult yipei(@RequestBody SpiderForm spiderForm) {
        JSONObject result = yiPeiSpider.execute(spiderForm);
        return JsonResult.success(result);
    }

    @PostMapping("/image")
    public JsonResult image(@RequestBody SpiderForm spiderForm) {
        Product product = productService.getById(spiderForm.getId());
        collectorComponent.saveImages(spiderForm, product);
        return JsonResult.success();
    }
    @PostMapping("/ebay")
    public JsonResult ebay(@RequestBody SpiderForm spiderForm) {
        if(spiderForm.getDataType().equals("image")){
            List<String> images = ebaySpider.getImagesByJsoup(spiderForm.getDetailUrl());
            return JsonResult.success(images);
        }else{
            return JsonResult.success(ebaySpider.getItemsByJsoup(spiderForm.getUrl()));
        }
    }
    @PostMapping("/alibaba/items")
    public JsonResult alibabaItems(@RequestBody SpiderForm spiderForm) {
        if (spiderForm.getModel().equals("jsoup")) {
            List list = alibabaJsoup.searchItems(spiderForm);
            if (ObjectUtils.isEmpty(list)) {
                Product product = productService.getById(spiderForm.getId());
                product.setStatus(400).setError("not found in alibaba");
                productService.updateById(product);
            }
            return JsonResult.success(list);
        } else {
            List list = alibabaSpider.searchItems(spiderForm);
            return JsonResult.success(list);
        }
    }

    @PostMapping("/yipei/items")
    public JsonResult yipeiItems(@RequestBody SpiderForm spiderForm) {
        List list = yiPeiSpider.searchItems(spiderForm);
        return JsonResult.success(list);
    }

    @PostMapping("/alibaba/image/items")
    public JsonResult alibabaImageItems(@RequestBody SpiderForm spiderForm) {
        List list = alibabaJsoup.searchImageItems(spiderForm);
        return JsonResult.success(list);
    }


    @GetMapping("/bing/jsoup")
    public JsonResult bingJsoup(@RequestParam("code") String code) {
        return JsonResult.success(BingJsoup.getByCode(code));
    }


    @PostMapping("batch")
    public JsonResult batch(@RequestBody SpiderForm spiderForm) {
        ProductQueryParam params = new ProductQueryParam();
        params.setStatus(spiderForm.getStatus());
        params.setName(spiderForm.getName());
        List<Product> list = productService.list(params);
        if (spiderForm.getPlatform().equals("yipei")) {
            if (!yiPeiSpider.isLogin()) {
                throw new ComException(ErrorCodeEnum.E_AUTHORIZED);
            }
            yiPeiSpider.execute(list, spiderForm);
        } else if (spiderForm.getPlatform().equals("alibaba")) {
            if (spiderForm.getIsShop()) {
                if (ObjectUtils.isNotEmpty(list)) {
                    String shopUrl = spiderForm.getShopUrl();
                    for (Product product : list) {
                        spiderForm.setShopUrl(shopUrl + product.getCode().get(0));
                        try {
                            alibabaJsoup.findAndSetDetailUrl(spiderForm);
                        } catch (ComException e) {
                            if (e.getBaseErrorEnum().getCode().equals(ErrorCodeEnum.E_NO_RECORD.getCode())) {
                                productService.updateById(product.setStatus(400).setError("not data in alibabaShopUrl"));
                                continue;
                            }
                        }
                        JSONObject json = alibabaJsoup.getByDetailUrl(spiderForm);
                        collectorComponent.execute(product, json, spiderForm);
                    }
                }
            }
        }
        return JsonResult.success();
    }
}
