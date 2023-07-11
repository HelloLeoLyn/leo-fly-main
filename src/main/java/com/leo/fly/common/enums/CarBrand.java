package com.leo.fly.common.enums;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum CarBrand {

    Acura("Acura","极品/阿库拉","日本",false),
    AlfaRomeo("AlfaRomeo","爱快罗蜜欧/阿尔法·罗密欧","意大利",false),
    Alpina("Alpina","阿尔宾纳","德国",false),
    ARO("ARO","阿罗","罗马尼亚",false),
    Ascari("Ascari","阿斯卡里","英国",false),
    AstonMarTIn("AstonMarTIn","阿斯顿马丁/阿斯顿·马丁","英国",true),
    Audi("Audi","奥迪","德国",true),
    AusTIn("AusTIn","奥斯汀","英国",false),
    Autozam("Autozam","科特赞","日本",false),
    Bentley("Bentley","宾利","英国",true),
    BMW("BMW","宝马","德国",true),
    Brabus("Brabus","搏速","德国",false),
    BugatTI("BugatTI","布加蒂","法国",false),
    Buick("Buick","别克","美国",true),
    Cadillac("Cadillac","凯迪拉克","美国",true),
    Caterham("Caterham","凯特汉姆","英国",true),
    Changhe("Changhe","昌河","中国",false),
    Chevrolet("Chevrolet","雪佛兰","美国",true),
    Chrysler("Chrysler","克莱斯勒","美国",false),
    Citroën("Citroën","雪铁龙","法国",true),
    Dacia("Dacia","达西亚","罗马尼亚",false),
    Daewoo("Daewoo","大宇","韩国",false),
    DAF("DAF","大富","荷兰",false),
    Daihatsu("Daihatsu","大发","日本",false),
    DeTomaso("DeTomaso","德·托马索","意大利",false),
    DKW("DKW","小奇迹","德国",false),
    Dodge("Dodge","道奇","美国",false),
    DongFeng("DongFeng","东风","中国",false),
    Eagle("Eagle","雄鹰","美国",false),
    Eunos("Eunos","依诺斯","日本",false),
    Ferrari("Ferrari","法拉利","意大利",true),
    Fiat("Fiat","飞雅特/菲亚特/快意","意大利",false),
    Ford("Ford","福特","美国",true),
    FreightLiner("FreightLiner","弗莱特莱纳","美国",true),
    Fuso("Fuso","扶桑","日本",true),
    GAZ("GAZ","嘎斯","俄罗斯",false),
    Geo("Geo","吉优","美国",false),
    GMC("GMC","吉姆希","美国",false),
    GreatWall("GreatWall","长城","中国",true),
    Haoqing("Haoqing","豪情","中国",false),
    Hino("Hino","日野","日本",false),
    HispanoSuiza("HispanoSuiza","希斯巴诺苏莎","瑞士",false),
    Holden("Holden","荷顿","澳大利亚",false),
    Honda("Honda","本田","日本",true),
    Horch("Horch","霍希","德国",false),
    Huali("Huali","华利","中国",false),
    Huapu("Huapu","华普","中国",false),
    Hummer("Hummer","悍马","美国",true),
    Hyundai("Hyundai","现代","韩国",true),
    InfiniTI("InfiniTI","尹芬底/无限","日本",false),
    Isuzu("Isuzu","五十铃","日本",true),
    Iveco("Iveco","依维科","意大利",false),
    Jaguar("Jaguar","美洲虎","英国",true),
    Jeep("Jeep","吉普","美国",true),
    Jensen("Jensen","杰森","英国",false),
    Jinbei("Jinbei","金杯","中国",false),
    Kia("Kia","起亚","韩国",true),
    KingLong("KingLong","金龙","中国",false),
    Lada("Lada","拉达","俄罗斯",false),
    Lamborghini("Lamborghini","兰博基尼","意大利",true),
    Lancia("Lancia","兰吉雅","意大利",false),
    LandRover("Land Rover","陆虎","英国",true),
    Lexus("Lexus","凌志","日本",true),
    Lincoln("Lincoln","林肯","美国",true),
    Lotus("Lotus","莲花","英国",false),
    Mahindra("Mahindra","马辛德拉","印度",false),
    Maserati("Maserati","玛莎拉蒂","意大利",true),
    Maybach("Maybach","梅巴赫/迈巴赫","德国",false),
    Mazda("Mazda","马自达","日本",true),
    MercedesBenz("Mercedes Benz","奔驰","德国",true),
    Mercury("Mercury","水星","美国",false),
    Mitsubishi("Mitsubishi","三菱","日本",true),
    Mitsuoka("Mitsuoka","光冈","日本",false),
    Morgan("Morgan","摩根","英国",false),
    Nissan("Nissan","尼桑","日本",true),
    Oldsmobile("Oldsmobile","奥斯摩比","美国",false),
    Opel("Opel","欧宝","德国",false),
    Peugeot("Peugeot","标致","法国",false),
    Plymouth("Plymouth","顺风","美国",false),
    Pontiac("Pontiac","庞帝克/旁蒂克","美国",false),
    Porsche("Porsche","保时捷","德国",true),
    Proton("Proton","普而腾/宝腾","马来西亚",false),
    RedBanner("RedBanner","红旗","中国",true),
    Renault("Renault","雷诺","法国",true),
    RollsRoyce("RollsRoyce","劳斯莱斯","英国",true),
    Rover("Rover","路华/罗孚","英国",true),
    Saab("Saab","绅宝","瑞典",false),
    Samsung("Samsung","三星","韩国",false),
    Santana("Santana","桑塔纳","西班牙",true),
    Saturn("Saturn","钍星/土星","美国",false),
    Seat("Seat","喜悦/西亚特","西班牙",false),
    Shanghai("Shanghai","上海","中国",false),
    Skoda("Skoda","斯柯达","捷克",true),
    Spyker("Spyker","世爵","荷兰",false),
    Ssangyong("Ssangyong","双龙","韩国",false),
    Sterling("Sterling","斯特林","美国",false),
    Subaru("Subaru","速霸陆/富士","日本",false),
    Suzuki("Suzuki","铃木","日本",true),
    Tatra("Tatra","太脱拉","捷克",false),
    TommyKaira("TommyKaira","富田","日本",false),
    Toyota("Toyota","丰田","日本",true),
    UDNissanDiesel("UDNissanDiesel","日产柴油","日本",false),
    Volvo("Volvo","沃尔沃","瑞典",true),
    Volkswagen("Volkswagen","大众","德国",true),
    Yuejin("Yuejin","跃进","中国",false),
    Yunque("Yunque","云雀","中国",false),


    ;
    private final String name;
    private final String nameCN;
    private final String orgin;
    private final boolean isNormal;

    public static void main(String[] args) {
        List<Map<String, Object>> normal = Arrays.stream(CarBrand.values()).filter(f -> f.isNormal).map(a -> getStringObjectMap(a)).collect(Collectors.toList());
        List<Map<String, Object>> unNormal = Arrays.stream(CarBrand.values()).filter(f -> !f.isNormal).map(a -> getStringObjectMap(a)).collect(Collectors.toList());
        System.out.println(JSONObject.toJSONString(normal));
        System.out.println(JSONObject.toJSONString(unNormal));
    }

    private static Map<String, Object> getStringObjectMap(CarBrand a) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", a.name.toUpperCase().trim().replaceAll(" ", ""));
        map.put("name", a.name);
        map.put("text", a.nameCN);
        map.put("region", a.orgin);
        map.put("show", a.isNormal);
        return map;
    }
}

