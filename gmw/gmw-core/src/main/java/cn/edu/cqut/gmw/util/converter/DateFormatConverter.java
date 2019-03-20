package cn.edu.cqut.gmw.util.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

import static cn.edu.cqut.gmw.util.DateUtils.FORMAT_YMDHMS;

/**
 * 日期字符串转换为 java.util.Date
 *
 * @author Gmw
 */
@Component
public class DateFormatConverter implements Converter<String, Date> {

  @Override
  public Date convert(String s) {
    try {
      return FORMAT_YMDHMS.parse(s);
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }
}
