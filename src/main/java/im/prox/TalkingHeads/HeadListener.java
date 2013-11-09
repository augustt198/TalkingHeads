package im.prox.TalkingHeads;

import org.bukkit.ChatColor;
import org.bukkit.SkullType;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class HeadListener implements Listener{

	final HeadPlugin plugin;
	
	public HeadListener(HeadPlugin plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void PlayerInteract(PlayerInteractEvent event){
		Player player = event.getPlayer();
		BlockState block = event.getClickedBlock().getState();
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			if(block instanceof Skull){
				Skull skull = (Skull) block;
				if(skull.getSkullType().equals(SkullType.PLAYER)){
					String headOwner = skull.getOwner();
					if(!HeadUtils.playerExists(plugin.getCollection(), headOwner)){
						player.sendMessage(ChatColor.GOLD+headOwner+ChatColor.YELLOW+" says nothing...");
						return;
					}
					String message = HeadUtils.getMessage(plugin.getCollection(), headOwner);
					if(message == null || message == ""){
						player.sendMessage(ChatColor.GOLD+headOwner+ChatColor.YELLOW+" says nothing...");
						return;
					}
					player.sendMessage(ChatColor.GOLD + headOwner + ChatColor.GREEN + " says:");
					player.sendMessage(ChatColor.AQUA + message);
				}
			}
		}
	}
	
}
