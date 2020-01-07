package com.zh.mongodb;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/8  22:32
 * @版本：
 */
@Configuration
@EnableMongoRepositories("com.zh")
public class MongoConfig extends AbstractMongoConfiguration {
    @Override
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    @Override
    protected String getDatabaseName() {
        return "OrdersDB";
    }

    public static void main(String[] args) {
        Class<MongoConfig> mongoConfigClass = MongoConfig.class;
        System.out.println(mongoConfigClass.getName());
        System.out.println(MongoConfig.class.getPackage());
        System.out.println(MongoConfig.class.getPackage().getName());
    }
}
