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
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value ="/payment/consul")
    public String paymentConsule(){
        log.debug("request in");
        return "spring cloud with consule "+serverPort + "\t" + UUID.randomUUID().toString();
    }
}
