package com.leo.fly.db.product.alibaba.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.ocean.rawsdk.common.SDKResult;
import com.alibaba.product.param.AlibabaProductProductInfo;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.ailibaba.common.AccessToken;
import com.leo.fly.ailibaba.common.SingletonAccessToken;
import com.leo.fly.ailibaba.photo.PhotoService;
import com.leo.fly.ailibaba.product.*;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.goods.entity.Goods;
import com.leo.fly.db.goods.service.GoodsService;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.db.product.alibaba.entity.ProductAlibaba;
import com.leo.fly.db.product.alibaba.mapper.ProductAlibabaMapper;
import com.leo.fly.db.product.alibaba.params.ProductAlibabaAddForm;
import com.leo.fly.db.product.alibaba.params.ProductAlibabaQueryParam;
import com.leo.fly.db.product.alibaba.service.ProductAlibabaService;
import com.leo.fly.db.product.param.ProductRePostForm;
import com.leo.fly.db.product.service.ProductService;
import com.leo.fly.db.property.service.PropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductAlibabaServiceImpl extends ServiceImpl<ProductAlibabaMapper, ProductAlibaba> implements ProductAlibabaService {
    @Autowired
    ProductService productService;
    @Autowired
    PhotoService photoService;
    @Autowired
    PropertyService propertyService;
    @Autowired
    ImageService imageService;
    @Autowired
    GoodsService goodsService;

    @Override
    public Page<ProductAlibaba> page(Page page, ProductAlibabaQueryParam params) {
        LambdaQueryWrapper<ProductAlibaba> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ObjectUtils.isNotEmpty(params.getProductID()), ProductAlibaba::getProductID, params.getProductID());
        queryWrapper.eq(ObjectUtils.isNotEmpty(params.getLocalProductId()), ProductAlibaba::getLocalProductId, params.getLocalProductId());
        queryWrapper.eq(StringUtils.isNotBlank(params.getProductType()), ProductAlibaba::getProductType, params.getProductType());
        queryWrapper.eq(ObjectUtils.isNotEmpty(params.getCategoryID()), ProductAlibaba::getCategoryID, params.getCategoryID());
        queryWrapper.eq(StringUtils.isNotBlank(params.getGroupId()), ProductAlibaba::getGroupID, params.getGroupId());
        queryWrapper.eq(StringUtils.isNotBlank(params.getStatus()), ProductAlibaba::getStatus, params.getStatus());
        queryWrapper.like(StringUtils.isNotBlank(params.getSubject()), ProductAlibaba::getSubject, params.getSubject());
        queryWrapper.eq(StringUtils.isNotBlank(params.getLanguage()), ProductAlibaba::getLanguage, params.getLanguage());
        queryWrapper.eq(ObjectUtils.isNotEmpty(params.getBizType()), ProductAlibaba::getBizType, params.getBizType());
        return this.page(page, queryWrapper);
    }

    @Override
    public boolean remove(Long productID, int optType) {
        if (optType == 1) {
            ProductDeleteParam productParam = new ProductDeleteParam();
            productParam.setProductID(productID);
            if (SingletonAccessToken.getAccessToken().getToken() != null) {
                AccessToken accessToken = SingletonAccessToken.getAccessToken();
                ProductDeleteResult result = (ProductDeleteResult) accessToken.getApiExecutor().execute(productParam, accessToken.getToken().getAccess_token()).getResult();
                if (result != null && !result.getIsSuccess()) {
                    throw new ComException(ErrorCodeEnum.E_OTHERS, result.getReason());
                }
            } else {
                log.info("refreshToken授权过期...返回null");
                throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
            }
        }
        return this.removeById(productID);
    }

    @Override
    public void add(ProductAlibaba productAlibaba) {
        this.sendTo1688(productAlibaba);
        Goods goods = goodsService.getById(productAlibaba.getId());
        goodsService.updateById(goods);
    }

    private void sendTo1688(ProductAlibaba productAlibaba) {
        ProductAddParam productParam = new ProductAddParam();
        AccessToken accessToken = SingletonAccessToken.getAccessToken();
        if (accessToken.getToken() != null) {
            productParam.setProductType(productAlibaba.getProductType());
            productParam.setCategoryID(productAlibaba.getCategoryID());
            productParam.setAttributes(productAlibaba.getAttributes());
            List<Long> groupID = productAlibaba.getGroupID().stream().map(num -> num.longValue()).collect(Collectors.toList());
            productParam.setGroupID(groupID);
            productParam.setSubject(productAlibaba.getSubject());
            productParam.setDescription(productAlibaba.getDescription());
            productParam.setLanguage(productAlibaba.getLanguage());
            productParam.setPeriodOfValidity(productAlibaba.getPeriodOfValidity());
            productParam.setBizType(productAlibaba.getBizType());
            productParam.setPictureAuth(productAlibaba.getPictureAuth());
            productParam.setImage(productAlibaba.getImage());
            productParam.setSaleInfo(productAlibaba.getSaleInfo());
            productParam.setShippingInfo(productAlibaba.getShippingInfo());
            productParam.setWebSite(productAlibaba.getWebSite());
            System.out.println(JSONObject.toJSONString(productParam));
            SDKResult<ProductAddResult> execute = accessToken.getApiExecutor().execute(productParam, accessToken.getToken().getAccess_token());
            if (StringUtils.isNotBlank(execute.getErrorMessage())) {
                log.info("发送1688失败:" + execute.getErrorMessage());
                throw new ComException(ErrorCodeEnum.E_1688_PRODUCT_ADD);
            }
            ProductAddResult result = execute.getResult();
            if (result.getErrorMsg() != null) {
                productAlibaba.setStatus("上传失败");
                this.updateById(productAlibaba);
                log.info("发送1688失败:" + result.getErrorMsg());
                throw new ComException(ErrorCodeEnum.E_1688_PRODUCT_ADD, result.getErrorMsg());
            } else {
                productAlibaba.setStatus("上传成功");
                productAlibaba.setProductID(result.getProductID());
                this.updateById(productAlibaba);
                log.info("发送1688成功:" + result.getProductID());
            }
        } else {
            throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
        }
    }

    @Override
    public ProductGetResult get(Long id) {
        ProductGetParam productParam = new ProductGetParam();
        productParam.setProductID(id);
        if (SingletonAccessToken.getAccessToken().getToken() != null) {
            AccessToken accessToken = SingletonAccessToken.getAccessToken();
            ProductGetResult result = (ProductGetResult) accessToken.getApiExecutor().execute(productParam, accessToken.getToken().getAccess_token()).getResult();
            log.info("正确获取1688订单详情:" + result);
            return result;
        }
        log.info("refreshToken授权过期...返回null");
        throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
    }

    @Override
    public void localSave(ProductAlibabaAddForm addForm) {

    }

    @Override
    public ProductPageResult list(ProductListGetParam param) {
        return get1688Product(param);
    }

    private ProductPageResult get1688Product(ProductListGetParam param) {
        if (SingletonAccessToken.getAccessToken().getToken() != null) {
            AccessToken accessToken = SingletonAccessToken.getAccessToken();
            ApiExecutor apiExecutor = accessToken.getApiExecutor();
            SDKResult<ProductListGetResult> execute = apiExecutor.execute(param, accessToken.getToken().getAccess_token());
            if (StringUtils.isNotBlank(execute.getErrorMessage())) {
                throw new ComException(ErrorCodeEnum.E_OTHERS, execute.getErrorMessage());
            }
            ProductListGetResult result = execute.getResult();
            if (result == null) {
                System.out.println();
            }
            if (!result.getSuccess()) {
                throw new ComException(ErrorCodeEnum.E_OTHERS, result.getMessage());
            }
            ProductPageResult pageResult = result.getResult().getPageResult();
            return pageResult;
        } else {
            throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
        }
    }

    @Override
    public void rePost(ProductRePostForm form) {
        if (StringUtils.equals("page", form.getType())) {
            ProductListGetParam listGetParam = new ProductListGetParam();
            for (int i = form.getStartPage(); i <= form.getEndPage(); i++) {
                listGetParam.setPageNo(i);
                listGetParam.setPageSize(form.getSize());
                ProductPageResult product = get1688Product(listGetParam);
                AlibabaProductProductInfo[] resultList = product.getResultList();
                List<Long> longList = Arrays.asList(resultList).stream().map(a -> a.getProductID()).collect(Collectors.toList());
                rePost(longList.toArray(new Long[longList.size()]));
            }
        } else {
            rePost(form.getId().toArray(new Long[form.getId().size()]));
        }
    }

    private SDKResult rePost(Long[] id) {
        ProductRePostParam param = new ProductRePostParam();
        param.setProductIds(id);
        if (SingletonAccessToken.getAccessToken() == null) {
            throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
        }
        if (SingletonAccessToken.getAccessToken().getToken() != null) {
            AccessToken accessToken = SingletonAccessToken.getAccessToken();
            ApiExecutor apiExecutor = accessToken.getApiExecutor();

            SDKResult<ProductRePostResult> execute = apiExecutor.execute(param, accessToken.getToken().getAccess_token());
            if (StringUtils.isNotBlank(execute.getErrorMessage())) {
                throw new ComException(ErrorCodeEnum.E_OTHERS, execute.getErrorMessage());
            }
            log.info("重发结果", JSONObject.toJSONString(execute));
            return execute;
        } else {
            throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
        }

    }
}