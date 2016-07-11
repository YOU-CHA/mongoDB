package com.kata.banque;

import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;

@SpringBootApplication
//@EnableMongoRepositories(basePackages={"org.com.kata.banque.dao"})
@ComponentScan
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		MongoClient mongo = new MongoClient("localhost", 27017);
		MongoDatabase database = mongo.getDatabase("test");
		CreateCollectionOptions options = new CreateCollectionOptions();
		database.createCollection("sequence", options) ;
		MongoCollection<Document> collection = database.getCollection("sequence");
		Document document = new Document();
		document.put("_id", "CLIENT");
		document.put("seq", 0);
		collection.insertOne(document);
		document.put("_id", "OPERATION");
		collection.insertOne(document);
	}
}
