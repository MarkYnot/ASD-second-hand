package cn.second_hand.user.dao;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import cn.second_hand.user.domain.User;
import cn.second_hand.user.utils.MongoDBUtil;

public class UserDao {
	private MongoDatabase database = MongoDBUtil.getConnect();
	private MongoCollection<Document> collection = database.getCollection("customer");
	public void register(User user) {
		collection.insertOne(new Document("email",user.getEmail()).append("password", user.getPassword()));
	}

	public Document findByEmail(String email) {
		Bson filter = Filters.eq("email", email);
		FindIterable findIterable = collection.find(filter);
		Document document = (Document) findIterable.first();
		return document;
	}

}
