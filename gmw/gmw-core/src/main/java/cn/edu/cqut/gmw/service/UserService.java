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

  /**
   * 获取User列表
   * @param user 条件
   * @return 结果
   */
  List<User> getList(User user);

  /**
   * 新增一个user
   * @param user 字段
   * @return 受影响行数
   */
  int add(User user);

  /**
   * 修改现有user
   * @param user 字段
   * @return 受影响行数
   */
  int modify(User user);

  /**
   * 删除指定主键的字段
   * @param id 主键
   * @return 受影响行数
   */
  int remove(Long id);
}
