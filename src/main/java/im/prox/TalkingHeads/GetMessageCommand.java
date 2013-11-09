package im.prox.TalkingHeads;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GetMessageCommand implements CommandExecutor{

final HeadPlugin plugin;
	
	public GetMessageCommand(HeadPlugin plugin){
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(args.length > 1){
			sender.sendMessage(ChatColor.RED + "Too many arguments!");
			Usage(sender);
			return false;
		}
		if(args.length < 1){
			sender.sendMessage(ChatColor.RED + "Too few arguments!");
			Usage(sender);
			return false;
		}
		
		String username = args[0];
		if(!HeadUtils.playerExists(plugin, username)){
			sender.sendMessage(ChatColor.GOLD+username+ChatColor.YELLOW+" says nothing...");
			return false;
		}
		String message = HeadUtils.getMessage(plugin, username);
		if(message == null || message == ""){
			sender.sendMessage(ChatColor.GOLD+username+ChatColor.YELLOW+" says nothing...");
			return false;
		}
		sender.sendMessage(ChatColor.GOLD + username + ChatColor.GREEN + " says:");
		sender.sendMessage(ChatColor.AQUA + message);
		
		return false;
	}
	
	public void Usage(CommandSender sender){
		sender.sendMessage(ChatColor.AQUA+"Usage: "+ChatColor.GOLD+"/getmessage "+ChatColor.GREEN+"[player]");
	}
	
}
