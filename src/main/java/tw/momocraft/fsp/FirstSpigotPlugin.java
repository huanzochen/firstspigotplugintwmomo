package tw.momocraft.fsp;

import org.bukkit.plugin.java.JavaPlugin;

import tw.momocraft.fsp.commands.FirstSpigotCommand;
import tw.momocraft.fsp.commands.SetOpCommand;
import tw.momocraft.fsp.events.PlayerListener;
import tw.momocraft.fsp.task.BroadcastTask;
import tw.momocraft.fsp.utils.Common;

/**
 * Hello world!
 *
 */
public class FirstSpigotPlugin extends JavaPlugin {

	private static FirstSpigotPlugin instance;

	/*private BukkitRunnable task;*/

	@Override
	public void onEnable() {
		instance = this;

		Common.registerCommand(new FirstSpigotCommand());
		Common.registerCommand(new SetOpCommand());

		getServer().getPluginManager().registerEvents(new PlayerListener(), this);

		/*task = new BroadcastTask();
		task.runTaskTimer(this, 20, 2*20);*/

		new BroadcastTask().runTaskTimerAsynchronously(this, 20, 2*20);
	}

	@Override
	public void onDisable() {
		instance = null;

		/*		task.cancel();*/
		getServer().getScheduler().cancelTasks(this);

	}


	public static FirstSpigotPlugin getInstance() {
		return instance;
	}

}
