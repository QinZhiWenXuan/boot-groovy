package xuan.wen.zhi.qin.configs.rabbit

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.boot.bind.RelaxedPropertyResolver
import org.springframework.context.EnvironmentAware
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.core.env.Environment

/**
 * Created by qinzhiwenxuan on 2017/7/18.
 */
@Configuration
class RabbitConfig implements EnvironmentAware {
    private static final Logger logger = LoggerFactory.getLogger(this.class);
    private RelaxedPropertyResolver propertyResolver;
    /**
     * Set the {@code Environment} that this object runs in.
     */
    @Override
    void setEnvironment(Environment environment) {
        logger.info('RabbitConfig setEnvironment ......');
        this.propertyResolver = new RelaxedPropertyResolver(environment, "spring.rabbitmq.");
    }

    @Bean
    def ConnectionFactory connectionFactory() {
        logger.debug('connectionFactory init ....')
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setHost(this.propertyResolver.getProperty('host', String.class));
        factory.setPort(this.propertyResolver.getProperty('port', Integer.class));
        factory.setUsername(this.propertyResolver.getProperty('user', String.class));
        factory.setPassword(this.propertyResolver.getProperty('password', String.class));
        factory.setVirtualHost(this.propertyResolver.getProperty('virtual-host', String.class));
        /** 如果要进行消息回调，则这里必须要设置为true
        factory.setPublisherConfirms(this.propertyResolver.getProperty('publisher-confirms', Boolean.class));
         */
        return factory;
    }

    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    def RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(this.connectionFactory());
    }

    @Bean
    def org.springframework.amqp.core.Queue loginQueue() {
        return new org.springframework.amqp.core.Queue('login.task');
    }
}
