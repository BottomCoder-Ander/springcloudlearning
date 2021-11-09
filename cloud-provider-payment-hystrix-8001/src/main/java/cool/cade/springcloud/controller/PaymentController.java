package cool.cade.springcloud.controller;

import cool.cade.springcloud.entities.Payment;

import cool.cade.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Cade
 * @date 09/11/2021 - 10:17
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverport;

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Long id){
        String s = paymentService.paymentInfoTimeout(id);

        return s;
    }

    @GetMapping("/payment/hystrix/{id}")
    public String payment(@PathVariable("id") Long id){
        String s = paymentService.paymentInfo(id);
        return s;
    }

}
