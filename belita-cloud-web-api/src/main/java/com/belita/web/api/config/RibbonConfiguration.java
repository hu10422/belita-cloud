package com.belita.web.api.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonConfiguration {


    /**
     * 设置负载均衡策略
     * RandomRule：随机选取负载均衡策略，随机Random对象，在所有服务实例中随机找一个服务的索引号，然后从上线的服务中获取对应的服务。
     * RoundRobinRule：线性轮询负载均衡策略。 默认
     * WeightedResponseTimeRule：响应时间作为选取权重的负载均衡策略，根据平均响应时间计算所有服务的权重，响应时间越短的服务权重越大，被选中的概率越高。刚启动时，如果统计信息不足，则使用线性轮询策略，等信息足够时，再切换到WeightedResponseTimeRule。
     * RetryRule：使用线性轮询策略获取服务，如果获取失败则在指定时间内重试，重新获取可用服务。
     * ClientConfigEnabledRoundRobinRule：默认通过线性轮询策略选取服务。通过继承该类，并且对choose方法进行重写，可以实现更多的策略，继承后保底使用RoundRobinRule策略。
     * BestAvailableRule：继承自ClientConfigEnabledRoundRobinRule。从所有没有断开的服务中，选取到目前为止请求数量最小的服务。
     * PredicateBasedRule：抽象类，提供一个choose方法的模板，通过调用AbstractServerPredicate实现类的过滤方法来过滤出目标的服务，再通过轮询方法选出一个服务。
     * AvailabilityFilteringRule：按可用性进行过滤服务的负载均衡策略，会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数超过阈值的服务，然后对剩余的服务列表进行线性轮询。
     * ZoneAvoidanceRule：本身没有重写choose方法，用的还是抽象父类PredicateBasedRule的choose。
     *
     * @return
     */
    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
