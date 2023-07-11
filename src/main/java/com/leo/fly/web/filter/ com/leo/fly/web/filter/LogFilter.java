//
//import com.alibaba.fastjson.JSONObject;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import JsonResult;
//import ErrorCodeEnum;
//import SequenceEnum;
//import ComException;
//import com.leo.fly.web.util.HttpUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.http.HttpStatus;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.util.Map;
//import java.util.Set;
//
//
//@Slf4j
//public class LogFilter implements Filter {
//    @Value("${spring.profiles.active}")
//    private String env;
//    private static final Logger log2 = LoggerFactory.getLogger("req_res");
//    private static final String LOG_FORMATTER_REQ = "req:%s,content:{请求路径:%s,请求方法:%s,header:%s,body:%s,param:%s, 来源IP:%s}";
//    private static final String LOG_FORMATTER_RES = "res:%s,content:%s,耗时:%d";
//    @Value("#{'${system.whiteList}'.split(',')}")
//    private Set<String> protectedUrls;
//
//    @Autowired
//    StringRedisTemplate redisTemplate;
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException {
//
//
//        log.debug("request start");
//        long start = System.currentTimeMillis();
//        log.debug("start:{}", start);
//        String code ;
//        log.debug("generate a application transaction code");
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        String requestURI = httpServletRequest.getRequestURI();
//        if(protectedUrls.contains(requestURI)){
//            try {
//                chain.doFilter(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            }
//            return;
//        }
//        MyRequestWrapper requestWrapper = new MyRequestWrapper(httpServletRequest);
//        MyResponseWrapper responseWrapper = new MyResponseWrapper((HttpServletResponse) response);
//        responseWrapper.setCharacterEncoding("UTF-8");
//        responseWrapper.setHeader("Access-Control-Allow-Origin", "*");
//        responseWrapper.setHeader("Access-Control-Allow-Methods", "*");
//        responseWrapper.setHeader("Access-Control-Max-Age", "3600");
//        responseWrapper.setHeader("Access-Control-Allow-Headers","x-token,x-system,x-sequence,x-slf,Origin, X-Requested-With, Content-Type, Accept, token, Access-Token");
//        response.setContentType("application/json; charset=utf-8");
//        responseWrapper.setHeader("Access-Control-Allow-Credentials", "true");
//        responseWrapper.setHeader("Access-Control-Expose-Headers", "*");
//        String method = requestWrapper.getMethod();
//        if (method.equals("OPTIONS")) {
//            responseWrapper.setStatus(HttpStatus.OK.value());
//            return;
//        }
//
//        String body;
//        try {
//            log.debug("生成交易码");
//            code = redisTemplate.opsForValue().increment(SequenceEnum.transSeq.name()) + "";
//            requestWrapper.setCode(code);
//            requestWrapper.setEnv(env);
//        } catch (Exception e) {
//            requestLog(requestWrapper, null, null);
//            invalid(responseWrapper,ErrorCodeEnum.E_GENERATE_TRANSACTION_CODE.getI18Remark(),ErrorCodeEnum.E_GENERATE_TRANSACTION_CODE.getCode());
//            responseLog(responseWrapper, null, start);
//            return;
//        }
//        log.debug("获取输入body");
//
//        try {
//            body = new String(requestWrapper.getBody(), "utf8");
//        } catch (UnsupportedEncodingException e) {
//            body = new String(requestWrapper.getBody());
//        }
//
//        requestLog(requestWrapper, code, body);
//        try {
//            chain.doFilter(requestWrapper, responseWrapper);
//        } catch (Exception e) {
//            if(e instanceof ComException){
//                ComException ce = (ComException) e;
//                invalid(responseWrapper,ce.getMessage(),ce.getBaseErrorEnum().getCode());
//            }
//        }
//        responseLog(responseWrapper, code, start);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//    /**
//     * 无效请求
//     * @throws IOException
//     */
//    private void invalid(ServletResponse response,
//                         String msg, String code) throws IOException {
//        JsonResult jsonResult = new JsonResult();
//        jsonResult.setCode(code);
//        jsonResult.setMsg(msg);
//        // 为使得中文字符不乱码
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(JSONObject.toJSONString(jsonResult));
//    }
//
//    private void requestLog(MyRequestWrapper requestWrapper, String code, String body) {
//        String path = requestWrapper.getRequestURI();
//        // 请求方法类型
//        String method = requestWrapper.getMethod();
//        // 请求的真实IP
//        String requestedIP = HttpUtils.getRealIP(requestWrapper);
//        // 获取header参数
//        Map<String, String> headerMap = null;
//        try {
//            headerMap = HttpUtils.getHeaders(requestWrapper);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String param = mapper.writeValueAsString(requestWrapper.getParameterMap());
//            String info = String.format(LOG_FORMATTER_REQ, code, path, method, headerMap, body, param, requestedIP);
//            writeLog(info);
//        } catch (JsonProcessingException e) {
//            throw new ComException(ErrorCodeEnum.E_PARSE_BEAN);
//        }
//    }
//
//    private void writeLog(String info) {
//        if ("dev".equals(env)) {
//            log2.info(info);
//            log.info(info);
//        } else {
//            log2.info(info);
//            log.info(info);
//        }
//    }
//
//    /**
//     * 响应日志
//     */
//    void responseLog(MyResponseWrapper responseWrapper, String transSeq, long start) {
//        String responseBody = "";
//        if (responseWrapper.getMyOutputStream() == null) {
//            if (responseWrapper.getMyWriter() != null) {
//                responseBody = responseWrapper.getMyWriter().getContent();
//                // 一定要flush,responseBody会被复用
//                responseWrapper.getMyWriter().myFlush();
//            }
//        } else {
//            responseBody = responseWrapper.getMyOutputStream().getBuffer();
//            // 一定要flush,responseBody会被复用
//            responseWrapper.getMyOutputStream().myFlush();
//        }
//        if (responseBody != null && responseBody.length() > 210) {
//            responseBody = responseBody.substring(0, 210);
//        }
//        log2.info(String.format(LOG_FORMATTER_RES, transSeq, responseBody, System.currentTimeMillis() - start));
//        log.info(String.format(LOG_FORMATTER_RES, transSeq, responseBody, System.currentTimeMillis() - start));
//    }
//
//
//
//}
