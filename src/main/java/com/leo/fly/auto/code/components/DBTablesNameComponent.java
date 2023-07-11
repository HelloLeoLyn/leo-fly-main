package com.leo.fly.auto.code.components;

import com.leo.fly.auto.code.params.TableParam;
import com.leo.fly.db.config.LeoCommonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DBTablesNameComponent {
    @Autowired
    LeoCommonMapper autoCodeSql;

    public List list(TableParam tableParam){
        List<Map<String, String>> tables = autoCodeSql.tables(tableParam);
        if(tables.size()>0) {
            tables = tables.stream().filter(t->t.get("name").startsWith("leo")).collect(Collectors.toList());
        }
        return tables;
    }

    public List info(TableParam tableParam){
        List<Map<String,String>> info = autoCodeSql.info(tableParam);
        return info;
    }
}
