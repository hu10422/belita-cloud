package com.balita;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDubbo
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class DubboHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboHystrixDashboardApplication.class);
    }

}
