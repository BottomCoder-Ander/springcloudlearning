package cool.cade.springcloud;

//import cool.cade.myrule.MyLoadBalanceRuleConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Cade
 * @date 04/11/2021 - 00:14
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
//@RibbonClient(name="CLOUD-PAYMENT-SERVICE", configuration = MyLoadBalanceRuleConfiguration.class)
public class OrderMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class, args);
    }
}
