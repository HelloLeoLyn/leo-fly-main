package com.leo.fly.web.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import java.io.IOException;

public class MyServletOutputStream extends ServletOutputStream {
	private ServletOutputStream outputStream;
	private StringBuffer buffer;
	public MyServletOutputStream(ServletOutputStream outputStream) {
	    this.outputStream = outputStream;
	    buffer = new StringBuffer();
	}
	@Override
	public void write(int b) throws IOException {
	    outputStream.write(b);
	}
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
	    outputStream.write(b, off, len);
	    byte[] bytes = new byte[len];
	    System.arraycopy(b, off, bytes, 0, len);
	    buffer.append(new String(bytes,"UTF-8"));
	}
	@Override
	public void write(byte[] b) throws IOException {
	    outputStream.write(b);
	}
	@Override
	public void flush() throws IOException {
	    super.flush();
	}
	//清空buffer，以便下一次重新使用
	public void myFlush(){
	    outputStream = null;
	    buffer = null;
	}
	public String getBuffer() {
	    if (buffer != null){
	        return buffer.toString();
	    }
	    return null;
	}
	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void setWriteListener(WriteListener listener) {
		// TODO Auto-generated method stub
		
	}
}

