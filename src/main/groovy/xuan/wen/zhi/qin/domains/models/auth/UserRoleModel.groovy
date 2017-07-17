package xuan.wen.zhi.qin.domains.models.auth

/**
 * Created by qinzhiwenxuan on 2017/7/13.
 */
class UserRoleModel {
    Integer id;
    Integer version = 0;
    Integer roleId;
    Integer userId;

    @Override
    public String toString() {
        return "UserRoleModel{" +
                "id=" + id +
                ", version=" + version +
                ", roleId=" + roleId +
                ", userId=" + userId +
                '}';
    }
}
