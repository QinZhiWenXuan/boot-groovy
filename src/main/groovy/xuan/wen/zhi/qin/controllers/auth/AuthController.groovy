package xuan.wen.zhi.qin.controllers.auth

import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.subject.Subject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import xuan.wen.zhi.qin.domains.models.user.UserModel
import xuan.wen.zhi.qin.utils.PasswordCodec

/**
 * Created by qinzhiwenxuan on 2017/7/14.
 */
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(this.class);

    @PostMapping(value = "login")
    def Map<String, Object> login(@RequestBody UserModel model) {
        Map<String, Object> result = new HashMap<>();
        Subject subject = SecurityUtils.getSubject()
        logger.debug('request login ...');
        UsernamePasswordToken token = new UsernamePasswordToken(model.email, PasswordCodec.encode(model.password));
        try {
            subject.login(token);
        } catch (Exception e) {
            result << ['code': '403'];
            result << ['message': e.getLocalizedMessage()];
            logger.error('登陆失败 : {}', e.getLocalizedMessage());
        }
        if (subject.isAuthenticated()) {
            result << ['code': '200'];
            result << ['message': 'success'];
        }
        return result;
    }

    @GetMapping(value = "logout")
    def Map<String, Object> logout() {
        Subject subject = SecurityUtils.getSubject()
        subject.logout();
        ['code': '200', 'message': 'success']
    }
}
