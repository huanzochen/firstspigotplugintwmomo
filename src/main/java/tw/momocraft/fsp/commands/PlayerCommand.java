package tw.momocraft.fsp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tw.momocraft.fsp.utils.Common;

public abstract class PlayerCommand extends Command {

	protected PlayerCommand(String name) {
		super(name);
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			Common.tell(sender, "&e你必須是個玩家!");

			return false;
		}

		run((Player) sender, args);
		return true;
	}

	protected abstract void run(Player player, String [] args);
}
