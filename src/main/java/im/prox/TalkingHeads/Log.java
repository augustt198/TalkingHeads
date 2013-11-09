package im.prox.TalkingHeads;

import java.util.logging.Level;
import org.bukkit.Bukkit;

public class Log {
	public static void info(String info) {
        Bukkit.getLogger().log(Level.INFO, "[TalkingHeads] " + info);
	}

	public static void warn(String warn) {
        Bukkit.getLogger().log(Level.WARNING, "[TalkingHeads] " + warn);
	}

	public static void severe(String severe) {
        Bukkit.getLogger().log(Level.SEVERE, "[TalkingHeads] " + severe);
	}
}
