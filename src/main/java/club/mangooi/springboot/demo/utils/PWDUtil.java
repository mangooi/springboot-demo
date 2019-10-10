package club.mangooi.springboot.demo.utils;

import club.mangooi.springboot.demo.utils.model.PWDModel;
import org.apache.tomcat.util.buf.HexUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 用户密码加密工具类
 */
public class PWDUtil {
    private PWDUtil(){}

    private static String hash(String data){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = data.getBytes("UTF-8");
            return HexUtils.toHexString(md.digest(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getSalt(){
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            return HexUtils.toHexString(random.generateSeed(32));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PWDModel initPwd(String pwd){
        String pwdTemp = hash(pwd);
        String salt = getSalt();
        return new PWDModel(hash(pwdTemp+salt),salt);
    }

    public static boolean checkPwd(PWDModel model,String pwd){
        return model.getHashedPassword().equals(hash(hash(pwd)+model.getSaltKey()));
    }

}
