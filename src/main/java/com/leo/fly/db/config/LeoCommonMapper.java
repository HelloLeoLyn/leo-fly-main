package com.leo.fly.db.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.auto.code.params.TableParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface  LeoCommonMapper extends BaseMapper {
    @Select("select val from leo_seq where name=#{name}")
    Long getSequence(@Param("name") String name);

    @Select("select nextval(#{name})")
    Long getNextSequence(@Param("name") String name);

    @Select("SELECT  TABLE_NAME name,TABLE_COMMENT comment FROM information_schema.tables WHERE TABLE_SCHEMA = #{param.schema} ORDER BY TABLE_NAME")
    List<Map<String,String>> tables(@Param(value = "param") TableParam param);

    @Select("SELECT COLUMN_NAME, ORDINAL_POSITION, COLUMN_DEFAULT, IS_NULLABLE, DATA_TYPE, COLUMN_TYPE, COLUMN_KEY,EXTRA, COLUMN_COMMENT, CHARACTER_MAXIMUM_LENGTH FROM information_schema.`COLUMNS` WHERE TABLE_SCHEMA=#{param.schema} AND TABLE_NAME= #{param.name}")
    List<Map<String,String>> info(@Param(value = "param") TableParam param);


}
