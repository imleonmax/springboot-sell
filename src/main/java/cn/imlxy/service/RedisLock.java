package cn.imlxy.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     * @param key
     * @param value 当前时间+超时时间
     * @return
     */
    //下面代码解决了 死锁问题 和 保证只有一个线程拿锁。
/**1.死锁 。当相关代码之前上锁后，如果执行代码的过程中抛错了，
 那么就会出现没有解锁的问题，后续线程无法获得锁，也就出现了死锁的问题。
 而以下代码后有返回true的可能，也就解决了死锁问题。
 */
    /**2.保证只有一个线程拿锁。比如两个线程同时进入下面代码，并且其value都为B，currentValue = A。
     一条代码只可能一个线程执行。
     当第一个线程执行时，oldvalue = A，如果符合if条件成功拿锁。
     当第二个执行时oldValue就已经是B了，所以保证了只有一个线程拿锁。
     */
    public boolean lock(String key, String value) {
        //如果键不存在则新增,存在则不改变已经有的值。
        if(redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
        //currentValue=A   这两个线程的value都是B  其中一个线程拿到锁
        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁过期
        if (!StringUtils.isEmpty(currentValue)
                && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            //获取上一个锁的时间
            //设置指定 key 的值，并返回 key 的旧值。
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e) {
            log.error("【redis分布式锁】解锁异常, {}", e);
        }
    }

}
