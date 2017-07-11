package xuan.wen.zhi.qin.controllers.example

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import xuan.wen.zhi.qin.domains.models.example.TestModel

/**
 * Created by qinzhiwenxuan on 2017/7/10.
 */
@RestController
@RequestMapping(value = "/index/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ResponseBody
class TestController {

    @GetMapping
    def test(TestModel model) {
        println(model)
        def result = ['code': 200, 'message': 'success']
        return result
    }

    @PostMapping
    def save(@RequestBody TestModel model) {
        println(model)
        def result = ['code': 200, 'message': 'success']
        return result
    }

    @PutMapping
    def update(@RequestBody TestModel model) {
        println(model)
        def result = ['code': 200, 'message': 'success']
        return result
    }

    @DeleteMapping(value = "/{id}")
    def delete(@PathVariable Integer id) {
        println(id)
        def result = ['code': 200, 'message': 'success']
        return result
    }
}
