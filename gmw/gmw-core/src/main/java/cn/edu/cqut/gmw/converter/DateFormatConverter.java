package cn.edu.cqut.gmw.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期字符串转换为 java.util.Date
 *
 * @author Gmw
 */
@Component
public class DateFormatConverter implements Converter<String, Date> {

  private final static SimpleDateFormat
      SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Override
  public Date convert(String s) {
    try {
      return SIMPLE_DATE_FORMAT.parse(s);
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }
}
