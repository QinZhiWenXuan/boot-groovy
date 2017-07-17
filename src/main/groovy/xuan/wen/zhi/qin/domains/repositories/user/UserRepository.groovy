package xuan.wen.zhi.qin.domains.repositories.user

import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Repository
import xuan.wen.zhi.qin.domains.models.user.UserModel
import xuan.wen.zhi.qin.domains.repositories.BasicRepository

/**
 * Created by qinzhiwenxuan on 2017/7/11.
 */
@Repository(value = "userRepository")
@CacheConfig(cacheNames = "users")
interface UserRepository extends BasicRepository<UserModel> {
    /***
     * 获取所有的参数
     *
     * @return 结果集
     */
    @Cacheable
    List<UserModel> all();

    /***
     * 根据ID获取对象
     *
     * @param id id 主键
     * @return 对象
     */
    @Cacheable
    UserModel queryById(Integer id) ;
    /***
     * 根据email查询用户
     * @param email email
     * @return 用户
     */
    @Cacheable
    UserModel queryByEmail(String email);
}