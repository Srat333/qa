package com.qingjiao.qa.util;


import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.config.CacheManagementConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.time.Duration;

@Configuration
public class RedisCacheConfig {

  @Bean
  public CacheManager cacheManager(RedisConnectionFactory factory) {
    RedisCacheConfiguration cacheConfig1 = RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofMinutes(10))
            .prefixCacheNameWith("cache: question:")
            .disableCachingNullValues()
            .serializeKeysWith(keyPair())
            .serializeValuesWith(valuePair());
    return RedisCacheManager.builder(factory)
            .withCacheConfiguration("question",cacheConfig1)
            .build();

  }

  private RedisSerializationContext.SerializationPair<String> keyPair() {
    return RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
  }

  private RedisSerializationContext.SerializationPair<Object> valuePair() {
    return RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
  }



}
