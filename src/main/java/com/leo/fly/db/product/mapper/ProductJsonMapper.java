package com.leo.fly.db.product.mapper;

import com.leo.fly.db.product.entity.ProductJson;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-03
 */
@Mapper
@Repository
public interface ProductJsonMapper extends BaseMapper<ProductJson> {

}
