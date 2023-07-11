package com.leo.fly.db.message.mail;

import lombok.Data;

@Data
public class MailSendParam {
    private String name;

    private String title;

    private String content;

    private String send;

    private String recipient;
}
