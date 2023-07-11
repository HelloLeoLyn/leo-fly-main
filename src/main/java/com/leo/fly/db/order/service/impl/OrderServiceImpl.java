package com.leo.fly.db.order.service.impl;

import com.leo.fly.db.order.entity.Order;
import com.leo.fly.db.order.mapper.OrderMapper;
import com.leo.fly.db.order.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-02
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
