package com.leo.fly.auto.code.params;

import com.leo.fly.auto.code.vo.TemplateField;
import com.leo.fly.auto.code.vo.TemplateFile;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GenerateCodeParam implements Serializable {
    private String javaModuleName;
    private String underscoreName;
    private String name;
    private String label;
    private String javaPackageName;
    private String vueModuleName;
    private String tableName;
    private List<TemplateField> fields;
    private List<TemplateFile> files;
}
