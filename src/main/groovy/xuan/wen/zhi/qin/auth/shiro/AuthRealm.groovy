package xuan.wen.zhi.qin.auth.shiro

import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.AuthenticationInfo
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.authz.AuthorizationInfo
import org.apache.shiro.authz.SimpleAuthorizationInfo
import org.apache.shiro.realm.AuthorizingRealm
import org.apache.shiro.subject.PrincipalCollection
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import xuan.wen.zhi.qin.domains.models.user.UserModel
import xuan.wen.zhi.qin.services.user.UserService

/**
 * Created by qinzhiwenxuan on 2017/7/13.
 */
class AuthRealm extends AuthorizingRealm {
    private static final Logger logger = LoggerFactory.getLogger(this.class);
    @Autowired
    private UserService<UserModel> userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = null;
        logger.debug('授权认证 。。。。 ');
        String loginName = super.getAvailablePrincipal(principalCollection).toString();
        UserModel model = userService.queryByEmail(loginName);
        Optional.of(model).ifPresent({ consumer ->
            Set<String> roles = new HashSet<>();
            roles << 'authc';
            info = new SimpleAuthorizationInfo();
            info.setRoles(roles);
        });
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.debug('登陆认证 。。。。 ');
        org.apache.shiro.authc.SimpleAuthenticationInfo info = null;
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserModel model = userService.queryByEmail(token.username);
        Optional.of(model).ifPresent({ consumer ->
            info = new org.apache.shiro.authc.SimpleAuthenticationInfo(model.email, model.password, this.getName());
        });
        return info;
    }
}
