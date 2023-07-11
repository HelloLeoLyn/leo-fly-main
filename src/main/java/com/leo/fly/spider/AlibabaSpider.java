package com.leo.fly.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.util.JsoupUtils;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.db.product.param.ProductCollectorForm;
import com.leo.fly.db.product.service.ProductService;
import lombok.SneakyThrows;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlibabaSpider {

    @Autowired
    ProductService productService;
    @Autowired
    ImageService imageService;
    private Spider webSpider;


    public Html getDetailHtml(Spider spider, String detailHref) {
        WebDriver driver = spider.getDriver();
        try {
            driver.get(detailHref);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement container = driver.findElement(By.id("container"));
        return new Html(container.getAttribute("outerHTML"));
    }


    public JSONObject parseDetailHtml(Html html, JSONObject options) {
        JSONObject quick_data = new JSONObject();
        Selectable regex = html.xpath("//ol[@class=\"detail-breadcrumb\"]/li/a/@href").regex(".*https://www.alibaba.com/(.+)");
        List<String> path = regex.all();
        if (ObjectUtils.isEmpty(path)) {
            regex = html.xpath("//li[@class=\"detail-next-breadcrumb-item\"]/a/@href").regex(".*www.alibaba.com/(.+)");
            path = regex.all();
        }
        String[] pids = path.get(path.size() - 1).split("_pid");
        quick_data.put("categoryId", pids[1]);
        quick_data.put("categoryName", pids[0]);

        Selectable quick_selector = html.xpath("//div[@class=\"do-content\"]/div/div[1]/div[@class=\"do-entry-list\"]/dl");
        quick_selector.nodes().forEach(quick_node -> {
            String key = quick_node.xpath("dl/dt/span/@title").get();
            String value = quick_node.xpath("dl/dd/div/@title").get();
            if (ObjectUtils.isNotEmpty(options.getJSONObject(key)) && options.getJSONObject(key).getBoolean("checked")) {
                quick_data.put(options.getJSONObject(key).getString("key"), value);
            }
        });
        List images = parseImages(html);
        quick_data.put("images", images);

        Selectable tables = html.xpath("//div[@class=\"car-parts-model\"]/table");
        for (Selectable table : tables.nodes()) {
            String head = table.xpath("//table/thead/tr/th[1]").regex("<th.*>(.*)</th>").get();
            if (head.equals("Car Fitment")) {
                List<JSONObject> tableData = parseToJson(table, options);
                quick_data.put("carFitment", tableData);
                break;
            }
        }

        return quick_data;
    }

    private List parseImages(Html html) {
        List<String> images = html.xpath("//div[@class='main-list']/div[@class='main-item']/img/@src").all();
        if (ObjectUtils.isEmpty(images)) {
            images = html.xpath("//ul[@class='main-image-thumb-ul']/li[@class='main-image-thumb-item']/img/@src").all();
        }
        images = images.stream().filter(img -> img.indexOf("tbvideo") < 0).map(img -> img = img.replace("50x50", "1000x1000").replace("100x100", "1000x1000")).collect(Collectors.toList());
        return images;
    }

    public List<JSONObject> parseToJson(Selectable table, JSONObject options) {
        List<String> head = table.xpath("//table/thead/tr/th").regex("<th.*>(.*)</th>").all();
        int row_size = table.xpath("//table/tbody/tr").all().size();
        int col_size = head.size();
        List<JSONObject> table_data = new ArrayList<>();
        int[] row_spans = new int[head.size()];
        for (int i = 0; i < head.size(); i++) {
            row_spans[i] = 0;
        }
        for (int row = 1; row <= row_size; row++) {
            Selectable current_row_td_list = table.xpath("//table/tbody/tr[" + row + "]/td");
            JSONObject current_row = new JSONObject();
            List<Selectable> td_nodes = current_row_td_list.nodes();
            int td_size = td_nodes.size();
            if (td_size < col_size) {
                int col_index = 0;
                for (int j = 0; j < col_size; j++) {
                    if (row_spans[j] >= row) {
                        String key = options.getJSONObject(head.get(j)) == null ? head.get(j) : options.getJSONObject(head.get(j)).getString("key");
                        String value = table_data.get(row - 2).getString(key);
                        current_row.put(key, value);
                        col_index++;
                    } else {
                        try {
                            Selectable first = td_nodes.remove(0);
                            String value = first.regex("<td.*>(.*)</td>").get();
                            String key = options.getJSONObject(head.get(j)) == null ? head.get(j) : options.getJSONObject(head.get(j)).getString("key");
                            current_row.put(key, value);
                            int current_col_rowspan = getRowSpan(first.regex("<td.*rowspan=\"(.*)\">.*</td>").get());
                            if (current_col_rowspan > 0) {
                                row_spans[col_index] = row + current_col_rowspan - 1;
                            }
                            col_index++;
                        } catch (Exception e) {
                            throw new ComException(ErrorCodeEnum.E_PARSE_EXCEPTION);
                        }
                    }
                }
            } else {
                for (int i = 0; i < current_row_td_list.nodes().size(); i++) {
                    Selectable first = current_row_td_list.nodes().get(i);
                    String value = first.regex("<td.*>(.*)</td>").get();
                    if (StringUtils.isBlank(value)) {
                        continue;
                    }
                    int current_col_rowspan = getRowSpan(first.xpath("//td/@rowspan").get());
                    if (current_col_rowspan > 0) {
                        row_spans[i] = row + current_col_rowspan - 1;
                    }
                    String key = options.getJSONObject(head.get(i)) == null ? head.get(i) : options.getJSONObject(head.get(i)).getString("key");
                    current_row.put(key, value);
                }
            }
            table_data.add(current_row);
        }
        return table_data;
    }

    public int getRowSpan(String current_col_rowspan) {
        if (current_col_rowspan == null || current_col_rowspan.equals("")) {
            return 0;
        }
        return Integer.parseInt(current_col_rowspan);
    }

    public JSONObject searchInShopUrl(SpiderForm spiderForm) {
        if (webSpider == null) {
            webSpider = new Spider();
        }
        WebDriver driver = webSpider.getDriver();
        driver.get(spiderForm.getShopUrl());
        WebElement container;
        try {
            container = driver.findElement(By.className("component-product-list"));
        } catch (Exception e) {
            return null;
        }
        String str = container.getAttribute("outerHTML");
        Html html = new Html(str);
        Selectable items = html.xpath("//div[@class='icbu-product-card']");
        int size = items.nodes().size();
        if (size == 0) {
            throw new ComException(ErrorCodeEnum.E_NO_RECORDS);
        }
        String detailHref = "https:" + items.nodes().get(0).xpath("//a[@class='product-image']/@href").get();
        Html detailHtml = getDetailHtml(webSpider, detailHref);
        return parseDetailHtml(detailHtml, spiderForm.getOptions());
    }


    @SneakyThrows
    public List searchItems(SpiderForm spiderForm) {
        if (webSpider == null) {
            webSpider = new Spider();
        }
        WebDriver driver = webSpider.getDriver();
        driver.get(spiderForm.getUrl());
        String pageSource = driver.getPageSource();
        Html html = new Html(pageSource);
        Document document = html.getDocument();
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
                if (ObjectUtils.isEmpty(offerList)) {
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
}
