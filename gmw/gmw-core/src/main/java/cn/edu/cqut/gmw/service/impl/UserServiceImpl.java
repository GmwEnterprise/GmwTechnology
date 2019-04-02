package cn.edu.cqut.gmw.service.impl;

import cn.edu.cqut.gmw.dao.UserDao;
import cn.edu.cqut.gmw.entity.User;
import cn.edu.cqut.gmw.enums.UserExecStatus;
import cn.edu.cqut.gmw.enums.UserStatusEnum;
import cn.edu.cqut.gmw.service.UserService;
import cn.edu.cqut.gmw.vo.UserExecution;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Gmw
 */
@Service
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public UserExecution userLogin(String phone, String password) {
    User user = new User();
    user.setPhoneNumber(phone);
    List<User> users = userDao.queryList(user).stream()
        .filter(u -> !u.getUserStatus().equals(UserStatusEnum.LOGOUT))
        .collect(Collectors.toList());
    if (users.size() == 1) {
      // 用户存在
      User exist = users.get(0);
      if (exist.getUserStatus().equals(UserStatusEnum.NORMAL)) {
        // 用户状态正常
        if (exist.getPassword().equals(password)) {
          // 密码正确，登陆成功
          saveLogin(exist);
          return new UserExecution(UserExecStatus.SUCCESS, exist);
        }
        return new UserExecution(UserExecStatus.WRONG_PASSWORD);
      }
      return new UserExecution(UserExecStatus.NOT_ALLOW);
    }
    return new UserExecution(UserExecStatus.NOT_EXIST);
  }

  @Transactional(rollbackFor = Throwable.class)
  @Override
  public UserExecution createUser(User createUser) {
    initCreateUser(createUser);
    int col = userDao.insert(createUser);
    if (col == 1) {
      return new UserExecution(UserExecStatus.SUCCESS);
    }
    return new UserExecution(UserExecStatus.CREATE_FAILED);
  }

  /**
   * 初始化需要创建的用户数据
   * @param createUser 需要创建的数据
   */
  private void initCreateUser(User createUser) {
    Date now = new Date();
    createUser.setCreateTime(now);
  }

  /**
   * 保存用户登陆撞他
   * @param user 用户
   */
  private void saveLogin(User user) {

  }
}
