package cn.edu.cqut.gmw.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * 封装redis的基本操作
 *
 * @author Gmw
 */
@Service
public class RedisDao {

  private final RedisTemplate<Object, Object> redisTemplate;

  @Autowired
  public RedisDao(RedisTemplate<Object, Object> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public RedisTemplate<Object, Object> getRedisTemplate() {
    return redisTemplate;
  }
}
