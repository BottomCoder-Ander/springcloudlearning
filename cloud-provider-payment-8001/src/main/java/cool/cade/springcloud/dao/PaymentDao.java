package cool.cade.springcloud.dao;

import cool.cade.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Cade
 * @date 03/11/2021 - 21:03
 */
@Mapper
//@Repository ,repository不会自动动态代理？？
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
