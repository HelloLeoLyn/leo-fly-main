package com.leo.fly.db.product.mapper;

import com.leo.fly.db.product.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {

}
