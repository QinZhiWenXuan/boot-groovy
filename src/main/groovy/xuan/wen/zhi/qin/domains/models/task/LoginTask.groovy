package xuan.wen.zhi.qin.domains.models.task

/**
 * Created by qinzhiwenxuan on 2017/7/18.
 */
class LoginTask implements Serializable {
    String email;
    String code;
    String message;
    long time = System.currentTimeMillis();

    @Override
    public String toString() {
        return "LoginTask{" +
                "email='" + email + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", time=" + time +
                '}';
    }
}
