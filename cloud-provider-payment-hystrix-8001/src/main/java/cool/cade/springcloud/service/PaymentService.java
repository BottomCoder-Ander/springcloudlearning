package cool.cade.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Cade
 * @date 09/11/2021 - 10:12
 */
@Service
@Slf4j
public class PaymentService {

    public String paymentInfo(Long id) {
        return "线程池" + Thread.currentThread().getName() + "papmentInfo_OK,id" +id + "\n";
    }

//    模拟超时
    // 兜底方法，超时和异常会自动调用
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHanlder",
        commandProperties = {
        // 超时时间设置为2秒
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="2000")
    })
    public String paymentInfoTimeout(Long id) {
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.info("sleep 异常发生");
        }
        log.info("即将返回结果");
        return "线程池" + Thread.currentThread().getName() + "papmentInfo_OK,id" +id + "\t" + "耗时"+time+"秒\n";
    }

    public String paymentInfoTimeoutHanlder(Long id) {
        log.info("timeout handler");
        return "线程池" + Thread.currentThread().getName() + "paymentInfoTimeoutHanlder,id" + id + "\t" + "超时";
    }

}
