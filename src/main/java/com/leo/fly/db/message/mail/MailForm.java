package com.leo.fly.db.message.mail;

import com.leo.fly.db.work.entity.Work;
import com.leo.fly.web.form.BaseQueryForm;
import lombok.Data;

@Data
public class MailForm extends BaseQueryForm {
    private String name;

    private String title;

    private String content;

    private String send;

    private String recipient;

    private Work work;
}
