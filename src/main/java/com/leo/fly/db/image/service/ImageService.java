package com.leo.fly.db.image.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.form.ImageQueryParam;

import java.util.List;

/**
 * <p>
 * 图片表 服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-02
 */
public interface ImageService extends IService<Image> {

    List<Image> getByCode(String code);

    List<Image> getByCode(String code, List<Integer> status);

    List<Number> getIdsByCode(String code);

    Page<Image> page(Page page, ImageQueryParam queryParam);

    String getMainImageWithProductId(Long productId, String pixel);

    void saveOrUpdateByCode(String code);

    void deleteByCode(String code);

    void delete(String code ,List<Number> idList);
}
