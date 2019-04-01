package cn.edu.cqut.gmw.redis;

import cn.edu.cqut.gmw.base.DataStorage;
import cn.edu.cqut.gmw.dto.UserMessageDto;
import cn.edu.cqut.gmw.enums.operation.UserOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Gmw
 */
@Component("redisStorage")
public class RedisStorage implements DataStorage {

  private static final String PREFIX = "REDIS_";

  private final RedisUtils redisUtils;

  @Autowired
  public RedisStorage(RedisUtils redisUtils) {
    this.redisUtils = redisUtils;
  }

  @Override
  public void setUser(String token, Long userId, UserOperation operation) {
    switch (operation) {
      case LOGIN:
        redisUtils.set(token, userId, RedisUtils.EXPIRE_TEN_MINUTES);
        break;
      case LOGOUT:
        if (redisUtils.get(token) != null) {

        }
        break;
      default:
    }
  }

  @Override
  public UserMessageDto getUser(String token) {
    // TODO
    return null;
  }
}
