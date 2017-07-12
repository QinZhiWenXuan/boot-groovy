package xuan.wen.zhi.qin.controllers.file

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

/**
 * Created by qinzhiwenxuan on 2017/7/12.
 */
@RestController
@RequestMapping(value = "/file/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
class FileController {

    @PostMapping(value = "upload")
    def upload(@RequestParam(name = "file") MultipartFile file) {
        file.transferTo(new File('E:\\resources\\image\\min\\' + file.getOriginalFilename())) ;
        ['code': 200]
    }
}
