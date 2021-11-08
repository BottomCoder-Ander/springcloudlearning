package cool.cade.springcloud.loadbalancerules;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
/**
 * @author Cade
 * @date 08/11/2021 - 20:25
 */
public interface LoadBalance {
    ServiceInstance instance(List<ServiceInstance> serviceInstance);
}
