package cn.edu.cqut.gmw;

import cn.edu.cqut.gmw.dao.UserDao;
import cn.edu.cqut.gmw.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmwApplicationTests {

  @Autowired
  UserDao userDao;

  @Test
  @Transactional
  public void contextLoads() {
    // 一级缓存生效必须开启事务，不然系统会在执行完一句sql后将sqlsession关闭掉，再执行又是不同的sqlsession
    User user1 = userDao.queryById(1L);
    user1.setUserName("阿甘");
    User user2 = userDao.queryById(1L);
    System.out.println("user1(" + user1.hashCode() + ") -- " + user1);
    System.out.println("user2(" + user2.hashCode() + ") -- " + user2);
  }
}
