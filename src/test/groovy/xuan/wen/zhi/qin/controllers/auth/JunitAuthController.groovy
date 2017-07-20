package xuan.wen.zhi.qin.controllers.auth

import groovy.json.JsonOutput
import org.junit.Assert
import org.junit.Test
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import xuan.wen.zhi.qin.controllers.BasicTest
import xuan.wen.zhi.qin.domains.models.user.UserModel

class JunitAuthController extends BasicTest {

    @Test
    def void login() {
        String uri = '/login';
        UserModel model = new UserModel(password: 'root', email: 'root@126.com');
        MvcResult result = this.request(HttpMethod.POST , uri , MediaType.APPLICATION_JSON_UTF8_VALUE , JsonOutput.toJson(model)) ;
        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();
        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        println(content);
    }
}
