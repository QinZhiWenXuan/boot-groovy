package xuan.wen.zhi.qin.domains.models.user

/**
 * Created by qinzhiwenxuan on 2017/7/11.
 */
class UserModel {
    Integer id;
    Integer version = 0;
    String userName;
    String password;
    String email;
    String phone;
    String address;

    @Override
    String toString() {
        return "UserModel{" +
                "id=" + id +
                ", version=" + version +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}'
    }
}
