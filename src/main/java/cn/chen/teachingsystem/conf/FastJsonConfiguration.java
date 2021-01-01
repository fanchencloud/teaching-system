//package cn.chen.teachingsystem.conf;
//
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//
//import java.nio.charset.Charset;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by handsome programmer.
// *
// * @author chen
// * @User: chen
// * @Date: 2021/1/1
// * @Time: 10:39
// * @Description:
// */
//@Configuration
//public class FastJsonConfiguration {
//    @Bean
//    public HttpMessageConverters fastJsonHttpMessageConverters() {
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//
//        List<MediaType> fastMediaTypes = new ArrayList<>();
//
//        // 处理中文乱码问题
//        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        // 设置时间格式
//        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
//
//        // 在转换器中添加配置信息
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//
//        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
//        stringConverter.setDefaultCharset(StandardCharsets.UTF_8);
//        stringConverter.setSupportedMediaTypes(fastMediaTypes);
//
//        return new HttpMessageConverters(stringConverter, fastJsonHttpMessageConverter);
//    }
//}
