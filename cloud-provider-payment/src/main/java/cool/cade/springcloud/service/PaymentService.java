package cool.cade.springcloud.service;

import cool.cade.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author Cade
 * @date 03/11/2021 - 21:19
 */

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
