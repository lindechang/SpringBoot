package com.lindec.springboot.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static java.util.Collections.singletonList;

/**
 * Created by iCoderc on 2015/6/15.
 */
@Configuration
@EnableMongoRepositories(basePackages = {"com.lindec.springboot.repository"})
public class MongoDBConfig extends AbstractMongoConfiguration {
    @Autowired
    private Environment env;

    //    @Override
//    public String getDatabaseName() {
//        return "webtest-service";
//    }
//
//    @Override
//    public Mongo mongo() throws Exception {
//        return new MongoClient(singletonList(new ServerAddress("127.0.0.1",
//                27017)),
//                singletonList(MongoCredential.createCredential("lindec",
//                       "webtest-service",
//                        "123456".toCharArray())));
//    }
    @Override
    public String getDatabaseName() {
        return env.getProperty("mongo.database");
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(singletonList(new ServerAddress(env.getProperty("mongo.address"),
                env.getProperty("mongo.port", Integer.class))),
                singletonList(MongoCredential.createCredential(env.getProperty("mongo.username"),
                        env.getProperty("mongo.database"),
                        env.getProperty("mongo.password").toCharArray())));
    }
}
