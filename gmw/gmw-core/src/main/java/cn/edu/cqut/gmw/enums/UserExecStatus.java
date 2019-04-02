package cn.edu.cqut.gmw.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserExecStatus {
  /**
   * 成功
   */
  SUCCESS(100, "成功"),
  /**
   * 密码错误
   */
  WRONG_PASSWORD(101, "密码错误"),
  /**
   * 禁止登陆
   */
  NOT_ALLOW(102, "禁止登陆"),
  /**
   * 不存在
   */
  NOT_EXIST(103, "不存在"),
  /**
   * 创建用户失败
   */
  CREATE_FAILED(104, "创建用户失败"),
  /**
   * 参数错误
   */
  ERROR_PARAMS(105, "参数错误"),
  /**
   * 未知错误
   */
  UNKNOWN_ERR(-1, "未知错误");

  int state;
  String message;

  UserExecStatus(int state, String message) {
    this.state = state;
    this.message = message;
  }

  public int getState() {
    return state;
  }

  public String getMessage() {
    return message;
  }
}
