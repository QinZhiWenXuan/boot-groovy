package xuan.wen.zhi.qin.aop.rabbit

import groovy.json.JsonOutput
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import xuan.wen.zhi.qin.domains.models.task.LoginTask

/**
 * Created by qinzhiwenxuan on 2017/7/18.
 */
@Component
@Aspect
class LoginAop {
    private static final Logger logger = LoggerFactory.getLogger(this.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @AfterReturning(value = "execution(* xuan.wen.zhi.qin.controllers.auth.AuthController.login(..))", returning = "result")
    def Object task(JoinPoint joinPoint, Object result) {
        LoginTask task = new LoginTask(email: joinPoint.getArgs()[0].email, code: result.code, message: result.message);
        logger.debug('task \t {}', JsonOutput.toJson(task));
        try {
            this.rabbitTemplate.convertAndSend('login.task' ,JsonOutput.toJson(task));
        } catch (Exception e) {
            logger.error('rabbit error \t {}' , e.localizedMessage) ;
            e.printStackTrace() ;
        }
        return result;
    }
}
