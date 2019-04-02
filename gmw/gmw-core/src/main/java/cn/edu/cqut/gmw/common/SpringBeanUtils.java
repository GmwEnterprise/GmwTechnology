package cn.edu.cqut.gmw.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 监控spring生命周期，并提供操作
 *
 * @author Gmw
 */
@Component
public class SpringBeanUtils implements ApplicationContextAware {

  private ApplicationContext context = null;

  @Override
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    if (this.context == null) {
      this.context = context;
    }
  }

  public Object getBean(String beanName) {
    return context.getBean(beanName);
  }

  public Object getBean(Class<?> requiredType) {
    return context.getBean(requiredType);
  }

  public Object getBean(String beanName, Class<?> requiredType) {
    return context.getBean(beanName, requiredType);
  }
}
