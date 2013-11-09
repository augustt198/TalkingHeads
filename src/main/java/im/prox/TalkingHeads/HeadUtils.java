package im.prox.TalkingHeads;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class HeadUtils {

	public static String getMessage(DBCollection collection, String username){
		BasicDBObject query = new BasicDBObject("username", username);
		BasicDBObject projection = new BasicDBObject("message", 1);
		DBCursor cursor = collection.find(query, projection);
		DBObject result = cursor.next();
		String message = result.get("message").toString();		
		return message;
	}
	
	public static void setMessage(DBCollection collection, String username, String message){
		BasicDBObject match = new BasicDBObject("username", username);
		BasicDBObject update = new BasicDBObject("$set", new BasicDBObject("message", message));
		collection.update(match, update);
	}
	
	public static boolean playerExists(DBCollection collection, String username){
		BasicDBObject query = new BasicDBObject("username", username);
		DBCursor cursor = collection.find(query);
		if(cursor.hasNext()){
			return true;
		}
		return false;
	}
	
}
