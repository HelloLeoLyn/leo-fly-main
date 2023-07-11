package com.leo.fly.auto.code.components;

import com.alibaba.fastjson.JSONObject;
import com.leo.fly.auto.code.params.GenerateCodeParam;
import com.leo.fly.auto.code.vo.TemplateField;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenerateVueCodeComponent {

    public StringBuilder generateVueCode(List<String> lines, GenerateCodeParam param) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
            if (line.indexOf("${model.queryForm}") >= 0) {
                generateQueryForm(line, param.getFields(), stringBuilder);
            } else if (line.indexOf("${model.table}") >= 0) {
                generateTable(line, param.getFields(), stringBuilder);
            } else if (line.indexOf("${model.saveOrUpdate}") >= 0) {
                generateSaveOrUpdateForm(line, param.getFields(), stringBuilder);
            } else if (line.indexOf("${model.queryFormObj}") >= 0) {
                generateQueryJson(line, param, stringBuilder);
            } else if (line.indexOf("${model.saveOrUpdateObj}") >= 0) {
                generateSaveOrUpdateJson(line, param, stringBuilder);
            } else if (line.indexOf("${model.rules}") >= 0) {
                generateRules(line, param, stringBuilder);
            } else {
                line = line.replace("${model.name}", param.getName())
                        .replace("${model.label}", param.getLabel())
                        .replace("${model.moduleName}", param.getVueModuleName())
                        .replace("${model.underscoreName}", param.getUnderscoreName());
                stringBuilder.append(line).append("\n");
            }
        }
        return stringBuilder;
    }

    private void generateQueryJson(String line, GenerateCodeParam param, StringBuilder stringBuilder) {
        JSONObject object = new JSONObject();
        stringBuilder.append(line, 0, line.indexOf("${model.queryFormObj}"));
        param.getFields().forEach(col -> {
            if ("String".equals(col.getJavaType())) {
                object.put(col.getJavaKey(), "");
            } else {
                object.put(col.getJavaKey(), null);
            }
        });
        stringBuilder.append(object.toJSONString()).append(",\n");
    }

    private void generateSaveOrUpdateJson(String line, GenerateCodeParam param, StringBuilder stringBuilder) {
        JSONObject object = new JSONObject();
        stringBuilder.append(line, 0, line.indexOf("${model.saveOrUpdateObj}"));
        param.getFields().forEach(col -> {
            if ("String".equals(col.getJavaType())) {
                object.put(col.getJavaKey(), "");
            } else {
                object.put(col.getJavaKey(), null);
            }
        });
        stringBuilder.append(object.toJSONString()).append(",\n");
    }

    private void generateRules(String line, GenerateCodeParam param, StringBuilder stringBuilder) {
        stringBuilder.append(line, 0, line.indexOf("${model.rules}")).append("{},\n");
    }

    private void generateSaveOrUpdateForm(String line, List<TemplateField> fields, StringBuilder stringBuilder) {
        fields.forEach(field -> {
            if (field.getInAdd()) {
                stringBuilder
                        .append(line, 0, line.indexOf("${model.saveOrUpdate}"))
                        .append("<el-form-item label=\"")
                        .append(field.getJavaKey())
                        .append("\" prop=\"")
                        .append(field.getJavaKey())
                        .append("\">").append("<el-");
                if (field.getHtmlTag().equals("textarea")) {
                    stringBuilder.append("input type=\"textarea\" ");
                } else {
                    stringBuilder.append(field.getHtmlTag());
                }
                stringBuilder.append(" v-model=\"temp.").append(field.getJavaKey())
                        .append("\" />")
                        .append("</el-form-item>\n");
            }
        });
    }

    private void generateTable(String line, List<TemplateField> fields, StringBuilder stringBuilder) {
        fields.forEach(field -> {
            if (field.getInTable()) {
                stringBuilder
                        .append(line, 0, line.indexOf("${model.table}"))
                        .append("<el-table-column label=\"")
                        .append(field.getJavaKey())
                        .append("\" prop=\"")
                        .append(field.getJavaKey())
                        .append("\" align=\"center\"  />\n");
            }
        });
    }

    private void generateQueryForm(String line, List<TemplateField> fields, StringBuilder stringBuilder) {
        fields.forEach(field -> {
                    if (field.getInQuery())
                        stringBuilder
                                .append(line, 0, line.indexOf("${model.queryForm}"))
                                .append("<el-input v-model=\"queryForm.").append(field.getJavaKey())
                                .append("\" placeholder=\"").append(field.getJavaKey())
                                .append("\" style=\"width: 200px;\" class=\"filter-item\" />\n");
                }
        );
    }
}
