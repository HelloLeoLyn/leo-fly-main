package com.leo.fly.db.tag.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.db.tag.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

}
