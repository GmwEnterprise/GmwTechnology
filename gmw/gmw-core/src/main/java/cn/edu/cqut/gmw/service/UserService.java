package cn.edu.cqut.gmw.service;

import cn.edu.cqut.gmw.entity.User;
import cn.edu.cqut.gmw.vo.UserExecution;

/**
 * 用户类的操作
 *
 * @author Gmw
 */
public interface UserService {

  /**
   * 用户登陆
   *
   * @param phone    手机号
   * @param password 密码
   * @return 登陆结果
   */
  UserExecution userLogin(String phone, String password);

  UserExecution createUser(User createUser);
}
