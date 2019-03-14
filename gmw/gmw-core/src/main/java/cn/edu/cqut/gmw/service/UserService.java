package cn.edu.cqut.gmw.service;

import cn.edu.cqut.gmw.entity.User;

import java.util.List;

/**
 * @author Gmw
 */
public interface UserService {

  /**
   * 获取单个User实例
   *
   * @param id 主键
   * @return 结果
   */
  User get(Long id);

  List<User> getList(User user);

  int add(User user);

  int modify(User user);

  int remove(Long id);
}
