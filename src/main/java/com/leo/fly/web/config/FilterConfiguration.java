package com.leo.fly.web.config;
//
//import com.leo.fly.web.annotation.Access;
//import com.leo.fly.web.filter.AccessFilter;
//import com.leo.fly.web.filter.LogFilter;
//import com.leo.fly.web.scan.ScanSupport;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.Filter;
//import java.io.IOException;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Method;
//import java.util.HashSet;
//import java.util.Set;
//
//@Configuration
//@EnableCaching
//public class FilterConfiguration {
//    @Autowired
//    ScanSupport scanner;
//
//
//    @Bean
//    public FilterRegistrationBean<Filter> paramFilterRegistrationBean() {
//        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(this.logFilter());
//        registrationBean.addUrlPatterns(new String[]{"/*"});
//        registrationBean.setName("logFilter");
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }
//
//    @Bean
//    public Filter logFilter() {
//        return new LogFilter();
//    }
//
//    @Bean
//    public FilterRegistrationBean<Filter> signFilterRegistrationBean() {
//        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<Filter>();
//        registrationBean.setFilter(accessFilter());
////		registrationBean.addUrlPatterns("/*");
////		registrationBean.addUrlPatterns("/token");
//        String[] packages = {"com.leo.fly.*.*.controller","com.leo.fly.*.*.*.controller","com.leo.fly.*.controller","com.leo.fly.alibaba.photo"};
//        try {
//            String[] handlerUrl = getHandlerUrl(packages);
//            registrationBean.addUrlPatterns(handlerUrl);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        registrationBean.setName("accessFilter");
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }
//
//    @Bean
//    public Filter accessFilter() {
//        return new AccessFilter();
//    }
//
//    private String[] getHandlerUrl(String[] packages) throws IOException {
//        Set<String> paths = new HashSet<>();
//        for (String pack : packages) {
//            Set<Class<?>> a = scanner.doScan(pack);
//            a.forEach((obj) -> {
//                Annotation access = obj.getAnnotation(Access.class);
//                if(access!=null){
//                    return;
//                }
//                Annotation ab = obj.getAnnotation(RequestMapping.class);
//                if(ab!=null){
//                    try {
//                        Method asd = ab.getClass().getDeclaredMethod("value", null);
//                        String[] values = (String[]) asd.invoke(ab, null);
//                        for (String path : values) {
//                            paths.add(path + "/*");
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }else{
//                    Method[] declaredMethods = obj.getDeclaredMethods();
//                    for (Method method : declaredMethods){
//                        Annotation accessMethod = method.getAnnotation(Access.class);
//                        if(accessMethod!=null){
//                            continue;
//                        }
//                        Annotation[] annotations = method.getAnnotations();
//                        for (Annotation annotation : annotations){
//
//                            if(annotation.annotationType()==RequestMapping.class||annotation.annotationType()== PutMapping.class||annotation.annotationType()== DeleteMapping.class||annotation.annotationType()==PutMapping.class||annotation.annotationType()== GetMapping.class){
//                                try {
//                                    Method declaredMethod = annotation.getClass().getDeclaredMethod("value", null);
//                                    String[] values = (String[]) declaredMethod.invoke(annotation, null);
//                                    for (String path : values) {
//                                        paths.add(parsePath(path));
//                                    }
//                                } catch (Exception e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }
//                    }
//                }
//            });
//        }
//        return paths.toArray(new String[paths.size()]);
//    }
//
//    private String parsePath(String path) {
//        if(path.indexOf("{")>=0) {
//            String bracket = path.substring(path.indexOf("{"), path.indexOf("}") + 1);
//            path = path.replace(bracket, "*");
//            path = parsePath(path);
//        }
//        return path;
//    }
//
//}
