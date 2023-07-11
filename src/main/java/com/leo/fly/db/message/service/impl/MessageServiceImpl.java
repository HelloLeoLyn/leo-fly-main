package com.leo.fly.db.message.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.message.entity.Message;
import com.leo.fly.db.message.mapper.MessageMapper;
import com.leo.fly.db.message.params.MessageQueryParam;
import com.leo.fly.db.message.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
    @Override
    public Page<Message> page(Page page, MessageQueryParam params) {
        LambdaQueryWrapper<Message> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getId()),Message::getId,params.getId());
		queryWrapper.eq(StringUtils.isNotBlank(params.getType()),Message::getType,params.getType());
		queryWrapper.eq(StringUtils.isNotBlank(params.getName()),Message::getName,params.getName());
		queryWrapper.eq(StringUtils.isNotBlank(params.getTitle()),Message::getTitle,params.getTitle());
		queryWrapper.eq(StringUtils.isNotBlank(params.getContent()),Message::getContent,params.getContent());
		queryWrapper.eq(StringUtils.isNotBlank(params.getSend()),Message::getSend,params.getSend());
		queryWrapper.eq(StringUtils.isNotBlank(params.getRecipient()),Message::getRecipient,params.getRecipient());
        return this.page(page, queryWrapper);
    }
}
