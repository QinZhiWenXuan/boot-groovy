package xuan.wen.zhi.qin.rabbit

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

/**
 * Created by qinzhiwenxuan on 2017/7/18.
 */
@Component
@RabbitListener(queues = "login.task")
class LoginTask {
    private static final Logger logger = LoggerFactory.getLogger(this.class);

    @RabbitHandler
    def receiveMessage(String message) {
        logger.info('receiveMessage\t{}', message.toString());
    }
}
