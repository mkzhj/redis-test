package com.zhj.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

public class JedisKeyTest {
    public static void main(String[] args) {
        //连接Redis
        Jedis jedis1 = new Jedis("192.168.213.128",6379);
        jedis1.auth("123456");
        String ping = jedis1.ping();
        System.out.println("Redis的工作状态是：" + ping);



        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = RedisUtils.open("192.168.213.128",6379);
            jedis = pool.getResource();



            Set<String> keys = jedis1.keys("*");
            //遍历key
            for (String key:keys){
                System.out.println(key);



            }

        }finally {
            if( jedis != null){
                jedis.close();

            }

        }

        //这个执行了set kk vkk指令
//        String set = jedis1.set("kk","vkk");
//        System.out.println(set);

        //这是追加，在key的value后面追加字符串。返回值是追加之后的整个字符串的长度
//        Long append1 = jedis1.append("kk","111");
//        System.out.println(append1);


    }
}
