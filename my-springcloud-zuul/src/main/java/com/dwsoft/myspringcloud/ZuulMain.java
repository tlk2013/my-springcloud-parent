package com.dwsoft.myspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author tlk
 * @date 2020/7/16-10:38
 */
@EnableZuulProxy  //启用zuul代理功能
@SpringBootApplication
public class ZuulMain {

    public static void main(String[] args) {
        SpringApplication.run(ZuulMain.class,args);
    }
}
