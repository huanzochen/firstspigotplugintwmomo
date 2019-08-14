package tw.momocraft.fsp.utils;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class Common {

	public static void tell (CommandSender toWhom, String message) {
		toWhom.sendMessage(colorize(message));
	}

	private static String colorize (String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public static void registerCommand(Command command) {
		try {
			final Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
			commandMapField.setAccessible(true);

			final CommandMap commandMap = (CommandMap) commandMapField.get(Bukkit.getServer());
			commandMap.register(command.getLabel(), command);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
