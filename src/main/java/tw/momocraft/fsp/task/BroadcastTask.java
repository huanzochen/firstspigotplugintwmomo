package tw.momocraft.fsp.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import tw.momocraft.fsp.utils.Common;

public class BroadcastTask extends BukkitRunnable{

	private static Random rand = new Random();

	private final List<String> messages = new ArrayList<>();

	public BroadcastTask() {
		messages.add("安安你好,{player}");
		messages.add("這裡是茉茉伺服器");
		messages.add("儲值800即可成為VIP");
	}

	@Override
	public void run() {


		for(final Player player : Bukkit.getOnlinePlayers()) {
			String message = messages.get(rand.nextInt(messages.size()));

			message = message.replace("{player}", player.getName());
			message = "&8[&9Tip&8] &7" + message;

			Common.tell(player, message);
		}

	}


}
