package com.leo.fly.spider;

import com.alibaba.fastjson.JSONObject;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.db.product.entity.Product;
import com.leo.fly.db.product.service.ProductAttributesService;
import com.leo.fly.db.product.service.ProductJsonService;
import com.leo.fly.db.product.service.ProductService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class YiPeiSpider {
    Spider spider;
    @Autowired
    ProductService productService;
    @Autowired
    ProductJsonService jsonService;
    @Autowired
    ProductAttributesService attributesService;
    @Autowired
    ImageService imageService;
    @Value("${file.photo.dir}")
    String imageBaseDir;
    public JSONObject yipei(WebDriver driver) {
        JSONObject result;
        result = new JSONObject();
        WebElement container = driver.findElement(By.id("container"));
        Html html = new Html(container.getAttribute("outerHTML"));
        Selectable modelsetlist = html.xpath("//div[@class='modelsetlist']/div/[@class='card']");
        List list = new ArrayList();
        for (int i = 0; i < modelsetlist.nodes().size(); i++) {
            Selectable model = modelsetlist.nodes().get(i);
            String make = model.xpath("//div[@class='title']/b/text()").get();
            Selectable tables = model.xpath("//table");
            for (int j = 0; j < tables.nodes().size(); j++) {
                Map<String, String> attr = new HashMap<>();
                attr.put("make", make);
                List<Selectable> nodes = tables.nodes().get(j).xpath("//td").nodes();
                for (Selectable td : nodes
                ) {
                    String key = td.xpath("//td/@class").get();
                    String value = td.xpath("//td/text()").get();
                    attr.put(key, value);
                }
                list.add(attr);
            }
        }
        result.put("carFitment", list);
        String xx = html.xpath("//div[@class='numberlist']/div/table/tbody/tr/td/i/text()").get();
        if (StringUtils.isNotBlank(xx) && xx.indexOf("*") > 0) {
            Selectable numberList = html.xpath("//div[@class='numberlist']/div/table");
            Set<String> refNo = new HashSet<>();
            Set<String> code = new HashSet<>();
            for (int i = 0; i < numberList.nodes().size(); i++) {
                Selectable node = numberList.nodes().get(i);
                Selectable tr = node.xpath("//tbody/tr");
                for (int j = 0; j < tr.nodes().size(); j++) {
                    Selectable col = tr.nodes().get(j);
                    String th = col.xpath("//th/text()").get();
                    if (th.equals("OE")) {
                        List<String> td = col.xpath("//td/text()").all();
                        Set<String> temp = td.stream().map(fmsi -> fmsi.replaceAll(" ", "")).collect(Collectors.toSet());
                        code.addAll(temp);
                    } else {
                        List<String> td = col.xpath("//td/text()").all();
                        Set<String> temp = td.stream().map(fmsi -> fmsi.replaceAll(" ", "")).collect(Collectors.toSet());
                        refNo.addAll(temp);
                    }
                }
            }
            result.put("refNo", refNo);
            result.put("code", code);
        }
        List<Selectable> criteria = html.xpath("//div[@class='middlepart']/div[@class='parameter']/ul/li").nodes();
        JSONObject base = new JSONObject();
        for (Selectable temp : criteria) {
            base.put(temp.xpath("//label/text()").get(), temp.xpath("//span/text()").get());
        }
        result.put("base", base);
        return result;
    }


    public JSONObject execute(SpiderForm spiderForm) {
        if (spider == null) {
            spider = new Spider();
        }
        WebDriver driver = spider.getDriver();
        driver.get(spiderForm.getDetailUrl());
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSONObject result;
        if (!spiderForm.getIsThirdPart()) {
            yipei(driver);
            return null;
        } else {
            try {
                WebElement cache = driver.findElement(By.id("cache-main"));
                result = parseDetail(cache.getAttribute("outerHTML"));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return result;
    }

    public void execute(List<Product> products, SpiderForm spiderForm) {
        String url = spiderForm.getUrl();
        for (int i = 0; i < products.size(); i++) {
            if (ObjectUtils.isEmpty(products.get(i).getCode())) {
                productService.updateById(products.get(i).setStatus(410).setError("code is null"));
                continue;
            }
            spiderForm.setCode(products.get(i).getCode().get(0));
            spiderForm.setUrl(url + spiderForm.getCode());
            Map<String, Object> one = searchOne(spiderForm);
            if (ObjectUtils.isEmpty(one) || ObjectUtils.isEmpty(one.get("detailUrl"))) {
                productService.updateById(products.get(i).setStatus(410).setError("cloud not be found in yipei"));
                continue;
            }
            spiderForm.setDetailUrl(one.get("detailUrl") + "");
            execute(spiderForm);
        }
    }

    public JSONObject parseDetail(String str) {
        JSONObject json = new JSONObject();
        Html html = new Html(str);
        String image = html.xpath("//div[@class=\"c-product-image\"]/div/div/a/img/@src").get();
        json.put("main_image", image);
        String subject = html.xpath("//h1[@class=\"c-headline c-headline--xl\"]/text()").get();
        json.put("subject", subject);
        List<Selectable> nodes = html.xpath("//div[@class=\"c-faded-area\"]/span").nodes();
        List<Selectable> criteria = html.xpath("//ul[@class=\"c-product-criteria\"]/li").nodes();
        JSONObject base = new JSONObject();
        for (Selectable temp : criteria) {
            base.put(temp.xpath("//li/text()").get(), temp.xpath("//b/text()").get());
        }
        json.put("base", base);
        for (int i = 0; i < nodes.size(); i++) {
            Selectable key = nodes.get(i);
            String s1 = key.xpath("//span/text()").get();
            if (s1.toUpperCase().indexOf("OE") >= 0) {
                List<String> all = html.xpath("//div[@class=\"c-faded-area\"]/div[" + (i + 1) + "]/div/div/text()").all();
                Set<String> oem = all.stream().map(oe -> oe.replace(" ", "")).collect(Collectors.toSet());
                json.put("code", oem);
            } else if (s1.equals("参考号") || s1.equals("Reference Numbers")) {
                List<Selectable> children = html.xpath("//div[@class=\"c-faded-area\"]/div[" + (i + 1) + "]/div/div").nodes();
                List refNo = new ArrayList();
                for (Selectable child : children) {
                    refNo.add(child.xpath("//b/text()").get() + child.xpath("//div/text()"));
                }
                json.put("refNo", refNo);
            } else if (s1.equals("适用车型") || s1.equals("Suitable Model")) {
//                List<Selectable> header = html.xpath("//div[@class=\"c-faded-area\"]/div[" + (i + 1) + "]/div[1]/div").nodes();
                List<Selectable> body = html.xpath("//div[@class=\"c-faded-area\"]/div[" + (i + 1) + "]/div[2]/div").nodes();
                List data = new ArrayList();
                body.forEach(row -> {
                    List<Selectable> cells = row.xpath("//div/div/div").nodes();
                    Map<String, String> map = new HashMap<>();
                    for (int j = 0; j < cells.size(); j++) {
                        Selectable cell = cells.get(j);
                        if (j == 0) {
                            String model = cell.xpath("//div/b/text()").get() + cell.xpath("//div/text()").get();
                            map.put("model", model);
                        } else {
                            String kk = cell.xpath("//div/@data-content").get().replace(":", "");
                            String vv = cell.xpath("//div/text()").get();
                            if (kk.equals("年份") || kk.equals("Year")) {
                                map.put("year", vv);
                            } else if (kk.equals("发动机") || kk.equals("Engine")) {
                                map.put("engine", vv);
                            } else if (kk.equals("排量") || kk.equals("CC")) {
                                map.put("Displacement", vv);
                            } else if (kk.equals("功率") || kk.equals("KW")) {
                                map.put("power", vv);
                            } else if (kk.equals("类型") || kk.equals("Type")) {
                                map.put("type", vv);
                            }
                        }
                    }
                    data.add(map);
                });
                json.put("carFitment", data);
            }
        }
        return json;
    }

    public List searchItems(SpiderForm spiderForm) {
        if (spider == null) {
            spider = new Spider();
        }
        WebDriver driver = spider.getDriver();
        driver.get(spiderForm.getUrl());
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement container = driver.findElement(By.id("container"));
        String htmlStr = container.getAttribute("outerHTML");
        Html html = new Html(htmlStr);
        Selectable xpath = html.xpath("//div[@class=\"third-items-list\"]/div[@class='third-item']");
        List<Selectable> nodes = xpath.nodes();
        if (nodes.size() > 0) {
            for (int i = 0; i < nodes.size(); i++) {
                String detailUrl = nodes.get(i).xpath("//div/h3/a/@href").get();
                if (!detailUrl.startsWith("http://webcache")) {
                    continue;
                }
                String subject = nodes.get(i).xpath("//div/h3/a/text()").get();
                Map<String, Object> child = new HashMap<>();
                child.put("multiImage", null);
                child.put("detailUrl", detailUrl);
                child.put("subject", subject);
                child.put("quantityPrices", null);
                String img = nodes.get(i).xpath("//div/div/div[@class='des-img']/a/img/@src").get();
                String ctxt = nodes.get(i).xpath("//div/div/div/div[@class='ctxt']").get();
                child.put("img", img);
                child.put("base", ctxt);
                child.put("isThirdPart", true);
                list.add(child);
            }
        } else {
            Selectable xpath1 = html.xpath("//div[@id='yipartsdata']");
            String detailUrl = xpath1.xpath("//td[@class='parameternumber']/a/@href").get();
            Map<String, Object> child;
            if (StringUtils.isNotBlank(detailUrl)) {
                child = new HashMap<>();
                child.put("multiImage", null);
                child.put("detailUrl", "http://www.yiparts.com" + detailUrl);
                child.put("subject", null);
                child.put("quantityPrices", null);
                List<String> base = xpath1.xpath("//td[@class='parameter']/ul/li").all();
                child.put("base", base);
                child.put("isThirdPart", false);
                list.add(child);
            }
        }
        return list;
    }

    public Map<String, Object> searchOne(SpiderForm spiderForm) {
        if (spider == null) {
            spider = new Spider();
        }
        WebDriver driver = spider.getDriver();
        driver.get(spiderForm.getUrl());
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement container = driver.findElement(By.id("container"));
        String htmlStr = container.getAttribute("outerHTML");
        Html html = new Html(htmlStr);
        if (isLimit(html)) {
            throw new ComException(ErrorCodeEnum.E_YP_LIMIT);
        }
        Selectable xpath = html.xpath("//div[@class=\"third-items-list\"]/div[@class='third-item']");
        List<Selectable> nodes = xpath.nodes();
        Map<String, Object> child = null;
        if (nodes.size() > 0) {
            for (int i = 0; i < nodes.size(); i++) {
                String detailUrl = nodes.get(i).xpath("//div/h3/a/@href").get();
                if (!detailUrl.startsWith("http://webcache")) {
                    continue;
                }
                String subject = nodes.get(i).xpath("//div/h3/a/text()").get();
                child = new HashMap<>();
                child.put("multiImage", null);
                child.put("detailUrl", detailUrl);
                child.put("subject", subject);
                child.put("quantityPrices", null);
                String ctxt = nodes.get(i).xpath("//div/div/div/div[@class='ctxt']/text()").get();
                child.put("base", ctxt);
                spiderForm.setIsThirdPart(true);
                break;
            }
        } else {
            Selectable xpath1 = html.xpath("//div[@id='yipartsdata']");
            String detailUrl = xpath1.xpath("//td[@class='parameternumber']/a/@href").get();
            if (StringUtils.isNotBlank(detailUrl)) {
                child = new HashMap<>();
                child.put("multiImage", null);
                child.put("detailUrl", "http://www.yiparts.com" + detailUrl);
                child.put("subject", null);
                child.put("quantityPrices", null);
            }
            spiderForm.setIsThirdPart(false);
        }
        return child;
    }

    private boolean isLimit(Html html) {
        List<Selectable> nodes = html.xpath("//div[@class='nodata01']").nodes();
        List<Selectable> nodata = html.xpath("//div[@id='Main']/div[@class='nodata']/").nodes();
        return !nodes.isEmpty() || !nodata.isEmpty();
    }

    public boolean isLogin() {
        if (spider == null) {
            spider = new Spider();
        }
        WebDriver driver = spider.getDriver();
        driver.get("http://www.yiparts.com/user/index/");
        WebElement container = driver.findElement(By.id("container"));
        String htmlStr = container.getAttribute("outerHTML");
        Html html = new Html(htmlStr);
        Selectable HasLogin = html.xpath("//li[@class='HasLogin']");
        List<Selectable> nodes = HasLogin.nodes();
        return ObjectUtils.isNotEmpty(nodes);
    }
}
