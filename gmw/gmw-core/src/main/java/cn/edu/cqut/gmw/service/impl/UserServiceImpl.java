package cn.edu.cqut.gmw.service.impl;

import cn.edu.cqut.gmw.dao.UserDao;
import cn.edu.cqut.gmw.entity.User;
import cn.edu.cqut.gmw.enums.UserStatusEnum;
import cn.edu.cqut.gmw.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Gmw
 */
@Service
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Cacheable(
      value = "redisCache",
      key = "'redis_user_' + #id")
  @Override
  public User get(Long id) {
    return userDao.queryById(id);
  }

  @Override
  public List<User> getList(User user) {
    return userDao.queryList(user);
  }

  @CachePut(
      value = "redisCache",
      key = "'redis_user_' + #result.id")
  @Override
  public User add(User user) {
    user.setCreateTime(new Date());
    user.setUserStatus(UserStatusEnum.NORMAL);
    userDao.insert(user);
    return user;
  }

  @CachePut(
      value = "redisCache",
      key = "'redis_user_' + #result.id",
      condition = "#result != null")
  @Override
  public User modify(User user) {
    // 这里调用get方法不会从缓存中取数据
    // 因为aop无法代理类自调用的方法
    User original = get(user.getId());
    if (original == null) {
      return null;
    }
    original.setUserName(user.getUserName());
    original.setPassword(user.getPassword());
    original.setSex(user.getSex());
    original.setPhoneNumber(user.getPhoneNumber());
    original.setEmail(user.getEmail());
    userDao.update(original);
    return original;
  }

  @CacheEvict(
      value = "redisCache",
      key = "'redis_user_' + #id",
      beforeInvocation = true)
  @Override
  public int remove(Long id) {
    return userDao.delete(id);
  }
}
