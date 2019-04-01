package cn.edu.cqut.gmw.dto;

import cn.edu.cqut.gmw.entity.User;
import cn.edu.cqut.gmw.enums.SexEnum;

public class UserMessageDto implements Dto2Entity<User> {

  private Long userId;
  private String userName;
  private String phone;
  private String email;
  private SexEnum sex;
  private String password;

  public UserMessageDto() {}

  public UserMessageDto(User user) {
    this.userId = user.getId();
    this.userName = user.getUserName();
    this.phone = user.getPhoneNumber();
    this.email = user.getEmail();
    this.sex = user.getSex();
    this.password = user.getPassword();
  }

  @Override
  public User toEntity() {
    User user = new User();
    user.setId(userId);
    user.setUserName(userName);
    user.setPhoneNumber(phone);
    user.setEmail(email);
    user.setSex(sex);
    user.setPassword(password);
    return user;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
