package cool.cade.springcloud.controller;

import cool.cade.springcloud.loadbalancerules.LoadBalance;
import cool.cade.springcloud.entities.CommonResult;
import cool.cade.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author Cade
 * @date 04/11/2021 - 00:29
 */
@RestController
@Slf4j
public class OrderController {

    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalance loadBalance;

    @PostMapping("/consumer/payment/")
    @ResponseBody // 将返回结果转json，不然会导致前端接收错误
    public CommonResult<Payment> create(Payment payment) {
        log.info("consumer create " + payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/{id}")
    @ResponseBody
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("=============get id = " + id);

        return restTemplate.getForObject(PAYMENT_URL + "/payment/" + id, CommonResult.class);

    }

    @GetMapping("/consumer/payment/loadbalance")
    @ResponseBody
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.isEmpty()) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalance.instance(instances);
        // 因为这里不是用Ribbon的负载均衡（去掉了LoadBalance注解）所以我们要自己获取Uri，并连接
        URI uri = serviceInstance.getUri();
        log.info("uri = " + uri);
        return restTemplate.getForObject(uri + "/payment/loadbalance", String.class);
    }
}