package com.leo.fly.common.util;

import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.file.FileCreateParam;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class LeoFileUtils {
    public static File create(FileCreateParam param) throws IOException {
        File directory = new File(param.getFileDirectory());
        if (!directory.exists()) {
            directory.mkdir();
        }

        if (param.getFileType().equals("0")) {
            return directory;
        } else {
            File file = new File(param.getFileDirectory(),param.getFileName());
            return file;
        }

    }

    public static File create(String filepath) throws IOException {
        File file = new File(filepath);
        return create(file, false);
    }

    public static File create(String filepath, boolean isCover) throws IOException {
        File file = new File(filepath);
        return create(file, isCover);
    }

    public static File create(File file, boolean isCover) throws IOException {
        if (file.exists()) {
            if (isCover) {
                return file;
            }
            throw new ComException(ErrorCodeEnum.E_FILE_EXISTS);
        }
        file.createNewFile();
        return file;
    }

    public static boolean write(File file, String content) throws IOException {

        if (!file.exists()) {
            file.createNewFile();
        }
        FileUtils.write(file, content, StandardCharsets.UTF_8);
        return true;

    }

    public static void writeStringToFile(final File file, final String data, final Charset encoding,
                                         final boolean append) throws IOException {
        FileUtils.writeStringToFile(file, data, encoding, append);
    }

    public static boolean write(File file, List<String> content) throws IOException {

        if (!file.exists()) {
            file.createNewFile();
        }
        write(file, StringUtils.ArrayToString(content));
        return true;

    }

    public static boolean isExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static String[] list(String directory) {
        File file = new File(directory);
        if (!file.exists()) {
            throw new ComException(ErrorCodeEnum.E_FILE_NOT_EXISTS);
        }
        if (!file.isDirectory()) {
            throw new ComException(ErrorCodeEnum.E_FILE_IS_NOT_FILE);
        }
        return file.list();

    }

    public static Document getLocalDocument(String filename) throws Exception {
        File source = new File(filename);
        if (!source.exists()) {
            throw new ComException(ErrorCodeEnum.E_FILE_NOT_EXISTS);
        }
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(source);
        return doc;
    }

    public static String parseFileType(String filename){
        int indexOf = filename.lastIndexOf(".");
        if(indexOf>-1){
            return filename.substring(indexOf);
        }
        return "";
    }
}
