package com.zcy.cms.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class TestMongodb {

    public static void main(String[] args) {

        try {
            //1.链接到mongodb服务
            MongoClient mongoClient = new MongoClient("113.209.26.156", 27017);
            //2.链接导数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("zcy_mongodb");
            //3.获取集合
            MongoCollection<Document> collection = mongoDatabase.getCollection("zcy_mongodb");

            //4.插入文档
            Document document = new Document("title","MongoDbDocument_java").append("description","database").append("likes",100).append("by","fly");
            Document document2 = new Document("title","MongoDbDocument_java2").append("description","database2").append("likes",1002).append("by","fly2");
            List<Document> list = new ArrayList<Document>();
            list.add(document);
            list.add(document2);

            //集合插入文档
            collection.insertMany(list);

            System.out.println("链接数据库成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
