package com.zh.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @描述： TODO 配置缓存
 * @作者: Light
 * @时间: 2019/10/9  22:26
 * @版本：
 */
@Configuration
@EnableCaching // 开启缓存
public class CachingConfig {
    /* @Author Light
     * @Description //TODO  声明缓存管理器
     * @Date 22:27 2019/10/9
     * @Param
     * @returnS
     **/
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

}
