package xuan.wen.zhi.qin.domains.repositories.user

import org.springframework.stereotype.Repository
import xuan.wen.zhi.qin.domains.models.user.UserModel
import xuan.wen.zhi.qin.domains.repositories.BasicRepository

/**
 * Created by qinzhiwenxuan on 2017/7/11.
 */
@Repository(value = "userRepository")
interface UserRepository extends BasicRepository<UserModel> {

    /***
     * 根据email查询用户
     * @param email email
     * @return 用户
     */
    UserModel queryByEmail(String email);
}