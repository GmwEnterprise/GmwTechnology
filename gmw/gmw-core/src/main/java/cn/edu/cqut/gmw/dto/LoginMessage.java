package cn.edu.cqut.gmw.dto;

/**
 * 登陆信息的封装
 *
 * @author Gmw
 */
public class LoginMessage {

  private String phone;
  private String password;

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
