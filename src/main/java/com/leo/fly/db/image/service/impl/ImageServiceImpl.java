package com.leo.fly.db.image.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.form.ImageQueryParam;
import com.leo.fly.db.image.mapper.ImageMapper;
import com.leo.fly.db.image.service.ImageService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 图片表 服务实现类
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-02
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {


    @Override
    public List<Image> getByCode(String code) {
        LambdaQueryWrapper<Image> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Image::getCode, code);
        List<Image> list = list(queryWrapper);
        list.forEach(image -> setPixel(image));
        return getByCode(code,null);
    }

    @Override
    public List<Image> getByCode(String code, List<Integer> status) {
        LambdaQueryWrapper<Image> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Image::getCode, code);
        if(ObjectUtils.isNotEmpty(status)){
            queryWrapper.in(Image::getStatus,status);
        }
        List<Image> list = list(queryWrapper);
        list.forEach(image -> setPixel(image));
        return list;
    }

    @SneakyThrows
    private void setPixel(Image img){
        if(img.getPixel()==null||img.getPixel().equals("")){
            BufferedImage read = ImageIO.read(new File(img.getPath()));
            img.setPixel(read.getWidth()+"*"+read.getHeight());
            this.updateById(img);
        }
    }
    @Override
    public List<Number> getIdsByCode(String code) {
        LambdaQueryWrapper<Image> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Image::getId).eq(Image::getCode, code);
        List<Image> list = list(queryWrapper);
        if(ObjectUtils.isNotEmpty(list)){
            return list.stream().map(image -> image.getId()).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    public Page<Image> page(Page page, ImageQueryParam queryParam) {
        LambdaQueryWrapper<Image> imageQuery = new LambdaQueryWrapper<>();
        imageQuery.eq(StringUtils.isNotBlank(queryParam.getCode()),Image::getCode,queryParam.getCode());
        imageQuery.eq(StringUtils.isNotBlank(queryParam.getType()),Image::getType,queryParam.getType());
        imageQuery.eq(ObjectUtils.isNotEmpty(queryParam.getStatus()),Image::getStatus,queryParam.getStatus());
        imageQuery.in(ObjectUtils.isNotEmpty(queryParam.getIdList()),Image::getId,queryParam.getIdList());
        imageQuery.like(StringUtils.isNotBlank(queryParam.getName()),Image::getName,queryParam.getName());
        return page(page,imageQuery);
    }

    @Override
    public String getMainImageWithProductId(Long productId,String pixel) {
        Image image = this.baseMapper.getMainImageByProductId(productId);
        return String.format("http://localhost:8080/img/%s/%d_%s%s", image.getCode(), image.getId(), pixel, image.getFileType());
    }

    @Override
    public void saveOrUpdateByCode(String code) {
        LambdaQueryWrapper<Image> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Image::getStatus,-1);
        this.remove(queryWrapper);
        LambdaUpdateWrapper<Image>  updateWrapper = new LambdaUpdateWrapper();
        updateWrapper.set(Image::getStatus,1).eq(Image::getStatus,0);
        this.update(updateWrapper);
    }

    @Override
    public void deleteByCode(String code) {
        List<Image> images = getByCode(code);
        if(ObjectUtils.isNotEmpty(images)){
            List<Long> collect = images.stream().map(i -> i.getId()).collect(Collectors.toList());
            removeByIds(collect);
        }
    }

    @Override
    public void delete(String code, List<Number> idList) {
        LambdaQueryWrapper<Image> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Image::getCode,code);
        wrapper.in(Image::getId,idList);
        this.remove(wrapper);
    }
}
