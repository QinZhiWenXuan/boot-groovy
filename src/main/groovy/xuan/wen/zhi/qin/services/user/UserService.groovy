package xuan.wen.zhi.qin.services.user

import xuan.wen.zhi.qin.domains.models.user.UserModel
import xuan.wen.zhi.qin.services.BasicService

/**
 * Created by qinzhiwenxuan on 2017/7/11.
 */
interface UserService<T> extends BasicService<T> {
    /***
     * 根据email查询用户信息
     * @param email email
     * @return 用户信息
     */
    UserModel queryByEmail(String email)
}