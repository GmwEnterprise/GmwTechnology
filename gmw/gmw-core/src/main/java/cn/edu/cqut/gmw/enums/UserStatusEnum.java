package cn.edu.cqut.gmw.enums;

/**
 * @author 90949
 */

public enum UserStatusEnum {

  /**
   * 正常账户
   */
  NORMAL(1),

  /**
   * 已注销
   */
  LOGOUT(1),

  /**
   * 已停用
   */
  STOP_USING(1);

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
