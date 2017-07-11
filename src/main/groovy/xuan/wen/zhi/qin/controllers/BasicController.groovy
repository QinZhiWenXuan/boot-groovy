package xuan.wen.zhi.qin.controllers

/**
 * Created by qinzhiwenxuan on 2017/7/11.
 */
interface BasicController<T> {
    /***
     * 获取所有的对象
     *
     * @return 结果集
     */
    List<T> all()

    /***
     * 保存对象
     *
     * @param model 对象
     * @return 结果
     */
    Map<String, Object> save(T model)

    /***
     * 编辑对象
     *
     * @param model 参数
     * @return 结果
     */
    Map<String, Object> edit(T model)

    /***
     * 根据ID获取对象
     *
     * @param id id 主键
     * @return 对象
     */
    T getById(Integer id)

    /***
     * 删除
     *
     * @param id id 主键
     * @return 结果
     */
    Map<String, Object> deleteById(Integer id)
}