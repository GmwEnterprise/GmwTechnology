package cn.edu.cqut.gmw.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author 90949
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserStatusEnum {

  /**
   * 正常账户
   */
  NORMAL(1),

  /**
   * 已注销
   */
  LOGOUT(2),

  /**
   * 已停用
   */
  STOP_USING(3);

  int index;

  UserStatusEnum(int index) {
    this.index = index;
  }

  public static UserStatusEnum valueOf(int index) {
    for (UserStatusEnum value : values()) {
      if (index == value.index) {
        return value;
      }
    }
    return null;
  }

  public int getIndex() {
    return index;
  }
}
