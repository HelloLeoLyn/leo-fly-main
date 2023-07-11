package com.leo.fly.web.filter;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.Charset;


@Slf4j
@Getter
@Setter
public class MyRequestWrapper extends HttpServletRequestWrapper {

    private final byte[] body;
    private HttpServletRequest request;
    private String code;
    private String env;
    private boolean doChain;

    public MyRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        this.request = request;
        this.code = code;
        this.body = getBodyString().getBytes(Charset.forName("UTF-8"));
        this.doChain = false;

    }


    @Override
    public ServletInputStream getInputStream() {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public int read() {
                return byteArrayInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
            }
        };
    }

    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }


    private String getBodyString() throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream;
        BufferedReader reader;
        inputStream = request.getInputStream();
        reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        if(sb.length()>0) {
            if("=".equals(sb.substring(0, 1))) {
                return URLDecoder.decode(sb.substring(1), "utf8");
            }
        }
        return sb.toString();
    }
}
