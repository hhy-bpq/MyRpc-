package com.hhy.mydubbo.rpcregist;

import com.hhy.mydubbo.rpcserver.RpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author：huanghaiyun
 * @Date:2017/12/18
 */
@RpcService(RegistService.class)
public class RegistServiceImpl implements RegistService {

    @Autowired
    private StringRedisTemplate redisTemplate;
    private static final String key="registMapKey";

    @Override
    public boolean regist(String url, String name) {
        redisTemplate.opsForHash().put(key,name,url);
        return true;
    }

    @Override
    public long clean(String name) {
        return redisTemplate.opsForHash().delete(key,name);
    }

    @Override
    public String getUrl(String name) {
        return (String) redisTemplate.opsForHash().get(key,name);
    }

}
