import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import cn.second_hand.user.utils.MongoDBUtil;

// Class for test MongoDB Connection
public class Connect2mlabExample {

	public static void main(String[] args) {
		
//		 ConnectionString connString = new ConnectionString(
//			    "mongodb://marin:a123456@ds019950.mlab.com:19950/heroku_p78k6xgn"
//			);
//			MongoClientSettings settings = MongoClientSettings.builder()
//			    .applyConnectionString(connString)
//			    .retryWrites(false)
//			    .build();
//			MongoClient mongoClient = MongoClients.create(settings);
//			MongoDatabase database = mongoClient.getDatabase("heroku_p78k6xgn");
		    MongoDatabase database = MongoDBUtil.getConnect();
			MongoCollection<Document> collection = database.getCollection("customer");
			Bson filter = Filters.eq("email", "marin1@gmail.com");
			FindIterable findIterable = collection.find(filter);
			Document document = (Document) findIterable.first();
			System.out.println(document);
//			Document result = collection.find(new Document("email","marin@gmail.com")).iterator().next();
//			System.out.println(result.getString("password"));
//			Document query = new Document("_id",new ObjectId("5f420d42e7179a2f18dc4bc5"));
//			Document result = collection.find(query).iterator().next();
//			System.out.println(result.getString("email"));
			//get a document which includes _id = 5f420d42e7179a2f18dc4bc5 , then print its email data
//			collection.insertOne(new Document("email","marin2@gmail.com").append("password", "a123456"));
			//insert a new document to customer collection
	}
}
