package xuan.wen.zhi.qin.services.user.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import xuan.wen.zhi.qin.domains.models.user.UserModel
import xuan.wen.zhi.qin.domains.repositories.user.UserRepository
import xuan.wen.zhi.qin.services.AbstractService
import xuan.wen.zhi.qin.services.user.UserService
import xuan.wen.zhi.qin.utils.PasswordCodec

/**
 * Created by qinzhiwenxuan on 2017/7/11.
 */
@Service("userService")
class UserServiceImpl extends AbstractService<UserModel> implements UserService<UserModel> {

    @Autowired
    private UserRepository userRepository
    /***
     * 注入Repository
     */
    @Override
    protected void injectionRepository() {
        this.basicRepository = this.userRepository
    }

    /***
     * 保存对象
     *
     * @param model 对象
     * @return true : 成功 | false : 失败
     */
    @Override
    boolean save(UserModel model) {
        model.password = PasswordCodec.encode(model.password);
        return super.save(model)
    }

    @Override
    UserModel queryByEmail(String email) {
        return this.userRepository.queryByEmail(email);
    }
}
