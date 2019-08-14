package tw.momocraft.fsp;

import org.bukkit.plugin.java.JavaPlugin;

import tw.momocraft.fsp.commands.FirstSpigotCommand;
import tw.momocraft.fsp.utils.Common;

/**
 * Hello world!
 *
 */
public class FirstSpigotPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		Common.registerCommand(new FirstSpigotCommand());
	}

}
