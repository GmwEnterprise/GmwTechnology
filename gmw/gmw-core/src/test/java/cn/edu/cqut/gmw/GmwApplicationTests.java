package cn.edu.cqut.gmw;

import cn.edu.cqut.gmw.dao.UserDao;
import cn.edu.cqut.gmw.redis.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmwApplicationTests {

  @Autowired
  RedisDao dao;

  @Autowired
  UserDao userDao;

  @Test
  public void contextLoads() {
    Object userList = dao.get("userList");
    System.out.println(userList);
  }
}
