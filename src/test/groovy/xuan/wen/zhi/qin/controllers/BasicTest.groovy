package xuan.wen.zhi.qin.controllers

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpMethod
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

/**
 * Created by qinzhiwenxuan on 2017/7/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
class BasicTest {
    @Autowired
    protected MockMvc mvc;

    protected void test(HttpMethod httpMethod, String uri, String contentType, String content, Closure closure) {
        closure.call(this.request(httpMethod, uri, contentType, content));
    }

    protected MvcResult getMethod(String uri, String contentType) {
        return this.mvc.perform(MockMvcRequestBuilders.get(uri).contentType(contentType)).andReturn();
    }

    protected MvcResult request(HttpMethod httpMethod, String uri, String contentType, String content) {
        return this.mvc.perform(MockMvcRequestBuilders.request(httpMethod, uri).contentType(contentType).content(content))
                .andReturn();
    }

    protected MvcResult upload(String uri, MockMultipartFile multipartFile) {
        return this.mvc.perform(MockMvcRequestBuilders.fileUpload(uri).file(multipartFile)).andReturn();
    }

}
