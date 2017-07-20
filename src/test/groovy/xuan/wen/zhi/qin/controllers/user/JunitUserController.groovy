package xuan.wen.zhi.qin.controllers.user

import groovy.json.JsonOutput
import org.junit.Assert
import org.junit.Test
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import xuan.wen.zhi.qin.controllers.BasicTest
import xuan.wen.zhi.qin.domains.models.user.UserModel

class JunitUserController extends BasicTest {
    private String uri = '/user/';
    private String contentType = MediaType.APPLICATION_JSON_UTF8_VALUE;

    @Test
    def void list() {
        this.test(HttpMethod.GET, this.uri + 'users', this.contentType, '', {
            String content = it.getResponse().getContentAsString();
            int status = it.getResponse().getStatus();
            Assert.assertTrue("错误，正确的返回值为200", status == 200);
            println(content)
        });
    }

    @Test
    def void get() {
        this.test(HttpMethod.GET, this.uri + '3', this.contentType, '', {
            String content = it.getResponse().getContentAsString();
            int status = it.getResponse().getStatus();
            Assert.assertTrue("错误，正确的返回值为200", status == 200);
            println(content)
        });
    }

    @Test
    def void save() {
        UserModel model = new UserModel(userName: 'admin', password: 'admin', email: 'admin@gmail.com', phone: '18218976021', address: '广东省');
        this.test(HttpMethod.POST, this.uri + 'user', contentType, JsonOutput.toJson(model), {
            String content = it.getResponse().getContentAsString();
            int status = it.getResponse().getStatus();
            Assert.assertTrue("错误，正确的返回值为200", status == 200);
            println(content)
        })
    }

    @Test
    def void update () {
        UserModel model = new UserModel(id : 4 , userName: 'manager',  phone: '18218976023', address: '广东省');
        this.test(HttpMethod.PUT, this.uri + 'user', contentType, JsonOutput.toJson(model), {
            String content = it.getResponse().getContentAsString();
            int status = it.getResponse().getStatus();
            Assert.assertTrue("错误，正确的返回值为200", status == 200);
            println(content)
        })
    }

    @Test
    def void delete () {
        this.test(HttpMethod.DELETE, this.uri + '4', this.contentType, '', {
            String content = it.getResponse().getContentAsString();
            int status = it.getResponse().getStatus();
            Assert.assertTrue("错误，正确的返回值为200", status == 200);
            println(content)
        });
    }
}
