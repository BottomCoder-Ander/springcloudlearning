package cool.cade.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Cade
 * @date 09/11/2021 - 21:33
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        /*访问localhost:9527/guonei => http://news.baidu.com/guonei*/
        routes.route("path_baidu", r -> r.path("/guonei")
            .uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
