package com.leo.fly.quote.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.util.BeanUtils;
import com.leo.fly.common.util.DateUtils;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.db.product.entity.ProductAttributes;
import com.leo.fly.db.product.service.ProductAttributesService;
import com.leo.fly.db.quote.entity.Quote;
import com.leo.fly.db.quote.items.entity.QuoteItems;
import com.leo.fly.db.quote.items.params.QuoteItemsAddForm;
import com.leo.fly.db.quote.items.params.QuoteItemsQueryForm;
import com.leo.fly.db.quote.items.params.QuoteItemsQueryParam;
import com.leo.fly.db.quote.items.params.QuoteItemsUpdateForm;
import com.leo.fly.db.quote.items.service.QuoteItemsService;
import com.leo.fly.db.quote.params.QuoteAddForm;
import com.leo.fly.db.quote.params.QuoteQueryForm;
import com.leo.fly.db.quote.params.QuoteQueryParam;
import com.leo.fly.db.quote.params.QuoteUpdateForm;
import com.leo.fly.db.quote.service.QuoteService;
import com.leo.fly.db.work.service.WorkService;
import com.leo.fly.db.config.LeoCommonMapper;
import com.leo.fly.quote.vo.QuoteMore;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    @Autowired
    ProductAttributesService attributesService;
    @Autowired
    QuoteService quoteService;
    @Autowired
    QuoteItemsService quoteItemsService;
    @Autowired
    LeoCommonMapper leoCommonMapper;
    @Autowired
    ImageService imageService;
    @Autowired
    WorkService workService;
    @PostMapping
    public JsonResult add(@RequestBody QuoteAddForm addForm) {
        //log.debug("name:{}", addForm);
        Quote quote = addForm.toPo(Quote.class);
        return JsonResult.success(quoteService.save(quote));
    }
    @PutMapping()
    public JsonResult update( @Valid @RequestBody QuoteUpdateForm updateForm) {
        Quote byId = quoteService.getById(updateForm.getId());
        if (byId==null) {
            throw new ComException(ErrorCodeEnum.E_NO_RECORD);
        }
        Quote quote = updateForm.toPo(Quote.class);
        quoteService.updateById(quote);
        if(updateForm.getType().equals("T")&&updateForm.getWork()!=null) {
            workService.save(updateForm.getWork().setReferNo(quote.getSeq()));
        }
        if(ObjectUtils.isNotEmpty(updateForm.getItems())){
            quoteItemsService.saveBatch(updateForm.getItems());
        }
        return JsonResult.success();
    }
    @GetMapping(value = "/{id}")
    public JsonResult get(@PathVariable String id) {
        //log.debug("get with id:{}", id);
        Quote quote = quoteService.getById(id);
        QuoteMore quoteMore = new QuoteMore();
        BeanUtils.copyProperties(quote,quoteMore);
        LambdaQueryWrapper<QuoteItems> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(QuoteItems::getQuoteId,quote.getId());
        List<QuoteItems> list = quoteItemsService.list(wrapper);
        quoteMore.setItems(list);
        return JsonResult.success(quoteMore);
    }
    @PostMapping(value = "/page")
    public JsonResult page(@Valid @RequestBody QuoteQueryForm quoteQueryForm) {
        //log.debug("search with quoteQueryForm:{}", quoteQueryForm);
        Page<Quote> page = quoteService.page(quoteQueryForm.getPage(), quoteQueryForm.toParam(QuoteQueryParam.class));
        return JsonResult.success(page);
    }
    @DeleteMapping(value = "/{id}")
    public JsonResult delete(@PathVariable String id) {
        quoteService.removeById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("quote_id",id);
        quoteItemsService.removeByMap(map);
        return JsonResult.success();
    }


    @PostMapping(value = "/items")
    public JsonResult addItem(@RequestBody QuoteItemsAddForm addForm) {
        //log.debug("name:{}", addForm);
        QuoteItems quoteItems = addForm.toPo(QuoteItems.class);
        quoteItemsService.save(quoteItems);
        return JsonResult.success(quoteItems);
    }
    @PostMapping(value = "/items/batch")
    public JsonResult addBatchItem(@RequestBody List<QuoteItemsAddForm> list) {
        //log.debug("name:{}", list);
        List<QuoteItems> items = list.stream().map(quoteItemsAddForm -> quoteItemsAddForm.toPo(QuoteItems.class)).collect(Collectors.toList());
        return JsonResult.success(quoteItemsService.saveBatch(items));
    }
    @PutMapping(value = "/items")
    public JsonResult updateItems( @Valid @RequestBody QuoteItemsUpdateForm updateForm) {
        QuoteItems quoteItems = updateForm.toPo(QuoteItems.class);
        quoteItemsService.updateById(quoteItems);
        return JsonResult.success();
    }
    @GetMapping(value = "/items/{id}")
    public JsonResult getItems(@PathVariable String id) {
        //log.debug("get with id:{}", id);
        return JsonResult.success(quoteItemsService.getById(id));
    }
    @PostMapping(value = "/items/page")
    public JsonResult pageItems(@Valid @RequestBody QuoteItemsQueryForm quoteItemsQueryForm) {
        //log.debug("search with quoteItemsQueryForm:{}", quoteItemsQueryForm);
        Page<QuoteItems> page = quoteItemsService.page(quoteItemsQueryForm.getPage(), quoteItemsQueryForm.toParam(QuoteItemsQueryParam.class));
        return JsonResult.success(page);
    }
    @DeleteMapping(value = "/items/{id}")
    public JsonResult deleteItems(@PathVariable String id) {
        return JsonResult.success(quoteItemsService.removeById(id));
    }

    @GetMapping("/seq")
    public JsonResult getSeq() {
        LambdaQueryWrapper<Quote> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Quote::getStatus,0);
//        queryWrapper.eq(Quote::getOper,'0');
        List<Quote> list = quoteService.list(queryWrapper);
        if(ObjectUtils.isNotEmpty(list)) {
            return JsonResult.success(list.get(0));
        }
        Long leo_quote = leoCommonMapper.getNextSequence("LEO_QUOTE_SEQ");
        String seq = String.format("BJ_%s%06d", DateUtils.getYYYYMMDD(), leo_quote);
        Quote quote = new Quote();
        quote.setSeq(seq).setStatus(0);
        quoteService.save(quote);
        return JsonResult.success(quote);
    }

    @PutMapping("/product/sync")
    public JsonResult productSync(@Param(value = "id") Long id,@Param(value = "code")String code) {
        List<ProductAttributes> productAttributesList = attributesService.findByValue(code);
        if(ObjectUtils.isEmpty(productAttributesList)){
            productAttributesList = attributesService.findByValue(code.replaceAll("-","").toUpperCase());
        }
        if(ObjectUtils.isNotEmpty(productAttributesList)){
            QuoteItems quoteItem = quoteItemsService.getById(id);
            if(quoteItem==null) {
                throw new ComException(ErrorCodeEnum.E_NO_RECORD);
            }
            quoteItem.setProductId(productAttributesList.get(0).getProductId());
            quoteItem.setState(10);
            quoteItem.setSimilarCode(code);
            quoteItemsService.updateById(quoteItem);
            quoteItem.setRemark(productAttributesList.get(0).getValue());
            return JsonResult.success(quoteItem);
        }
        throw new ComException(ErrorCodeEnum.E_NO_RECORD);
    }
}

