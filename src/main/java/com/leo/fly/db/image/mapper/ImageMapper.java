package com.leo.fly.db.image.mapper;

import com.leo.fly.db.image.entity.Image;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 图片表 Mapper 接口
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-02
 */
@Repository
@Mapper
public interface ImageMapper extends BaseMapper<Image> {
    @Select("select id, path, src_type, code, file_type from leo_image where id=(select main_image from leo_product where id=#{productId})")
    Image getMainImageByProductId(@Param("productId") long productId);
}
