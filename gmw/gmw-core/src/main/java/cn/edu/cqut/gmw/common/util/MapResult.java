package cn.edu.cqut.gmw.common.util;

import java.util.HashMap;

/**
 * @author Gmw
 */
public final class MapResult extends HashMap<String, Object> {

  private MapResult() {
  }

  public MapResult set(String key, Object val) {
    put(key, val);
    return this;
  }

  public static MapResult newInstance() {
    return new MapResult();
  }

  public static MapResult success(Object data) {
    return new MapResult().set("success", true).set("data", data);
  }

  public static MapResult success() {
    return new MapResult().set("success", true);
  }

  public static MapResult error(Object error) {
    return new MapResult().set("success", false).set("error", error);
  }

  public static MapResult error() {
    return new MapResult().set("success", false);
  }
}
