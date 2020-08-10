package com.xtm.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;



/*
@controller 控制器（注入服务）
用于标注控制层，相当于struts中的action层
@service 服务（注入dao）
用于标注服务层，主要用来进行业务的逻辑处理
@repository（实现dao访问）
用于标注数据访问层，也可以说用于标注数据访问组件，即DAO组件
@component （把普通pojo实例化到spring容器中，相当于配置文件中的）
* */


/*
* 此类用于产生验证码
* */
@Component
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha getDefaultKaptcha() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 图片边框
        properties.setProperty("kaptcha.border", "no");
        // 边框颜色
        properties.setProperty("kaptcha.border.color", "105,179,90");
        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        // 图片宽
        properties.setProperty("kaptcha.image.width", "120");
        // 图片高
        properties.setProperty("kaptcha.image.height", "49");
        // 字体大小
        properties.setProperty("kaptcha.textproducer.font.size", "40");
        // session key
        properties.setProperty("kaptcha.session.key", "code");
        // 验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        // 字体
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");

        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);



        return defaultKaptcha;
    }
}