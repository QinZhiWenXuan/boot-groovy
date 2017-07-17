package xuan.wen.zhi.qin.controllers

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by qinzhiwenxuan on 2017/7/14.
 */
@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
class HomeController {
    @GetMapping
    def home () {
        ['Welcome']
    }
}
