package com.leo.fly.db.collection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.db.collection.entity.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface CollectionMapper extends BaseMapper<Collection> {

}
