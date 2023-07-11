package com.leo.fly.db.order.mapper;

import com.leo.fly.db.order.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-02
 */
@Repository
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
