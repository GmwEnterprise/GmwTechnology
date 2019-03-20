package cn.edu.cqut.gmw.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gmw
 */
public final class AjaxResult extends HashMap<String, Object> {

  private final static String CODE_KEY = "code";

  private final static String MESSAGE_KEY = "message";

  private AjaxResult() {
  }

  public AjaxResult set(String key, Object val) {
    put(key, val);
    return this;
  }

  /**
   * 无法覆盖原本的code和message
   *
   * @param map 数据集合
   * @return 结果
   */
  public AjaxResult setAll(Map<String, Object> map) {
    Object code = get(CODE_KEY);
    Object message = get(MESSAGE_KEY);
    putAll(map);
    put(CODE_KEY, code);
    put(MESSAGE_KEY, message);
    return this;
  }

  public static AjaxResult success(String message) {
    AjaxResult ajaxResult = new AjaxResult();
    ajaxResult.put(CODE_KEY, "1");
    ajaxResult.put(MESSAGE_KEY, message);
    return ajaxResult;
  }

  public static AjaxResult success() {
    AjaxResult ajaxResult = new AjaxResult();
    ajaxResult.put(CODE_KEY, "1");
    ajaxResult.put(MESSAGE_KEY, "success");
    return ajaxResult;
  }

  public static AjaxResult error(String message) {
    AjaxResult ajaxResult = new AjaxResult();
    ajaxResult.put(CODE_KEY, "0");
    ajaxResult.put(MESSAGE_KEY, message);
    return ajaxResult;
  }

  public static AjaxResult error() {
    AjaxResult ajaxResult = new AjaxResult();
    ajaxResult.put(CODE_KEY, "0");
    ajaxResult.put(MESSAGE_KEY, "error");
    return ajaxResult;
  }
}
