package cn.edu.cqut.gmw.dao;

import cn.edu.cqut.gmw.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 90949
 */
@Mapper
public interface UserDao {

  User queryById(Long id);

  User queryByPhone(String phoneNumber);

  List<User> queryList(User user);

  int insert(User user);

  int update(User user);

  int delete(Long id);
}
