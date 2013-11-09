package im.prox.TalkingHeads;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginListener implements Listener{

	final HeadPlugin plugin;
	
	public LoginListener(HeadPlugin plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void PlayerLogin(PlayerLoginEvent event){
		String username = event.getPlayer().getName();
		if(!HeadUtils.playerExists(plugin, username)){
			HeadUtils.addPlayer(plugin, username);
		}
	}
	
}
