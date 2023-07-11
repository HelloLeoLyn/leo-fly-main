package com.leo.fly.db.stock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.db.stock.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface StockMapper extends BaseMapper<Stock> {

}
