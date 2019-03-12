package cn.edu.cqut.gmw.enums;

/**
 * @author Gmw
 */

public enum SexEnum {

  /**
   * 男
   */
  MAN(1),

  /**
   * 女
   */
  WOMAN(2);

  int index;

  SexEnum(int index) {
    this.index = index;
  }

  public static SexEnum valueOf(int index) {
    for (SexEnum value : values()) {
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
