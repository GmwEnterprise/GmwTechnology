package cn.edu.cqut.gmw.vo;

import cn.edu.cqut.gmw.entity.User;
import cn.edu.cqut.gmw.enums.UserExecStatus;

import java.util.List;

public class UserExecution {

  /**
   * 操作状态
   */
  private UserExecStatus status;

  /**
   * 操作成功后返回数据
   */
  private User user;

  private List<User> userList;

  public UserExecution(UserExecStatus status) {
    this(status, null);
  }

  public UserExecution(UserExecStatus status, User user) {
    this.status = status;
    this.user = user;
  }

  public UserExecStatus getStatus() {
    return status;
  }

  public void setStatus(UserExecStatus status) {
    this.status = status;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }
}
