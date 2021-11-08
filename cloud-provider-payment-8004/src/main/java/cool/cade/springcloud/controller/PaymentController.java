package cool.cade.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Cade
 * @date 05/11/2021 - 22:03
 */
// 加上RestController就不用再加ResponseBody啦
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value ="/payment/zk")
    public String paymentzk(){
        return "spring cloud with zookeeper "+serverPort + "\t" + UUID.randomUUID().toString();
    }


}
