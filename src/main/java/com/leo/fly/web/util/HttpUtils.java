package com.leo.fly.web.util;

import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class HttpUtils {
	public static HttpResponse post(String url, Map<String, String> form, Map<String, String> headers)
			throws IOException {
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionTimeToLive(6000, TimeUnit.MILLISECONDS)
				.build();
		HttpPost httpPost = new HttpPost(url);
		setHeaders(headers,httpPost);
		setParam(form,httpPost);
		return httpClient.execute(httpPost);
	}
	public static HttpResponse post(String url, Map<String, String> form)
			throws IOException {
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionTimeToLive(6000, TimeUnit.MILLISECONDS)
				.build();
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		form.forEach((k,v)->{
			if(!ObjectUtils.isNotEmpty(v)) {
				list.add(new BasicNameValuePair(k, v));
			}
		});
		UrlEncodedFormEntity postEntity = new UrlEncodedFormEntity(list, "UTF-8");
		httpPost.setEntity(postEntity);
		return httpClient.execute(httpPost);
	}
	public static HttpResponse get(String url, Map<String, String> headers)
			throws IOException {
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionTimeToLive(6000, TimeUnit.MILLISECONDS)
				.build();
		HttpGet http = new HttpGet(url);
		setHeaders(headers,http);
		return httpClient.execute(http);
	}
	public static void setParam(Map<String, String> form, HttpPost httpPost) throws UnsupportedEncodingException {
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		form.forEach((k,v)->{
			if(!StringUtils.isBlank(v)) {
				list.add(new BasicNameValuePair(k, v));
			}
		});
		UrlEncodedFormEntity postEntity = new UrlEncodedFormEntity(list, "UTF-8");
		httpPost.setEntity(postEntity);
	}
	
	
	public static void setHeaders(Map<String, String> headers,HttpPost httpPost) {
		if (headers!=null) {
			headers.forEach((key,value)->{
				httpPost.addHeader(key, value);
			});
		}
	}
	public static void setHeaders(Map<String, String> headers,HttpRequestBase http) {
		if (headers!=null) {
			headers.forEach((key,value)->{
				http.addHeader(key, value);
			});
		}
	}
	public static String postAndParseToString(String url, Map<String, String> form, Map<String, String> headers)
			throws ParseException, IOException {
		HttpResponse post = post(url, form, headers);
		return parseResponseToString(post);
	}

	public static String parseResponseToString(HttpResponse httpResponse) throws ParseException, IOException {
		String responseString = "";
		// 获取响应消息实体
		HttpEntity entity = httpResponse.getEntity();
		// 判断响应实体是否为空
		if (entity != null) {
			responseString = EntityUtils.toString(entity);
		}
		return responseString;
	}

	/**
	 * 获取所有的请求头
	 * 
	 * @param request
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static Map<String, String> getHeaders(HttpServletRequest request) throws IllegalArgumentException, IllegalAccessException {
		Map<String, String> headerMap = new HashMap<>();
		List<String> headers = getCommonHeaders();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			if (headers.contains(headerName)) {
				continue;
			}
			headerMap.put(headerName, request.getHeader(headerName));
		}
		return headerMap;
	}
	

	
	private static List<String> getCommonHeaders() throws IllegalArgumentException, IllegalAccessException {
		List<String> headers = new ArrayList<>();
		Class<HttpHeaders> clazz = HttpHeaders.class;
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.getType().toString().endsWith("java.lang.String") && Modifier.isStatic(field.getModifiers())) {
				headers.add((String) field.get(HttpHeaders.class));
			}
		}
		return headers;
	}
	


	public static String getAppendUrl(String url, Map<String, Object> map, String prefix) {
		StringBuffer buffer = new StringBuffer();
		if (map != null && !map.isEmpty()) {
			Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, Object> entry = iterator.next();
				if(StringUtils.isBlank(entry.getValue()+"")) {
					continue;
				}
				if (StringUtils.isEmpty(buffer.toString())) {
					buffer.append("?");
				} else {
					buffer.append("&");
				}
				buffer.append(prefix).append(entry.getKey()).append("=").append(entry.getValue());
			}
		}
		return url + buffer.toString();
	}
	/**
	 * 获取请求的路径参数
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getUriTemplateVar(HttpServletRequest request) {
		NativeWebRequest webRequest = new ServletWebRequest(request);
		@SuppressWarnings("unchecked")
		Map<String, String> uriTemplateVars = (Map<String, String>) webRequest.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);
		return uriTemplateVars;
	}

	/**
	 * 获取请求的真实IP
	 * 
	 * @param request
	 * @return
	 */
	public static String getRealIP(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}




}
