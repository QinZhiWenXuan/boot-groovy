package xuan.wen.zhi.qin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by qinzhiwenxuan on 2017/7/10.
 */
@SpringBootApplication
@EnableCaching
@MapperScan("xuan.wen.zhi.qin.domains.repositories")
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }
}
