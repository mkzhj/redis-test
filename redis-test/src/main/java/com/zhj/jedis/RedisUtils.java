package com.zhj.jedis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtils {
    private static JedisPool pool;

    public static JedisPool open(String ip,int port){
        if(pool == null){
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(20);
            config.setMaxIdle(2);
            config.setTestOnBorrow(true);

            pool = new JedisPool(config,ip,port,6000,"123456");

        }
        return pool;
    }

    public static void close(){
        if (pool != null){
            pool.close();
        }
    }

}
