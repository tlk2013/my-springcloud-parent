package com.dwsoft.myspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author tlk
 * @date 2020/7/15-11:45
 */
@EnableHystrixDashboard//启用仪表盘功能
@SpringBootApplication
public class HystrixMain {
    public static void main(String[] args) {
        SpringApplication.run(HystrixMain.class,args);
    }
}
