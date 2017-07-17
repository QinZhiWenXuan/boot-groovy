package xuan.wen.zhi.qin.configs.shiro

import org.apache.shiro.spring.web.ShiroFilterFactoryBean
import org.apache.shiro.web.mgt.DefaultWebSecurityManager
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import xuan.wen.zhi.qin.auth.shiro.AuthRealm

/**
 * Created by qinzhiwenxuan on 2017/7/13.
 */
@Configuration
class ShiroConfig {
    private static final Logger = LoggerFactory.getLogger(ShiroConfig.class);

    @Bean
    def AuthRealm authRealm() {
        return new AuthRealm();
    }

    @Bean
    def DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(this.authRealm());
        return securityManager;
    }


    @Bean
    def ShiroFilterFactoryBean shiroFilter(org.apache.shiro.mgt.SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap << ['/static/**': 'anon'];
        filterChainDefinitionMap << ['/login': 'anon'];
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap << ['/logout': 'logout'];
        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap << ['/**': 'authc'];
//        filterChainDefinitionMap << ['/**' : 'anon'] ;
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        println("Shiro拦截器工厂类注入成功");
        Logger.debug("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }
}
