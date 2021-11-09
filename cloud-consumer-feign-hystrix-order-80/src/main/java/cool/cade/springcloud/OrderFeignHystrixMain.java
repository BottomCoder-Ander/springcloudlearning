package cool.cade.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Cade
 * @date 09/11/2021 - 11:22
 */
@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient
@EnableDiscoveryClient //这里用Eureka用两个注解之一都行
public class OrderFeignHystrixMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixMain.class, args);
    }
}
