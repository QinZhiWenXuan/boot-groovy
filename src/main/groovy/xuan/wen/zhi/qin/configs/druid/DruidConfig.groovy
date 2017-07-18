package xuan.wen.zhi.qin.configs.druid

import com.alibaba.druid.pool.DruidDataSource
import com.alibaba.druid.support.http.StatViewServlet
import com.alibaba.druid.support.http.WebStatFilter
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator
import org.springframework.boot.bind.RelaxedPropertyResolver
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.EnvironmentAware
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

import javax.sql.DataSource
import java.sql.SQLException

/**
 * Created by qinzhiwenxuan on 2017/7/17.
 */
@Configuration
class DruidConfig implements EnvironmentAware {
    private static final Logger logger = LoggerFactory.getLogger(this.class);
    private RelaxedPropertyResolver propertyResolver;
    /**
     * Set the {@code Environment} that this object runs in.
     */
    @Override
    void setEnvironment(Environment environment) {
        logger.info('setEnvironment ......');
        this.propertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
    }

    @Bean
    def DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.propertyResolver.getProperty('url', String.class));
        datasource.setUsername(this.propertyResolver.getProperty('username', String.class));
        datasource.setPassword(this.propertyResolver.getProperty('password', String.class));
        datasource.setDriverClassName(this.propertyResolver.getProperty('driver-class-name', String.class));
        datasource.setInitialSize(this.propertyResolver.getProperty('initialSize', Integer.class));
        datasource.setMinIdle(this.propertyResolver.getProperty('minIdle', Integer.class));
        datasource.setMaxActive(this.propertyResolver.getProperty('maxActive', Integer.class));
        datasource.setMaxWait(this.propertyResolver.getProperty('maxWait', Integer.class));
        datasource.setTimeBetweenEvictionRunsMillis(this.propertyResolver.getProperty('timeBetweenEvictionRunsMillis', Long.class));
        datasource.setMinEvictableIdleTimeMillis(this.propertyResolver.getProperty('minEvictableIdleTimeMillis', Long.class));
        datasource.setValidationQuery(this.propertyResolver.getProperty('validationQuery', String.class));
        datasource.setTestWhileIdle(this.propertyResolver.getProperty('testWhileIdle', Boolean.class));
        datasource.setTestOnBorrow(this.propertyResolver.getProperty('testOnBorrow', Boolean.class));
        datasource.setTestOnReturn(this.propertyResolver.getProperty('testOnReturn', Boolean.class));
        datasource.setPoolPreparedStatements(this.propertyResolver.getProperty('poolPreparedStatements', Boolean.class));
        try {
            datasource.setFilters("stat,wall");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("druid configuration initialization filter", e);
        }
        return datasource;
    }

    @Bean(value = "druid-stat-interceptor")
    def DruidStatInterceptor druidStatInterceptor() {
        DruidStatInterceptor druidStatInterceptor = new DruidStatInterceptor();
        return druidStatInterceptor;
    }

    @Bean
    def BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setProxyTargetClass(true);
        // 设置要监控的bean的id
        beanNameAutoProxyCreator.setInterceptorNames("druid-stat-interceptor");
        return beanNameAutoProxyCreator;
    }

    @Bean
    def FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    @Bean
    def ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<>();
        // initParameters << ['loginUsername' : 'druid'];// 用户名
        // initParameters << ['loginPassword' : 'druid'];// 密码
        initParameters << ['resetEnable' :'false']; // 禁用HTML页面上的“Reset All”功能
        initParameters << ['allow' : '127.0.0.1']; // IP白名单 (没有配置或者为空，则允许所有访问)
        // initParameters << ['deny' : '192.168.20.38'];// IP黑名单
        // (存在共同时，deny优先于allow)
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }
}
