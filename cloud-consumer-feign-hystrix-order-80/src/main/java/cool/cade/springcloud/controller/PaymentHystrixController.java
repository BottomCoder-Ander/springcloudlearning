package cool.cade.springcloud.controller;

import cool.cade.springcloud.entities.Payment;
import cool.cade.springcloud.entities.ResultEntity;
import cool.cade.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Cade
 * @date 09/11/2021 - 12:24
 */
@RestController
@Slf4j
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Long id)
    {
        return paymentHystrixService.paymentInfoOK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public Object paymentInfoTimeOut(@PathVariable("id") Long id) {
        String result = paymentHystrixService.paymentInfoTimeOut(id);
        log.info("timeout result" + result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/error")
    public Object paymentError(){
        int res = 1 / 0;

        return "sucess";
    }

}
