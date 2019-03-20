package cn.edu.cqut.gmw.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 监控spring生命周期
 *
 * @author Gmw
 */
@Component
public class DataSourceShow implements ApplicationContextAware {

  @Override
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    DataSource dataSource = context.getBean(DataSource.class);
    System.out.println("-----------------------------------------------------");
    System.out.println("Spring生命周期监控 -> DataSource class name : " + dataSource.getClass().getName());
    System.out.println("-----------------------------------------------------");
  }
}
