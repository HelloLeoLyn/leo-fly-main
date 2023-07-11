package com.leo.fly.web.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;

public class MyResponseWrapper extends HttpServletResponseWrapper {
	private ResponsePrintWriter writer;
	private MyServletOutputStream out;
	public MyResponseWrapper(HttpServletResponse response) {
	    super(response);
	}
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
	    //一定要先判断当前out为空才能去新建out对象，否则一次请求会出现多个out对象
	    if (out == null){
	        out = new MyServletOutputStream(super.getOutputStream());
	    }
	    return out;
	}
	@Override
	public PrintWriter getWriter() throws IOException {
	    //一定要先判断当前writer为空才能去新建writer对象，否则一次请求会出现多个writer对象
	    if (writer == null){
	        writer = new ResponsePrintWriter(super.getWriter());
	    }
	    return writer;
	}
	public ResponsePrintWriter getMyWriter() {
	    return writer;
	}
	public MyServletOutputStream getMyOutputStream(){
	    return out;
	}
	}
