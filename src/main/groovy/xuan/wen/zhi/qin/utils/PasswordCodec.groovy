package xuan.wen.zhi.qin.utils

import sun.misc.BASE64Encoder

import java.security.MessageDigest

/**
 * Created by qinzhiwenxuan on 2017/7/11.
 */
class PasswordCodec {

    /***
     * 加密
     */
    def static encode = {
        MessageDigest messageDigest = MessageDigest.getInstance('SHA')
        messageDigest.update(it.getBytes('UTF-8'))
        return (new BASE64Encoder().encode(messageDigest.digest()))
    }
}
