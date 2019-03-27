package cn.edu.cqut.gmw.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * Redis配置，覆盖掉默认的自动配置
 *
 * @author Gmw
 * @see org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration
 */
@EnableCaching
@Configuration
@ConditionalOnClass(RedisOperations.class)
@EnableConfigurationProperties({ RedisProperties.class })
public class RedisConfig {

  @Bean
  @ConditionalOnMissingBean(name = "redisTemplate")
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();

    // 使用FastJson序列化
    JsonRedisSerializer<Object> jsonRedisSerializer = new JsonRedisSerializer<>(Object.class);

    // value值的序列化采用fastJsonRedisSerializer
    template.setValueSerializer(jsonRedisSerializer);
    template.setHashValueSerializer(jsonRedisSerializer);

    // key的序列化采用StringRedisSerializer
    StringRedisSerializer keySerializer = new StringRedisSerializer();
    template.setKeySerializer(keySerializer);
    template.setHashKeySerializer(keySerializer);
    template.setConnectionFactory(redisConnectionFactory);
    return template;
  }

  @Bean
  @ConditionalOnMissingBean
  public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
    StringRedisTemplate template = new StringRedisTemplate();
    template.setConnectionFactory(redisConnectionFactory);
    return template;
  }

  /**
   * 自定义redis缓存管理器
   *
   * @param redisConnectionFactory redis连接工厂，来自自动注入
   * @return 管理器bean
   */
  @Bean(name = "redisCacheManager")
  public RedisCacheManager initRedisCacheManager(RedisConnectionFactory redisConnectionFactory) {
    RedisCacheWriter writer = RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory);
    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
        // 设置键序列化
        .serializeKeysWith(
            RedisSerializationContext
                .SerializationPair
                .fromSerializer(new StringRedisSerializer()))
        // 设置值序列化
        .serializeValuesWith(
            RedisSerializationContext
                .SerializationPair
                .fromSerializer(new JsonRedisSerializer<>(Object.class)))
        // 禁止自动添加键前缀
        .disableKeyPrefix()
        // 禁止缓存null值
        .disableCachingNullValues()
        // 超时时间10分钟
        .entryTtl(Duration.ofSeconds(60 * 10));
    return new RedisCacheManager(writer, config);
  }
}
