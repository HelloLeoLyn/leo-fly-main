package com.leo.fly.file.param;

import lombok.Data;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@Data
public class HtmlTags {
    public static final String BODY = "BODY";
    public static final String TEMPLATE = "TEMPLATE";
    public static final String DIV = "DIV";
    public static final String SCRIPT = "SCRIPT";
    public static final String STYLE = "STYLE";

    public static void main(String[] args) {
        Collection<File> files = FileUtils.listFiles(new File("F:\\IdeaProjects\\dev\\leofly"),null,true);
        files.forEach(file -> {
            System.out.println(file);
            String path = "F:\\IdeaProjects\\dev\\leo-fly\\src\\main\\java\\";
            try {
                String fileType = file.getName().substring(file.getName().lastIndexOf("."));
                if(fileType.equals(".java")) {
                    List<String> lines = FileUtils.readLines(file, "UTF8");
                    String first = lines.get(0);
                    String javaPath = first.replace("package", "").replace(";", "").replace(".", "\\").trim();
                    File dest = new File(path+javaPath+"\\"+file.getName());
                    FileUtils.copyFile(file,dest);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}
