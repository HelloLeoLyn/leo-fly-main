package com.leo.fly.db.goods.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.goods.entity.Goods;
import com.leo.fly.db.goods.mapper.GoodsMapper;
import com.leo.fly.db.goods.params.GoodsQueryParam;
import com.leo.fly.db.goods.params.GoodsTemplateParams;
import com.leo.fly.db.goods.service.GoodsService;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import java.util.List;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Override
    public Page<Goods> page(Page page, GoodsQueryParam params) {
        LambdaQueryWrapper<Goods> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getId()),Goods::getId,params.getId());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getProductId()),Goods::getProductId,params.getProductId());
		queryWrapper.eq(StringUtils.isNotBlank(params.getPlatform()),Goods::getPlatform,params.getPlatform());
		queryWrapper.eq(StringUtils.isNotBlank(params.getSubject()),Goods::getSubject,params.getSubject());
		queryWrapper.eq(StringUtils.isNotBlank(params.getImages()),Goods::getImages,params.getImages());
		queryWrapper.eq(StringUtils.isNotBlank(params.getMainImage()),Goods::getMainImage,params.getMainImage());
		queryWrapper.eq(StringUtils.isNotBlank(params.getTag()),Goods::getTag,params.getTag());
        return this.page(page, queryWrapper);
    }

	@Override
	public Object templates(GoodsTemplateParams params) {

		return generateDescription(params.getTarget2(),params.getImages(),params.getModels());
	}
	private String generateDescription(String target2, List<String> images, JSONArray model){
		TemplateEngine templateEngine = new TemplateEngine();
		// 创建模板解析器
		FileTemplateResolver templateResolver = new FileTemplateResolver();
		templateResolver.setPrefix("src/main/resources/templates/"); // 设置模板文件所在的目录路径
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateEngine.setTemplateResolver(templateResolver);

		Context context = new Context();
		context.setVariable("images", images);
		context.setVariable("target2", target2);
		context.setVariable("model", model);
		// 使用模板引擎生成HTML
		String html = templateEngine.process("detail", context);
		System.out.println(html);
		return html;
	}

}
