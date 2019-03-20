package cn.edu.cqut.gmw.util;

import java.text.SimpleDateFormat;

/**
 * 时间工具类
 *
 * @author Gmw
 */
public final class DateUtils {

  /**
   * 时间字符串转换器<br/>
   * 格式：yyyy-MM-dd HH:mm:ss
   */
  public final static SimpleDateFormat
      FORMAT_YMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  /**
   * 时间字符串转换器<br/>
   * 格式：yyyy-MM-dd
   */
  public final static SimpleDateFormat
      FORMAT_YMD = new SimpleDateFormat("yyyy-MM-dd");

  /**
   * 时间字符串转换器<br/>
   * 格式：yyyy-MM-dd HH:mm:ss.SSS
   */
  public final static SimpleDateFormat
      FORMAT_YMDHMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
}
