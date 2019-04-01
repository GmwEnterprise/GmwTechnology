package cn.edu.cqut.gmw.enums.status;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 登陆状态
 *
 * @author Gmw
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LoginStatus {

  /**
   * 登录成功
   */
  SUCCESS(1, "登陆成功"),

  /**
   * 密码错误
   */
  WRONG_PASSWORD(2, "密码错误"),

  /**
   * 账户不存在
   */
  NOT_EXISTS(3, "账户不存在"),

  /**
   * 账户已停用
   */
  STOP_USING(4, "账户已停用"),

  /**
   * 输入参数错误
   */
  INVALID_PARAM(5, "参数错误");

  int code;

  String msg;

  LoginStatus(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
