package com.dwsoft.myspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author tlk
 * @date 2020/7/13-16:09
 */
@EnableEurekaServer  //启用eureka服务器功能
@SpringBootApplication
public class EurekaMain {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain.class,args);
    }
}
