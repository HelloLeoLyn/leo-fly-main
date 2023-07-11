package com.leo.fly.auto.code.components;

import com.leo.fly.auto.code.params.GenerateCodeParam;
import com.leo.fly.auto.code.vo.TemplateFile;


import com.leo.fly.common.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

@Component
public class GenerateCodeComponent {
    @Autowired
    GenerateVueCodeComponent generateVueCodeComponent;

    public Object execute(GenerateCodeParam param) {
        param.getFiles().forEach(templateFile -> {
            try {
                System.out.println(templateFile.getFilename());
                StringBuilder stringBuilder;
                File file = ResourceUtils.getFile("classpath:" + templateFile.getTemplateName());
                List<String> lines = FileUtils.readLines(file, Charset.forName("UTF8"));
                if (StringUtils.equals("java", templateFile.getFileType())) {
                    stringBuilder = generateJava(lines, param, templateFile);
                    File dest = new File(templateFile.getFilepath(), templateFile.getFilename());
                    FileUtils.writeStringToFile(dest, stringBuilder.toString(), Charset.forName("UTF8"));
                } else if (StringUtils.equals("vue", templateFile.getFileType())) {
                    stringBuilder = generateVueCodeComponent.generateVueCode(lines, param);
                    File dest = new File(templateFile.getFilepath(), templateFile.getFilename());
                    FileUtils.writeStringToFile(dest, stringBuilder.toString(), Charset.forName("UTF8"));
                } else if (StringUtils.equals("js", templateFile.getFileType())) {
                    stringBuilder = generateJs(lines, param);
                    File dest = new File(templateFile.getFilepath(), templateFile.getFilename());
                    FileUtils.writeStringToFile(dest, stringBuilder.toString(), Charset.forName("UTF8"));
                } else {
                    stringBuilder = generatePom(lines, param);
                    File dest = new File(templateFile.getFilepath(), templateFile.getFilename());
                    FileUtils.writeStringToFile(dest, stringBuilder.toString(), Charset.forName("UTF8"));
                }
                System.out.println("done");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        });
        return null;
    }

    private StringBuilder generatePom(List<String> lines, GenerateCodeParam param) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (i == 11) {
                stringBuilder.append(line.replace("${model.moduleName}",param.getJavaModuleName())).append("\n");
            } else {
                stringBuilder.append(line).append("\n");
            }
        }
        return stringBuilder;
    }

    private StringBuilder generateJs(List<String> lines, GenerateCodeParam param) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
            stringBuilder.append(line.replace("${model.underscoreName}", param.getUnderscoreName())).append("\n");
        }
        return stringBuilder;
    }

    private StringBuilder generateJava(List<String> lines, GenerateCodeParam param, TemplateFile templateFile) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : lines) {
            if (line.indexOf("${model.entity}") >= 0) {
                appendFields(stringBuilder, param, templateFile.getKey());
            } else if (line.indexOf("${model.queryForm}") >= 0) {
                appendFields(stringBuilder, param, templateFile.getKey());
            } else if (line.indexOf("${model.updateForm}") >= 0) {
                appendFields(stringBuilder, param, templateFile.getKey());
            } else if (line.indexOf("${model.addForm}") >= 0) {
                appendFields(stringBuilder, param, templateFile.getKey());
            } else if (line.indexOf("${model.queryParam}") >= 0) {
                appendFields(stringBuilder, param, templateFile.getKey());
            } else if (line.indexOf("${model.queryWrapper}") >= 0) {
                appendQueryWrapper(stringBuilder, param);
            } else if (line.indexOf("${model.comment}") >= 0) {
                stringBuilder.append("/**\n").append("* ").append(new Date()).append("\n*/\n");
            }else if (line.indexOf("${model.package}") >= 0) {
                stringBuilder.append("package ").append(templateFile.getClassPackage()).append(";\n");
            } else {
                line = line.replace("${model.name}", param.getName())
                        .replace("${model.tableName}", param.getTableName())
                        .replace("${model.label}", param.getLabel());
                stringBuilder.append(line).append("\n");
            }
        }
        return stringBuilder;
    }

    private void appendQueryWrapper(StringBuilder stringBuilder, GenerateCodeParam param) {
        param.getFields().stream().filter(templateField -> templateField.getInQuery()).forEach(field -> {
            stringBuilder.append("\t\tqueryWrapper.");
            if (StringUtils.equals("String", field.getJavaType())) {
                stringBuilder.append("eq(StringUtils.isNotBlank(params.")
                        .append(getMethodName(field.getJavaKey()))
                        .append("())")
                        .append(",").append(param.getLabel()).append("::")
                        .append(getMethodName(field.getJavaKey()))
                        .append(",params.")
                        .append(getMethodName(field.getJavaKey()))
                        .append("());\n");
            } else if (StringUtils.equals("Long", field.getJavaType()) || StringUtils.equals("Integer", field.getJavaType())) {
                stringBuilder.append("eq(ObjectUtils.isNotEmpty(params.")
                        .append(getMethodName(field.getJavaKey()))
                        .append("())")
                        .append(",").append(param.getLabel()).append("::")
                        .append(getMethodName(field.getJavaKey()))
                        .append(",params.")
                        .append(getMethodName(field.getJavaKey()))
                        .append("());\n");
            } else {
                stringBuilder.append("eq(ObjectUtils.isNotEmpty(params.")
                        .append(getMethodName(field.getJavaKey()))
                        .append("())")
                        .append(",").append(param.getLabel()).append("::")
                        .append(getMethodName(field.getJavaKey()))
                        .append(",params.")
                        .append(getMethodName(field.getJavaKey()))
                        .append("());\n");
            }
        });
    }

    private String getMethodName(String key) {
        return "get" + StringUtils.captureName(key);
    }

    private void appendFields(StringBuilder stringBuilder, GenerateCodeParam param,String key) {
        param.getFields().forEach(field -> {
            if("entity".equals(key)) {
                stringBuilder.append("\t/**\n").append("\t* ").append(field.getComment()).append("\n\t*/\n");
                stringBuilder.append("\tprivate ").append(field.getJavaType()).append(" ").append(field.getJavaKey()).append(";\n");
            }
            else if("queryParam".equals(key)||"queryForm".equals(key)) {
                if(field.getInQuery()) {
                    stringBuilder.append("\t/**\n").append("\t* ").append(field.getComment()).append("\n\t*/\n");
                    stringBuilder.append("\tprivate ").append(field.getJavaType()).append(" ").append(field.getJavaKey()).append(";\n");
                }
            }
            else if("addForm".equals(key)) {
                if(field.getInAdd()) {
                    stringBuilder.append("\t/**\n").append("\t* ").append(field.getComment()).append("\n\t*/\n");
                    stringBuilder.append("\tprivate ").append(field.getJavaType()).append(" ").append(field.getJavaKey()).append(";\n");
                }
            }else if("updateForm".equals(key)) {
                if(field.getInUpdate()) {
                    stringBuilder.append("\t/**\n").append("\t* ").append(field.getComment()).append("\n\t*/\n");
                    stringBuilder.append("\tprivate ").append(field.getJavaType()).append(" ").append(field.getJavaKey()).append(";\n");
                }
            }
        });
    }

}