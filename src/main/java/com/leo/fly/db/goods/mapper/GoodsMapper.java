package com.leo.fly.db.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.db.goods.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

}
