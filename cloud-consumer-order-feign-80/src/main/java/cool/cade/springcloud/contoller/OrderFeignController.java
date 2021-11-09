package cool.cade.springcloud.contoller;

import cool.cade.springcloud.entities.CommonResult;
import cool.cade.springcloud.entities.Payment;
import cool.cade.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Cade
 * @date 08/11/2021 - 22:42
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        // 直接调用即可
        return paymentFeignService.getPayment(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }

}
