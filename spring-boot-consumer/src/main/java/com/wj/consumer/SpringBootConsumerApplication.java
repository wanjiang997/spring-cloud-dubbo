package com.wj.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * Created with IntelliJ IDEA.
 * User: wanjiang
 * Date: 2019/11/2
 * Time: 15:06
 */
@EnableDubbo
@EnableHystrix
@SpringBootApplication
public class SpringBootConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsumerApplication.class, args);
    }

}
