package im.prox.TalkingHeads;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class HeadUtils {

	public static String getMessage(HeadPlugin plugin, String username){
		String usernamefield = plugin.getConfig().getString("usernamefield");
		String messagefield = plugin.getConfig().getString("messagefield");
		BasicDBObject query = new BasicDBObject(usernamefield, username);
		BasicDBObject projection = new BasicDBObject(messagefield, 1);
		DBCursor cursor = plugin.getCollection().find(query, projection);
		DBObject result = cursor.next();
		if(result.get(messagefield) == null){
			return null;
		}
		else {
			String message = result.get(messagefield).toString();
			return message;
		}
	}
	
	public static void setMessage(HeadPlugin plugin, String username, String message){
		String usernamefield = plugin.getConfig().getString("usernamefield");
		String messagefield = plugin.getConfig().getString("messagefield");
		BasicDBObject match = new BasicDBObject(usernamefield, username);
		BasicDBObject update = new BasicDBObject("$set", new BasicDBObject(messagefield, message));
		plugin.getCollection().update(match, update);
	}
	
	public static boolean playerExists(HeadPlugin plugin, String username){
		String usernamefield = plugin.getConfig().getString("usernamefield");
		BasicDBObject query = new BasicDBObject(usernamefield, username);
		DBCursor cursor = plugin.getCollection().find(query);
		if(cursor.hasNext()){
			return true;
		}
		return false;
	}
	
	public static void addPlayer(HeadPlugin plugin, String username){
		String usernamefield = plugin.getConfig().getString("usernamefield");
		BasicDBObject player = new BasicDBObject(usernamefield, username);
		plugin.getCollection().insert(player);
	}
	
}
