package com.leo.fly.web.filter;

import java.io.PrintWriter;

public class ResponsePrintWriter extends PrintWriter{
	private StringBuffer buffer;
	public ResponsePrintWriter(PrintWriter out) {
	    super(out);
	    buffer = new StringBuffer();
	}
	public String getContent(){
	    return buffer == null ? null : buffer.toString();
	}
	@Override
	public void flush() {
	    super.flush();
	}
	//清空buffer，以便下一次重新使用
	public void myFlush(){
	    buffer = null;
	}
	@Override
	public void write(char[] buf, int off, int len) {
	    super.write(buf, off, len);
	    char[] destination = new char[len];
	    System.arraycopy(buf,off,destination,0,len);
	    buffer.append(destination);
	}
	@Override
	public void write(String s) {
	    super.write(s);
	    buffer.append(s);
	}
	}

