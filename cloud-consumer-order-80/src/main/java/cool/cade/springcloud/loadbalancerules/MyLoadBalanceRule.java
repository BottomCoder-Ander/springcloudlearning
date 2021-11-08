package cool.cade.springcloud.loadbalancerules;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Cade
 * @date 08/11/2021 - 20:21
 */
@Component
public class MyLoadBalanceRule implements LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            // 避免溢出
            current = atomicInteger.get();
            next = (current + 1) >= Integer.MAX_VALUE ? 0 : (current + 1);
        } while(!this.atomicInteger.compareAndSet(current, next));
        return next;
    }


    public ServiceInstance instance(List<ServiceInstance> serviceInstance) {

        int index = getAndIncrement() % serviceInstance.size();
        return serviceInstance.get(index);
    }
}
