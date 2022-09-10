package com.zhj.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

public class JedisTransactionTest {
    public static void main(String[] args) {
        //连接Redis
        Jedis jedis1 = new Jedis("192.168.213.128",6379);
        jedis1.auth("123456");
        String ping = jedis1.ping();
        System.out.println("Redis的工作状态是：" + ping);


        Transaction tran = jedis1.multi();
        tran.set("k6","v6111");
        tran.set("k7","v7111");
        tran.set("k8","v8111");
        tran.exec();


    }

}
