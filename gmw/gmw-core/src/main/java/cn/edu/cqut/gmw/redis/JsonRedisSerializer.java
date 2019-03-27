package cn.edu.cqut.gmw.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * 自定义JSON序列化工具
 *
 * @param <E> 类型信息
 * @author Gmw
 */
public class JsonRedisSerializer<E> implements RedisSerializer<E> {

  private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

  private Class<E> clazz;

  JsonRedisSerializer(Class<E> clazz) {
    super();
    this.clazz = clazz;
  }

  @Override
  public byte[] serialize(E e) throws SerializationException {
    if (e == null) {
      return new byte[0];
    }
    return JSON.toJSONString(e, SerializerFeature.WriteClassName)
        .getBytes(DEFAULT_CHARSET);
  }

  @Override
  public E deserialize(byte[] bytes) throws SerializationException {
    if (bytes == null || bytes.length < 1) {
      return null;
    }
    String s = new String(bytes, DEFAULT_CHARSET);
    return JSON.parseObject(s, clazz);
  }
}
