//
//import ErrorCodeEnum;
//import Platform;
//import ComException;
//import AES256;
//import MD5Util;
//import StringUtils;
//import BaseHeaderProperties;
//import com.leo.fly.web.util.UserContextHolder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.redis.core.BoundValueOperations;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import javax.servlet.*;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class AccessFilter implements Filter {
//    @Autowired
//    StringRedisTemplate redisTemplate;
//    @Value("${session.active:false}")
//    private boolean sessionActive;
//    @Value("${session.platform:}")
//    private List<String> platform;
//
//    @Override
//    public void init(FilterConfig filterConfig) {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//
//        if (sessionActive) {
//            //解析头部公共信息
//            MyRequestWrapper requestWrapper = (MyRequestWrapper) request;
//            Map<String, String> header;
//            try {
//                header = parseCommonInfo(requestWrapper);
//            } catch (Exception e) {
//                throw new ComException(ErrorCodeEnum.E_PARSE_EXCEPTION);
//            }
//
//            UserContextHolder.getInstance().setContext(header);
//            UserContextHolder instance = UserContextHolder.getInstance();
//            //解签
//            String source = instance.getTime() + instance.getPlatform() + instance.getSessionId();
//            Platform platform = Platform.valueOf(instance.getPlatform());
//            String sourceSign = MD5Util.string2MD5(source + platform.getKey32());
//            String targetSign = UserContextHolder.getInstance().getSign();
//            if (StringUtils.notEquals(sourceSign, targetSign)) {
//                throw new ComException(ErrorCodeEnum.E_SIGN);
//            }
//
//            //判断平台
//            String platform1 = UserContextHolder.getInstance().getPlatform();
//            long count = Arrays.stream(Platform.values()).filter(a -> a.getId().equals(platform1)).count();
//            if (count == 0) {
//                throw new ComException(ErrorCodeEnum.E_REQUEST_INVALID);
//            }
//
//            //判断会话
//            if (this.platform.contains(platform1)) {
//                BoundValueOperations<String, String> operations = redisTemplate.boundValueOps(UserContextHolder.getInstance().getSessionId());
//                String session = operations.get();
//                if (StringUtils.isBlank(session)) {
//                    throw new ComException(ErrorCodeEnum.E_LOGIN);
//                }
//                Long expire = operations.getExpire();
//                if (expire < 0) {
//                    throw new ComException(ErrorCodeEnum.E_LOGIN);
//                }
//            }
//        }
//
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//    private Map<String, String> parseCommonInfo(MyRequestWrapper requestWrapper) {
//        Map<String, String> map = new HashMap<>();
//        String token = StringUtils.defaultIfBlank(requestWrapper.getHeader(BaseHeaderProperties.X_TOKEN), "");
//        map.put(BaseHeaderProperties.X_TOKEN, token);
//        map.put(BaseHeaderProperties.X_SLF, requestWrapper.getHeader(BaseHeaderProperties.X_SLF));
//        map.put(BaseHeaderProperties.X_SYSTEM, requestWrapper.getHeader(BaseHeaderProperties.X_SYSTEM));
//        Platform platform = Platform.valueOf(requestWrapper.getHeader(BaseHeaderProperties.X_SYSTEM));
//        map.put(BaseHeaderProperties.X_SEQUENCE, requestWrapper.getHeader(BaseHeaderProperties.X_SEQUENCE));
//        String userId;
//        if (StringUtils.isBlank(token)) {
//            userId = "";
//        } else {
//            userId = AES256.decode(token, platform.getKey16());
//            userId = userId.split(",")[0];
//        }
//        map.put(BaseHeaderProperties.X_USER, userId);
//        map.put("trans_code", requestWrapper.getCode());
//        return map;
//    }
//
//}
