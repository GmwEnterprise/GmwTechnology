package cn.edu.cqut.gmw.service;

import cn.edu.cqut.gmw.dto.UserMessageDto;
import cn.edu.cqut.gmw.dto.execution.UserExecution;
import cn.edu.cqut.gmw.enums.status.LoginStatus;
import cn.edu.cqut.gmw.enums.status.RegisterStatus;

/**
 * 用户类的操作
 *
 * @author Gmw
 */
public interface UserService {

  /**
   * 验证用户信息，用于登陆
   *
   * @param userMessage 用户信息
   * @return 执行后的结果
   */
  UserExecution<LoginStatus> validUser(UserMessageDto userMessage);

  /**
   * 添加新的账户
   * @param userMessage 账户基本信息
   * @return 添加结果
   */
  UserExecution<RegisterStatus> addNewUser(UserMessageDto userMessage);
}
