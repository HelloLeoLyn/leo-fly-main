package com.leo.fly.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.util.JsoupUtils;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import lombok.SneakyThrows;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlibabaJsoup {


    @SneakyThrows
    public void findAndSetDetailUrl(SpiderForm spiderForm) {
        String shopUrl = spiderForm.getShopUrl();
        Document document = JsoupUtils.get(shopUrl);
        Elements productList = document.getElementsByClass("component-product-list");
        if(ObjectUtils.isEmpty(productList)){
            JSONObject jsonObject = getByScript(document);
            if(StringUtils.isBlank(jsonObject.getString("detailUrl"))){
                throw new ComException(ErrorCodeEnum.E_NO_RECORD);
            }
            spiderForm.setDetailUrl(jsonObject.getString("detailUrl"));
            spiderForm.setImageUrls(jsonObject.getJSONArray("images").toJavaList(String.class));
        }else{
            for (Element element: productList){
                String href = element.child(0).getElementsByClass("product-image").get(0).attr("href");
                spiderForm.setDetailUrl("https:"+href);
            }
        }
    }

    private JSONObject getByScript(Document document) {
        Elements scripts = document.getElementsByTag("script");
        JSONObject jsonObject = null;
        for (Element script : scripts) {
            String tag1 = "window.__page__data__config = ";
            String tag2 = "window.__page__data = window.__page__data__config.props";
            int start = script.data().indexOf(tag1);
            int end = script.data().indexOf(tag2);
            if (start >= 0) {
                String data = script.data();
                String str = data.substring(start + tag1.length(), end);
                JSONObject object = JSONObject.parseObject(str);
                JSONObject offerResultData = object.getJSONObject("props").getJSONObject("offerResultData");
                JSONArray offerList = offerResultData.getJSONArray("offerList");
                JSONObject item = offerList.getJSONObject(0);
                String detailUrl = item.getJSONObject("information").getString("productUrl");
                jsonObject.put("detailUrl",detailUrl);
                JSONArray multiImage = item.getJSONObject("image").getJSONArray("multiImage");
                List<String> images = multiImage.toJavaList(String.class).stream().map(img->img.replace("300x300","1000x1000")).collect(Collectors.toList());
                jsonObject.put("images",images);
                break;
            } else {
                continue;
            }
        }
        return jsonObject;
    }

    @SneakyThrows
    public List searchItems(SpiderForm spiderForm) {
        Document document = JsoupUtils.get(spiderForm.getUrl());
        Elements scripts = document.getElementsByTag("script");
        List list = null;
        for (Element script : scripts) {
            String tag1 = "window.__page__data__config = ";
            String tag2 = "window.__page__data = window.__page__data__config.props";
            int start = script.data().indexOf(tag1);
            int end = script.data().indexOf(tag2);
            if (start >= 0) {
                list = new ArrayList();
                String data = script.data();
                String str = data.substring(start + tag1.length(), end);
                JSONObject object = JSONObject.parseObject(str);
                JSONObject offerResultData = object.getJSONObject("props").getJSONObject("offerResultData");
                JSONArray offerList = offerResultData.getJSONArray("offerList");
                if(ObjectUtils.isEmpty(offerList)){
                    return null;
                }
                for (int i = 0; i < offerList.size(); i++) {
                    JSONObject item = offerList.getJSONObject(i);
                    JSONArray multiImage = item.getJSONObject("image").getJSONArray("multiImage");
                    String detailUrl = item.getJSONObject("information").getString("productUrl");
                    String subject = item.getJSONObject("information").getString("title");
                    JSONArray quantityPrices = item.getJSONObject("promotionInfoVO").getJSONArray("quantityPrices");
                    JSONObject child = new JSONObject();
                    child.put("multiImage", multiImage);
                    child.put("detailUrl", detailUrl);
                    child.put("subject", subject);
                    child.put("quantityPrices", quantityPrices);

                    list.add(child);
                }
                break;
            } else {
                continue;
            }
        }
        return list;
    }

    @SneakyThrows
    public JSONObject getByDetailUrl(SpiderForm form) {
        String detailUrl = form.getDetailUrl();
        Document document = JsoupUtils.get(detailUrl);
        Elements scripts = document.getElementsByTag("script");
        JSONObject json = null;
        for (Element script : scripts) {
            String tag1 = "window.detailData = ";
            String tag2 = "window.detailData.scVersion";
            int start = script.data().indexOf(tag1);
            int end = script.data().indexOf(tag2);
            if (start >= 0) {
                json = new JSONObject();
                String data = script.data();
                String str = data.substring(start + tag1.length(), end);
                JSONObject object = JSONObject.parseObject(str);
                JSONObject industry = object.getJSONObject("globalData").getJSONObject("industry");
                if (industry != null) {
                    JSONArray carModels = industry.getJSONObject("carModelData").getJSONArray("carModels");
                    List carFitment = parseCarFitment(carModels);
                    json.put("carFitment", carFitment);
                }
                JSONObject product = object.getJSONObject("globalData").getJSONObject("product");
                List oem = parseCodes(product.getJSONArray("productBasicProperties"), form, "code");
                json.put("code", oem);
                List refNo = parseCodes(product.getJSONArray("productBasicProperties"), form, "refNo");
                json.put("refNo", refNo);
                JSONObject base = parseBase(product.getJSONArray("productBasicProperties"), form);
                json.put("base", base);
                JSONArray mediaItems = product.getJSONArray("mediaItems");
                if(form.getImageUrls()==null){
                    if(!mediaItems.isEmpty()){
                        List<String> images = new ArrayList();
                        for (int i = 0; i < mediaItems.size(); i++) {
                            JSONObject media = mediaItems.getJSONObject(i);
                            if(media.getString("type").equals("image")){
                                images.add(media.getJSONObject("imageUrl").getString("big"));
                            }
                        }
                        json.put("images", images);
                    }
                }else{
                    json.put("images", form.getImageUrls());
                }
                json.put("categoryId", product.getString("productCategoryId"));
                break;
            } else {
                continue;
            }
        }
        return json;
    }

    private JSONObject parseBase(JSONArray product, SpiderForm form) {
        JSONObject obj = new JSONObject();
        for (int i = 0; i < product.size(); i++) {
            JSONObject attr = product.getJSONObject(i);
            JSONObject option = form.getOptions().getJSONObject(attr.getString("attrName"));
            if (ObjectUtils.isNotEmpty(option) && option.getBoolean("checked")) {
                obj.put(option.getString("key"), attr.getString("attrValue"));
            }
        }
        obj.put("subject", form.getSubject());

        return obj;
    }

    private List parseCodes(JSONArray product, SpiderForm form, String key) {
        JSONArray jsonArray = form.getOptions().getJSONObject(key).getJSONArray("key");
        List<String> codes = null;
        for (int i = 0; i < product.size(); i++) {
            int indexOf = jsonArray.indexOf(product.getJSONObject(i).getString("attrName"));
            if (indexOf >= 0) {
                String attrValue = product.getJSONObject(i).getString("attrValue");
                String[] split = attrValue.split(",");
                if (split.length > 0) {
                    codes = new ArrayList<>();
                    for (String code : split) {
                        codes.add(code.trim());
                    }
                }
                break;
            }
        }
        return codes;
    }


    private List parseCarFitment(JSONArray carModels) {
        List list = new ArrayList();
        for (int i = 0; i < carModels.size(); i++) {
            JSONArray item = carModels.getJSONArray(i);
            JSONObject obj = new JSONObject();
            for (int j = 0; j < item.size(); j++) {
                JSONObject attr = item.getJSONObject(j);
                if ("Car Fitment".equals(attr.getString("propertyName"))) {
                    obj.put("model", attr.getString("name"));
                }
                if ("Model".equals(attr.getString("propertyName"))) {
                    if (StringUtils.isNotBlank(obj.getString("model"))) {
                        obj.put("model", obj.getString("model") + " " + attr.getString("name"));
                    } else {
                        obj.put("model", attr.getString("name"));
                    }
                }
                if ("Year".equals(attr.getString("propertyName"))) {
                    obj.put("year", attr.getString("name"));
                }
            }
            list.add(obj);
        }
        return list;
    }


    @SneakyThrows
    public List searchImageItems(SpiderForm spiderForm) {
        Document document = JsoupUtils.get(spiderForm.getUrl());
        Elements scripts = document.getElementsByTag("script");
        List list = null;
        for (Element script : scripts) {
            String tag1 = "window.__page__data__config = ";
            String tag2 = "window.__page__data = window.__page__data__config.props";
            int start = script.data().indexOf(tag1);
            int end = script.data().indexOf(tag2);
            if (start >= 0) {
                list = new ArrayList();
                String data = script.data();
                String str = data.substring(start + tag1.length(), end);
                System.out.println(str);
                JSONObject object = JSONObject.parseObject(str);
                JSONObject offerResultData = object.getJSONObject("props").getJSONObject("offerResultData");
                JSONArray offerList = offerResultData.getJSONArray("offerList");
                if(ObjectUtils.isEmpty(offerList)){
                    break;
                }
                for (int i = 0; i < offerList.size(); i++) {
                    JSONObject item = offerList.getJSONObject(i);
                    JSONArray multiImage = item.getJSONObject("image").getJSONArray("multiImage");
                    list.addAll(multiImage);
                }
                break;
            } else {
                continue;
            }
        }
        return list;
    }
}
