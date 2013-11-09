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
		String addplayer = plugin.getConfig().getString("addplayer");
		if(addplayer == "true"){
			Log.info("Adding players on login enabled!");
			pm.registerEvents(new LoginListener(this), this);
		}
		
		getCommand("setmessage").setExecutor(new SetMessageCommand(this));
		getCommand("getmessage").setExecutor(new GetMessageCommand(this));
		
		
		String dbaddress = plugin.getConfig().getString("dbaddress");
		int dbport = plugin.getConfig().getInt("dbport");
		
		Log.info("Connecting to database at "+dbaddress+":"+dbport);
		try {
			mongo = new MongoClient(dbaddress, dbport);
		} catch (UnknownHostException e) {
			Log.severe("Couldn't connect to database!");
			e.printStackTrace();
		}
	}
	
	public void onDisable(){
		
	}
	
	public DBCollection getCollection(){
		String dbname = plugin.getConfig().getString("dbname");
		String collectionname = plugin.getConfig().getString("collectionname");
		return this.mongo.getDB(dbname).getCollection(collectionname);
	}
	
}
