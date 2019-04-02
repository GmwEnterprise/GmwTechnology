package cn.edu.cqut.gmw.common.redis;

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
}
