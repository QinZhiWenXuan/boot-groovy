package xuan.wen.zhi.qin.services

import xuan.wen.zhi.qin.domains.repositories.BasicRepository

import javax.annotation.PostConstruct

/**
 * Created by qinzhiwenxuan on 2017/7/11.
 */
abstract class AbstractService<T> implements BasicService<T> {
    protected BasicRepository<T> basicRepository

    /***
     * 注入Repository
     */
    protected abstract void injectionRepository()

    /***
     * 初始化
     */
    @PostConstruct
    private void init() {
        this.injectionRepository()
    }

    /***
     * 获取所有的对象
     *
     * @return 结果集
     */
    @Override
    List<T> all() {
        return this.basicRepository.all()
    }

    /***
     * 保存对象
     *
     * @param model 对象
     * @return true : 成功 | false : 失败
     */
    @Override
    boolean save(T model) {
        return this.basicRepository.save(model) > 0
    }

    /***
     * 编辑对象
     *
     * @param model 参数
     * @return true : 成功 | false : 失败
     */
    @Override
    boolean edit(T model) {
        return this.basicRepository.edit(model) > 0
    }

    /***
     * 根据ID获取对象
     *
     * @param id id 主键
     * @return 对象
     */
    @Override
    T getById(Integer id) {
        return this.basicRepository.queryById(id)
    }

    /***
     * 删除
     *
     * @param id id 主键
     * @return true : 成功 | false : 失败
     */
    @Override
    boolean deleteById(Integer id) {
        return this.basicRepository.deleteById(id) > 0
    }
}
