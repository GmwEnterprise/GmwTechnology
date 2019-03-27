package cn.edu.cqut.gmw.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 封装redis的基本操作
 *
 * @author Gmw
 */
@Service
public class RedisUtils {

  public static final long EXPIRE_TEN_MINUTES = 10L;
  public static final long EXPIRE_ONE_HOUR = 60L;
  public static final long EXPIRE_TWO_HOURS = 120L;
  public static final long EXPIRE_ONE_DAY = 60L * 24L;

  private final RedisTemplate<String, Object> template;

  @Autowired
  public RedisUtils(RedisTemplate<String, Object> template) {
    this.template = template;
  }

  /**
   * 存储数据，有效时间单位为分钟
   *
   * @param key    键
   * @param val    值
   * @param expire 有效时间
   */
  public void set(String key, Object val, long expire) {
    template.opsForValue().set(key, val, expire, TimeUnit.MINUTES);
  }

  /**
   * 获取数据，获取不到则返回null
   *
   * @param key 键
   * @return 结果
   */
  public Object get(String key) {
    try {
      return template.opsForValue().get(key);
    } catch (NullPointerException e) {
      return null;
    }
  }
}
