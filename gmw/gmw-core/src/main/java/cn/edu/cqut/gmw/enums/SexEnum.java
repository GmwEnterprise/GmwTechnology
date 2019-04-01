package cn.edu.cqut.gmw.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Gmw
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SexEnum {

  /**
   * 男
   */
  MAN(1, "男"),

  /**
   * 女
   */
  WOMAN(2, "女");

  int index;

  String name;

  SexEnum(int index, String name) {
    this.index = index;
    this.name = name;
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

  public String getName() {
    return name;
  }
}
