package xuan.wen.zhi.qin.controllers.file

import org.junit.Assert
import org.junit.Test
import org.springframework.http.MediaType
import org.springframework.mock.web.MockMultipartFile
import org.springframework.test.web.servlet.MvcResult
import xuan.wen.zhi.qin.controllers.BasicTest

/**
 * Created by qinzhiwenxuan on 2017/7/19.
 */
class JunitFileController extends BasicTest {
    private String uri = '/file/';
    private String contentType = MediaType.MULTIPART_FORM_DATA_VALUE + ';charset=UTF-8';

    @Test
    def void upload() {
        MockMultipartFile multipartFile = new MockMultipartFile('file', '7.JPG', contentType, new FileInputStream('E:/resources/image/home/7.JPG').bytes);
        MvcResult result = this.upload(this.uri + 'upload', multipartFile);
        int status = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();
        Assert.assertTrue("错误，正确的返回值为200", status == 200);
        println(content)
    }
}
