package xuan.wen.zhi.qin.controllers

import xuan.wen.zhi.qin.services.BasicService

import javax.annotation.PostConstruct

/**
 * Created by qinzhiwenxuan on 2017/7/11.
 */
abstract class AbstractController<T> implements BasicController<T> {

    protected BasicService<T> basicService

    /***
     * 注入Service
     */
    protected abstract void injectionService()

    /***
     * 初始化
     */
    @PostConstruct
    private void init() {
        this.injectionService();
    }

    /***
     * 处理返回结果
     * @param bool true : 成功 | false : 失败
     * @return map
     */
    private Map<String, Object> handlerResult(boolean bool) {
        Map<String, Object> result = new HashMap<>(2);
        result.put("code", bool ? 200 : 500);
        result.put("message", bool ? "success" : "fail");
        return result;
    }
    /***
     * 获取所有的对象
     *
     * @return 结果集
     */
    @Override
    List<T> all() {
        return this.basicService.all();
    }

    /***
     * 保存对象
     *
     * @param model 对象
     * @return 结果
     */
    @Override
    Map<String, Object> save(T model) {
        return this.handlerResult(this.basicService.save(model));
    }

    /***
     * 编辑对象
     *
     * @param model 参数
     * @return 结果
     */
    @Override
    Map<String, Object> edit(T model) {
        return this.handlerResult(this.basicService.edit(model));
    }

    /***
     * 根据ID获取对象
     *
     * @param id id 主键
     * @return 对象
     */
    @Override
    T getById(Integer id) {
        return this.basicService.getById(id);
    }

    /***
     * 删除
     *
     * @param id id 主键
     * @return 结果
     */
    @Override
    Map<String, Object> deleteById(Integer id) {
        return this.handlerResult(this.basicService.deleteById(id));
    }
}
