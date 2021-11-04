package cool.cade.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.jdbc.DataSourceHealthContributorAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Cade
 * @date 04/11/2021 - 00:14
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class OrderMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class, args);
    }
}
