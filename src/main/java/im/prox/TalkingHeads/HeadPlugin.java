package im.prox.TalkingHeads;

import java.net.UnknownHostException;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class HeadPlugin extends JavaPlugin{
	
	HeadPlugin plugin;
	MongoClient mongo;
	
	public void onEnable(){
		plugin = this;
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new HeadListener(this), this);
		
		getCommand("setmessage").setExecutor(new SetMessageCommand(this));
		getCommand("getmessage").setExecutor(new GetMessageCommand(this));
		
		Log.info("Connecting to database");
		try {
			mongo = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			Log.severe("Couldn't connect to database!");
			e.printStackTrace();
		}
	}
	
	public void onDisable(){
		
	}
	
	public DBCollection getCollection(){
		return this.mongo.getDB("test").getCollection("test");
	}
	
}
