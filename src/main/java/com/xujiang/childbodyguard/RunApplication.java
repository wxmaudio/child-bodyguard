package com.xujiang.childbodyguard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.ApplicationContext;

/**
 * @author madenghui
 * 1 排除数据源自动配置， 自定义数据源
 * 2 扫描自定义Configuration， Compnent, Controller, Service等配置
 *
 * 注意排除feign的configration 具体参考spring-open-feign官方reference
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, KafkaAutoConfiguration.class},
                       scanBasePackages =
                               {"com.xujiang.childbodyguard.config",
                               "com.xujiang.childbodyguard.listener",
                               "com.xujiang.childbodyguard.controller",
                               "com.xujiang.childbodyguard.service",
                               "com.xujiang.childbodyguard.handler",
                               })
@Slf4j
public class RunApplication {
    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(RunApplication.class, args);
        //print env profile info
        String[] activeProfiles = ctx.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            log.info("boot by profile:  {} =============================== {} ====== {} ====== {}" , profile, profile, profile, profile);
        }
    }
}
