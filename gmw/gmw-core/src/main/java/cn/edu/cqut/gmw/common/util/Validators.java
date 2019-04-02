package cn.edu.cqut.gmw.common.util;

import org.apache.commons.lang.StringUtils;

/**
 * 参数验证工具类
 *
 * @author Gmw
 */
public final class Validators {

  /**
   * 验证手机号码
   *
   * @param phoneNumber 手机号
   * @return 合法返回true
   */
  public static boolean validPhoneNumber(String phoneNumber) {
    // TODO
    return StringUtils.isNotBlank(phoneNumber) && StringUtils.isNumeric(phoneNumber);
  }
}
