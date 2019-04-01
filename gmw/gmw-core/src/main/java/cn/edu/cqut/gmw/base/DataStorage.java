package cn.edu.cqut.gmw.base;

import cn.edu.cqut.gmw.dto.UserMessageDto;
import cn.edu.cqut.gmw.enums.operation.UserOperation;

/**
 * 会话信息存储
 *
 * @author Gmw
 */
public interface DataStorage {

  /**
   * 存储用户登陆信息
   * @param token token
   * @param userId 用户信息主键
   */
  void setUser(String token, Long userId, UserOperation operation);

  UserMessageDto getUser(String token);
}
