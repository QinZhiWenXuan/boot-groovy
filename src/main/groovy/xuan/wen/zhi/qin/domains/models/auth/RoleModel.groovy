package xuan.wen.zhi.qin.domains.models.auth

/**
 * Created by qinzhiwenxuan on 2017/7/13.
 */
class RoleModel {
    Integer id;
    Integer version = 0;
    String roleType;
    String roleDescription;
    String roleName;

    @Override
    public String toString() {
        return "RoleModel{" +
                "id=" + id +
                ", version=" + version +
                ", roleType='" + roleType + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
