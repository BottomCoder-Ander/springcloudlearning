package cool.cade.springcloud.service;

import cool.cade.springcloud.entities.CommonResult;
import cool.cade.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Cade
 * @date 08/11/2021 - 22:35
 */
//声明调用的服务和路径
@Component
@FeignClient(value="CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/payment/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id) ;

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}