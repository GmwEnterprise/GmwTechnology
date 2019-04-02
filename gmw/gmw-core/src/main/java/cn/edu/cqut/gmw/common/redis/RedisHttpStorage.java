package cn.edu.cqut.gmw.common.redis;

import cn.edu.cqut.gmw.common.HttpStorage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TODO
 * @author Gmw
 */
@Component
public class RedisHttpStorage implements HttpStorage {

  @Override
  public void setAttribute(String name, Object value) {

  }

  @Override
  public Object getAttribute(String name) {
    return null;
  }

  @Override
  public void removeAttribute(String name) {

  }

  @Override
  public List<String> getAttributeNames() {
    return null;
  }
}
