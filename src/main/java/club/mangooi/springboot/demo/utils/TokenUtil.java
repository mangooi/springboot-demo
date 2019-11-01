package club.mangooi.springboot.demo.utils;

import club.mangooi.springboot.demo.exception.BusinessException;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class TokenUtil {

    private static StringRedisTemplate redisTemplate ;

    @Resource(name = "stringRedisTemplate")
    public void setRedisTemplate(StringRedisTemplate redisTemplate){
        TokenUtil.redisTemplate = redisTemplate;
    }

    private TokenUtil() {
    }

    public static String create(String key) {
        String saltValue = EncryptUtil.getSalt();
        String tokenValue = EncryptUtil.encrypt(key,saltValue);
        redisTemplate.opsForValue().set(key, saltValue);
        return tokenValue;
    }

    public static String destory(String key,String tokenValue) {
        if (check(key,tokenValue)){
            redisTemplate.delete(key);
            return tokenValue;
        }
        throw new BusinessException("MappingError");
    }

    public static boolean check(String key, String tokenValue) {
        String cacheValue = redisTemplate.opsForValue().get(key);
        if (cacheValue == null) {
            return false;
        }
        return EncryptUtil.check(key,tokenValue,cacheValue);
    }

    public static String parseForKey(String user){
        return Constants.CONSTANT_USER + user;
    }

}
