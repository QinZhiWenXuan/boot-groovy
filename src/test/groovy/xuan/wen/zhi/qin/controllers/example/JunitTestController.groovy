package xuan.wen.zhi.qin.controllers.example

import groovy.json.JsonOutput
import org.junit.Assert
import org.junit.Test
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import xuan.wen.zhi.qin.controllers.BasicTest
import xuan.wen.zhi.qin.domains.models.example.TestModel

/**
 * Created by qinzhiwenxuan on 2017/7/19.
 */

class JunitTestController extends BasicTest {
    private String uri = '/index/test';
    private String contentType = MediaType.APPLICATION_JSON_UTF8_VALUE;

    @Test
    def void get() {
        MvcResult result = this.getMethod(this.uri + '?id=1&name=王尼玛', this.contentType);
        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();
        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        println(content)
    }

    @Test
    def void testCall () {
        this.test(HttpMethod.GET , this.uri + '?id=1&name=王尼玛' , this.contentType , '' , {
            String content = it.getResponse().getContentAsString();
            int status = it.getResponse().getStatus();
            Assert.assertTrue("错误，正确的返回值为200", status == 200);
            println(content)
        })
    }

    @Test
    def void save() {
        TestModel model = new TestModel(id: 2, name: '小明');
//        MvcResult result = this.mvc.perform(MockMvcRequestBuilders.post(this.uri).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(JsonOutput.toJson(model))).andReturn();
        MvcResult result = this.request(HttpMethod.POST, this.uri, this.contentType, JsonOutput.toJson(model));
        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();
        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        println(content)
    }

    @Test
    def void update() {
        TestModel model = new TestModel(id: 2, name: '小明');
        MvcResult result = this.request(HttpMethod.PUT, this.uri, this.contentType, JsonOutput.toJson(model));
        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();
        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        println(content)
    }

    @Test
    def void delete() {
//        MvcResult result = this.mvc.perform(MockMvcRequestBuilders.delete(this.uri + '/1')).andReturn();
        MvcResult result = this.request(HttpMethod.DELETE, this.uri + '/1', this.contentType,'');
        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();
        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        println(content)
    }
}

