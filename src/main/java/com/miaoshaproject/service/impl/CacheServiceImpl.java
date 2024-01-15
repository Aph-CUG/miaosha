package com.miaoshaproject.service.impl;

//import com.google.common.cache.Cache;
//import com.google.common.cache.CacheBuilder;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.miaoshaproject.service.CacheService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

//TODO: JVM内存的可控性？   脏读时间控制   ConcurrentHashmap没有淘汰机制
//TODO： 单例？
@Service
public class CacheServiceImpl implements CacheService {
//    private Cache<String,Object> commonCache = null;
//
//    @PostConstruct
//    public void init(){
//        commonCache = CacheBuilder.newBuilder()
//                //设置缓存容器的初始容量为10
//                .initialCapacity(10)
//                //设置缓存中最大可以存储100个KEY,超过100个之后会按照LRU的策略移除缓存项
//                .maximumSize(100)
//                //设置写缓存后多少秒过期
//                .expireAfterWrite(60, TimeUnit.SECONDS).build();
//    }

    //TODO： 由guava cache 改为 Caffeine cache 性能待比较
    private Cache<String,Object> commonCache = null;

    @PostConstruct
    public void init(){
        commonCache = Caffeine.newBuilder()
                // 设置最后一次写入或访问后经过固定时间过期
                .expireAfterWrite(60, TimeUnit.SECONDS)
                // 初始的缓存空间大小
                .initialCapacity(10)
                // 缓存的最大条数
                .maximumSize(100)
                .build();
    }

    @Override
    public void setCommonCache(String key, Object value) {
            commonCache.put(key,value);
    }

    @Override
    public Object getFromCommonCache(String key) {
        return commonCache.getIfPresent(key);
    }
}
