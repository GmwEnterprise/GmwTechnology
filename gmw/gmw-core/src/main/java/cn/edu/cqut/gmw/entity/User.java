package cn.edu.cqut.gmw.entity;

import cn.edu.cqut.gmw.enums.SexEnum;
import cn.edu.cqut.gmw.enums.UserStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author 90949
 */
@Alias("user")
public class User {

  private Long id;
  private String userName;
  private String phoneNumber;
  private String password;
  private String email;
  private SexEnum sex;
  private Date createTime;
  private String createAddr;
  private String createMac;
  private Date lastLoginTime;
  private String lastLoginAddr;
  private UserStatusEnum userStatus;

  public User() {
  }

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

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getCreateAddr() {
    return createAddr;
  }

  public void setCreateAddr(String createAddr) {
    this.createAddr = createAddr;
  }

  public String getCreateMac() {
    return createMac;
  }

  public void setCreateMac(String createMac) {
    this.createMac = createMac;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public String getLastLoginAddr() {
    return lastLoginAddr;
  }

  public void setLastLoginAddr(String lastLoginAddr) {
    this.lastLoginAddr = lastLoginAddr;
  }

  public UserStatusEnum getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(UserStatusEnum userStatus) {
    this.userStatus = userStatus;
  }
}
