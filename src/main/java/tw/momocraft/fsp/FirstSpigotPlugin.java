package tw.momocraft.fsp;

import org.bukkit.plugin.java.JavaPlugin;

import tw.momocraft.fsp.commands.FirstSpigotCommand;
import tw.momocraft.fsp.commands.SetOpCommand;
import tw.momocraft.fsp.events.PlayerListener;
import tw.momocraft.fsp.utils.Common;

/**
 * Hello world!
 *
 */
public class FirstSpigotPlugin extends JavaPlugin {

	private static FirstSpigotPlugin instance;

	@Override
	public void onEnable() {
		Common.registerCommand(new FirstSpigotCommand());
		Common.registerCommand(new SetOpCommand());

		getServer().getPluginManager().registerEvents(new PlayerListener(), this);
	}

}
