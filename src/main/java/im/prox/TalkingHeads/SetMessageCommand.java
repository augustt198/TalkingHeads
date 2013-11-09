package im.prox.TalkingHeads;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetMessageCommand implements CommandExecutor{

	final HeadPlugin plugin;
	
	public SetMessageCommand(HeadPlugin plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
			return false;
		}
		if(args.length < 1){
			sender.sendMessage(ChatColor.RED + "Too few arguments!");
			Usage(sender);
			return false;
		}
		String username = sender.getName();
		String message = StringUtils.join(args, " ", 0, args.length);
		HeadUtils.setMessage(plugin, username, message);
		sender.sendMessage(ChatColor.GREEN + "Message set!");
		return false;
	}
	
	public void Usage(CommandSender sender){
		sender.sendMessage(ChatColor.AQUA+"Usage: "+ChatColor.GOLD+"/setmessage "+ChatColor.GREEN+"[message]");
	}
	
}
