package com.dwsoft.myspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @author tlk
 * @date 2020/7/13-14:11
 */
@EnableCircuitBreaker  //启用断路器功能
@SpringBootApplication
public class ProviderMain {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain.class,args);
    }
}
