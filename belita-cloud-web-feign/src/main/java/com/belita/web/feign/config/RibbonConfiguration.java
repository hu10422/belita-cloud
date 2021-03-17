package com.belita.web.feign.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 设置全局的负载均衡策略
 */
@Configuration
//@AvoidScan 自定义注解
public class RibbonConfiguration {

    /**
     * ribbon的策略
     * <p>
     * RandomRule	随机策略	随机选择server
     * RoundRobinRule	轮询策略	按照顺序选择server（ribbon默认策略）
     * RetryRule	重试策略	在一个配置时间段内，当选择server不成功，则一直尝试选择一个可用的server
     * BestAvailableRule	最低并发策略	逐个考察server，如果server断路器打开，则忽略，再选择其中并发链接最低的server
     * AvailabilityFilteringRule	可用过滤策略	过滤掉一直失败并被标记为circuit tripped的server，过滤掉那些高并发链接的server（active connections超过配置的阈值）
     * ResponseTimeWeightedRule	响应时间加权重策略	根据server的响应时间分配权重，响应时间越长，权重越低，被选择到的概率也就越低。响应时间越短，权重越高，被选中的概率越高，这个策略很贴切，综合了各种因素，比如：网络，磁盘，io等，都直接影响响应时间
     * ZoneAvoidanceRule	区域权重策略	综合判断server所在区域的性能，和server的可用性，轮询选择server并且判断一个AWS Zone的运行性能是否可用，剔除不可用的Zone中的所有server
     */
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
