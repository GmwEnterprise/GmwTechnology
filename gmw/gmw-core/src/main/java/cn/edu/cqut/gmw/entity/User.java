package cn.edu.cqut.gmw.entity;

import cn.edu.cqut.gmw.enums.SexEnum;
import cn.edu.cqut.gmw.enums.UserStatusEnum;

import java.util.Date;

/**
 * @author 90949
 */
public class User {

  private Long id;
  private String userName;
  private String phoneNumber;
  private String password;
  private String email;
  private SexEnum sex;
  private Date createTime;
  private UserStatusEnum userStatus;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public SexEnum getSex() {
    return sex;
  }

  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public UserStatusEnum getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(UserStatusEnum userStatus) {
    this.userStatus = userStatus;
  }
}
