package cn.edu.cqut.gmw.service.impl;

import cn.edu.cqut.gmw.base.DataStorage;
import cn.edu.cqut.gmw.dao.UserDao;
import cn.edu.cqut.gmw.dto.UserMessageDto;
import cn.edu.cqut.gmw.dto.execution.UserExecution;
import cn.edu.cqut.gmw.entity.User;
import cn.edu.cqut.gmw.enums.status.LoginStatus;
import cn.edu.cqut.gmw.enums.status.RegisterStatus;
import cn.edu.cqut.gmw.service.UserService;
import cn.edu.cqut.gmw.util.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static cn.edu.cqut.gmw.util.ParamValidators.*;
import static cn.edu.cqut.gmw.util.SecretUtils.decodePassword;

/**
 * @author Gmw
 */
@Service
public class UserServiceImpl implements UserService {

  private final UserDao userDao;
  private final DataStorage storage;

  public UserServiceImpl(
      UserDao userDao,
      @Qualifier("redisStorage") DataStorage storage) {
    this.userDao = userDao;
    this.storage = storage;
  }

  @Override
  public UserExecution<LoginStatus> validUser(UserMessageDto userMessage) {
    String phoneNumber = userMessage.getPhone();
    String password = decodePassword(userMessage.getPassword());
    if (!validPhoneNumber(phoneNumber) || StringUtils.isBlank(password)) {
      // 登陆参数输入错误
      return new UserExecution<>(LoginStatus.INVALID_PARAM);
    }
    User user = userDao.queryByPhone(phoneNumber);
    if (user != null && user.getId() != null) {
      if (user.getPassword().equals(password)) {

        return new UserExecution<>(LoginStatus.SUCCESS, new UserMessageDto(user));
      } else {
        // 密码错误
        return new UserExecution<>(LoginStatus.WRONG_PASSWORD);
      }
    } else {
      // 账户不存在
      return new UserExecution<>(LoginStatus.NOT_EXISTS);
    }
  }

  @Override
  public UserExecution<RegisterStatus> addNewUser(UserMessageDto userMessage) {
    boolean arg1 = validPhoneNumber(userMessage.getPhone());
    if (arg1) {
      int effect = userDao.insert(userMessage.toEntity());
      if (effect == 1) {
        return new UserExecution<>(RegisterStatus.SUCCESS, userMessage);
      }
    }
    return new UserExecution<>(RegisterStatus.FAILED);
  }
}
