package com.leo.fly.db.warehouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.db.warehouse.entity.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface WarehouseMapper extends BaseMapper<Warehouse> {

}
