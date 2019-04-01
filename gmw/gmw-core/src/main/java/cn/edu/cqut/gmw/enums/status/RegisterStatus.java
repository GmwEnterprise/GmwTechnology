package cn.edu.cqut.gmw.enums.status;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RegisterStatus {

  /**
   * 注册成功
   */
  SUCCESS(1, "注册成功"),

  /**
   * 注册失败
   */
  FAILED(2, "注册失败");

  int code;

  String msg;

  RegisterStatus(int code, String msg) {
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
