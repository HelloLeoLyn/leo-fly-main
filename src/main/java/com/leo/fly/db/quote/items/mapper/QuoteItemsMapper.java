package com.leo.fly.db.quote.items.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.db.quote.items.entity.QuoteItems;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface QuoteItemsMapper extends BaseMapper<QuoteItems> {

}
