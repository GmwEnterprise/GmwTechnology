package cn.edu.cqut.gmw.dao;

import cn.edu.cqut.gmw.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 90949
 */
@Mapper
public interface UserDao {

  /**
   * 通过主键查询字段
   *
   * @param id sys_user表主键
   * @return 结果
   */
  User queryById(Long id);

  List<User> queryList(User user);

  int insert(User user);

  int update(User user);

  int delete(Long id);
}
