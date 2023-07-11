package com.leo.fly.common.util;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;

public class HtmlGenerator {
    public static void main(String[] args) {
        // 创建Thymeleaf模板引擎
        TemplateEngine templateEngine = new TemplateEngine();

        // 创建模板解析器
        FileTemplateResolver templateResolver = new FileTemplateResolver();
        templateResolver.setPrefix("/path/to/templates/"); // 设置模板文件所在的目录路径
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateEngine.setTemplateResolver(templateResolver);

        // 创建数据模型
//        List<Person> people = new ArrayList<>();
//        people.add(new Person("Alice", 25, "New York"));
//        people.add(new Person("Bob", 30, "London"));
//        people.add(new Person("Charlie", 28, "Paris"));

        Context context = new Context();
        context.setVariable("people", null);

        // 使用模板引擎生成HTML
        String html = templateEngine.process("template", context);
        System.out.println(html);
    }
}