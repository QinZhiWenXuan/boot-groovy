package xuan.wen.zhi.qin.domains.models.example

/**
 * Created by qinzhiwenxuan on 2017/7/10.
 */
class TestModel {
    Integer id
    String name

    @Override
    String toString() {
        return "TestModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}'
    }
}
