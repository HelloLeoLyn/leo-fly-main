package com.leo.fly.db.quote.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.db.quote.entity.Quote;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface QuoteMapper extends BaseMapper<Quote> {

}
