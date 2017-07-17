package xuan.wen.zhi.qin.domains.models.auth

/**
 * Created by qinzhiwenxuan on 2017/7/13.
 */
class PermissionModel {
    Integer id;
    Integer version = 0;
    String url;
    String permissionDescription;
    String permissionName;

    @Override
    public String toString() {
        return "PermissionModel{" +
                "id=" + id +
                ", version=" + version +
                ", url='" + url + '\'' +
                ", permissionDescription='" + permissionDescription + '\'' +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }
}
