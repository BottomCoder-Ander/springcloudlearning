package cool.cade.springcloud.controller;

import cool.cade.springcloud.entities.CommonResult;
import cool.cade.springcloud.entities.Payment;
import cool.cade.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Cade
 * @date 03/11/2021 - 21:29
 */
@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "*")
    @PostMapping(value = "*")
    public void All(){
        log.info("request not match");
    }

    //采用RESTFUL风格
    @PostMapping(value = "/payment/")
    @ResponseBody
    // 这里要写RequestBody，这样前端才能传json字符串，spring解析成对象。否则的话，就需要直接传对象，而不是字符串了
    public CommonResult create(@RequestBody Payment payment){
        log.info("********插入payment ："+payment);
        int result = paymentService.create(payment);
        log.info("********插入结果为："+result);

        if(result > 0) {
            return new CommonResult<Integer>(200, "插入数据库成功,serverPort:"+serverPort, result);
        }else {
            return new CommonResult<Object>(444, "插入失败,serverPort:"+serverPort, null);
        }
    }

    @GetMapping(value = "/payment/{id}")
    @ResponseBody
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查找结果为："+payment);

        if(payment != null) {
            return new CommonResult(200, "查询成功,serverPort:"+serverPort, payment);
        }else {
            return new CommonResult(444, "没有对应记录,serverPort:"+serverPort, null);
        }
    }
    @GetMapping(value = "/payment/loadbalance")
    public Object lb(){
        log.info("loadbalance payment ==========================");
        return serverPort;
    }
    @GetMapping(value = "/payment/feign/timeout")
    @ResponseBody
    public String paymentFeignTimeout(){
        log.info("get request timeout found");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort ;
    }
}
