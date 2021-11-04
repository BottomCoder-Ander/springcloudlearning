package cool.cade.springcloud.controller;

import cool.cade.springcloud.entities.CommonResult;
import cool.cade.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Cade
 * @date 04/11/2021 - 00:29
 */
@Controller
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/")
    @ResponseBody // 将返回结果转json，不然会导致前端接收错误
    public CommonResult<Payment> create(Payment payment) {
        log.info("consumer create "+payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/", payment, CommonResult.class);
    }

    @GetMapping("consumer/payment/{id}")
    @ResponseBody
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "payment/"+id,CommonResult.class);
    }
}
