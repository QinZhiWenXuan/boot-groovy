package xuan.wen.zhi.qin.domains.repositories
/**
 * Created by qinzhiwenxuan on 2017/7/11.
 */

interface BasicRepository<T> {

    /***
     * 获取所有的参数
     *
     * @return 结果集
     */
    List<T> all()

    /***
     * 保存
     *
     * @param model 参数
     * @return 受影响行数 , 不是ID
     */
    int save(T model)

    /***
     * 编辑
     *
     * @param model 参数
     * @return 受影响行数 , 不是ID
     */
    int edit(T model)

    /***
     * 根据ID获取对象
     *
     * @param id id 主键
     * @return 对象
     */
    T queryById(Integer id)

    /***
     * 删除
     *
     * @param id id 主键
     * @return 受影响行数 , 不是ID
     */
    int deleteById(Integer id)
}