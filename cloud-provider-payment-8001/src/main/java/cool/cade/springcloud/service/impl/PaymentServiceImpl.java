package cool.cade.springcloud.service.impl;

import cool.cade.springcloud.dao.PaymentDao;
import cool.cade.springcloud.entities.Payment;
import cool.cade.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Cade
 * @date 03/11/2021 - 21:22
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    //    为什么用resource不用Autowired
    // spring支持JSR-250规范定义的注解，Resource按照name进行注入
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
