package club.mangooi.springboot.demo.utils;

import org.apache.tomcat.util.buf.HexUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 加密工具类
 */
public class EncryptUtil {

    private EncryptUtil(){}


    public static String hash(String data){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            return HexUtils.toHexString(md.digest(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getSalt(){
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            return HexUtils.toHexString(random.generateSeed(32));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param s1 验证对象
     * @param s2 从DB或缓存取得的密文
     * @param s3 随机生成的值
     * @return true: success  false: fail
     */
    public static boolean check(String s1,String s2,String s3){
        return s2.equals(hash(hash(s1)+s3));
    }

    public static String encrypt(String data,String salt){
        return hash((EncryptUtil.hash(data) + salt));
    }
}
