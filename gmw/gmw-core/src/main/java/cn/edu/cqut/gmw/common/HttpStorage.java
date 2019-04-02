package cn.edu.cqut.gmw.common;

import java.util.List;

/**
 * 网络信息存储
 *
 * @author Gmw
 */
public interface HttpStorage {

  /**
   * 存储信息
   *
   * @param name  键
   * @param value 值
   */
  void setAttribute(String name, Object value);

  /**
   * 获取信息
   *
   * @param name 键
   * @return 值
   */
  Object getAttribute(String name);

  /**
   * 移除信息
   *
   * @param name 键
   */
  void removeAttribute(String name);

  /**
   * 获取所有键
   *
   * @return 键列表
   */
  List<String> getAttributeNames();
}
