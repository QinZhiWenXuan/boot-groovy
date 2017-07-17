package xuan.wen.zhi.qin.domains.models.auth

/**
 * Created by qinzhiwenxuan on 2017/7/13.
 */
class RolePermissionModel {
    Integer id;
    Integer version = 0;
    Integer roleId;
    Integer permissionId;

    @Override
    public String toString() {
        return "RolePermissionModel{" +
                "id=" + id +
                ", version=" + version +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }
}
