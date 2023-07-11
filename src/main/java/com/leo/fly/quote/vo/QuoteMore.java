package com.leo.fly.quote.vo;

import com.leo.fly.db.quote.entity.Quote;
import com.leo.fly.db.quote.items.entity.QuoteItems;
import lombok.Data;

import java.util.List;

@Data
public class QuoteMore extends Quote {
    private List<QuoteItems> items;
}
