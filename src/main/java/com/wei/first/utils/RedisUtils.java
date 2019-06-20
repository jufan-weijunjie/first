package com.wei.first.utils;


import io.lettuce.core.RedisClient;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * FileName：RedisUtils
 *
 * @author 魏俊杰
 * @date 16:13 2019/4/28
 */
public class RedisUtils {
    //非切片客户端连接
    //非切片连接池
    private JedisPool jedisPool;
    //切片客户端连接
    private ShardedJedis shardedJedis;
    //切片连接池
    private ShardedJedisPool shardedJedisPool;

    public void aa(){
    }


    public static void main(String args[]){
        Jedis jedis = new Jedis("123.206.199.77",6379);
        jedis.auth("weijunjie123");
        String aaa = jedis.set("aaa", "123");
        System.out.println(aaa);
    }
}
