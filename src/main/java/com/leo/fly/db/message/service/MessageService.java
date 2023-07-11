package com.leo.fly.db.message.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.message.entity.Message;
import com.leo.fly.db.message.params.MessageQueryParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
public interface MessageService extends IService<Message> {
    Page<Message> page(Page page, MessageQueryParam toParam);
}
