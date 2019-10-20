package club.mangooi.springboot.demo.utils;

import club.mangooi.springboot.demo.utils.model.PWDModel;

/**
 * 密码工具类
 */
public class PWDUtil {
    private PWDUtil(){}

    public static PWDModel initPwd(String pwd){
        String pwdTemp = EncryptUtil.hash(pwd);
        String salt = EncryptUtil.getSalt();
        return new PWDModel(EncryptUtil.hash(pwdTemp+salt),salt);
    }

    public static boolean checkPwd(PWDModel model,String pwd){
        return EncryptUtil.check(pwd,model.getHashedPassword(),model.getSaltKey());
    }

}
