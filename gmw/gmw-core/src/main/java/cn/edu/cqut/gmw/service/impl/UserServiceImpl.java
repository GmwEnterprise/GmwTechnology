package cn.edu.cqut.gmw.service.impl;

import cn.edu.cqut.gmw.dao.UserDao;
import cn.edu.cqut.gmw.entity.User;
import cn.edu.cqut.gmw.service.UserService;
import org.springframework.stereotype.Service;

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

  @Override
  public User get(Long id) {
    return userDao.queryById(id);
  }

  @Override
  public List<User> getList(User user) {
    return userDao.queryList(user);
  }

  @Override
  public int add(User user) {
    return userDao.insert(user);
  }

  @Override
  public int modify(User user) {
    return userDao.update(user);
  }

  @Override
  public int remove(Long id) {
    return userDao.delete(id);
  }
}
