package cool.cade.springcloud.service;

import cool.cade.springcloud.entities.Payment;
import cool.cade.springcloud.entities.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Cade
 * @date 09/11/2021 - 12:21
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/{id}")
    String paymentInfoOK(@PathVariable("id") Long id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Long id);
}
