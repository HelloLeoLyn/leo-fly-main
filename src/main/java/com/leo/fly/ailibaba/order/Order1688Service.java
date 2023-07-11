package com.leo.fly.ailibaba.order;


import com.leo.fly.web.form.BaseQueryForm;

public interface Order1688Service {


    AlibabaTradeGetSellerOrderListResult list(BaseQueryForm form);
}
