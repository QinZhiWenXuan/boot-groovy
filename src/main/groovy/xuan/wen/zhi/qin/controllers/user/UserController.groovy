package xuan.wen.zhi.qin.controllers.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import xuan.wen.zhi.qin.controllers.AbstractController
import xuan.wen.zhi.qin.domains.models.user.UserModel
import xuan.wen.zhi.qin.services.user.UserService

/**
 * Created by qinzhiwenxuan on 2017/7/11.
 */
@RestController
@RequestMapping(value = "/user/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ResponseBody
class UserController extends AbstractController<UserModel> {
    @Autowired
    private UserService<UserModel> userService

    /***
     * 注入Service
     */
    @Override
    protected void injectionService() {
        this.basicService = this.userService
    }

    /***
     * 获取所有的结果集
     * @return 结果集
     */
    @GetMapping(value = "users")
    def list() {
        return super.all()
    }

    /***
     * 获取单个对象
     * @param id id
     * @return 对象
     */
    @GetMapping(value = "{id}")
    def get (@PathVariable(value = "id") Integer id) {
        return super.getById(id) ;
    }

    /***
     * 新增
     * @param model 参数
     * @return 结果
     */
    @PostMapping(value = "user")
    def insert(@RequestBody UserModel model) {
        return super.save(model);
    }

    /***
     * 修改
     * @param model 参数
     * @return 结果
     */
    @PutMapping(value = "user")
    def update(@RequestBody UserModel model) {
        return super.edit(model);
    }

    /***
     * 删除
     * @param id ID
     * @return 结果
     */
    @DeleteMapping(value = "{id}")
    def remove (@PathVariable(value = "id") Integer id) {
        return super.deleteById(id) ;
    }
}
