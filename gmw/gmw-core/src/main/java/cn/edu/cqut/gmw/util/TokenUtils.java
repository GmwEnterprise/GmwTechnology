package cn.edu.cqut.gmw.util;

import java.util.UUID;

/**
 * @author Gmw
 */
public final class TokenUtils {

  public static String getSimpleToken() {
    return UUID.randomUUID().toString();
  }
}
