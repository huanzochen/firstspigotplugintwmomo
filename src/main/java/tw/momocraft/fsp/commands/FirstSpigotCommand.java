package tw.momocraft.fsp.commands;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import tw.momocraft.fsp.utils.Common;

public class FirstSpigotCommand extends Command{

	public FirstSpigotCommand() {
		super("firstspigotcommand");

		setAliases(Arrays.asList("fsc", "fsp"));
		setDescription("a example command");


		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {

		if(!(sender instanceof Player)) {
			Common.tell(sender, "&e你必須是個玩家!");

			return false;
		}

		if(!sender.hasPermission("your.cool.permission")) {
			Common.tell(sender, "&cYou lack the proper permission, sorry paw :(");

			return false;
		}

		if (args.length != 1) {
			Common.tell(sender, "&ePlease type your coolname after the command!");

			return false;
		}

		final String name = args[0];

		Common.tell(sender, "Your cool name is" + name);

		final Player player = (Player) sender;
		player.getInventory().addItem(new ItemStack(Material.DIAMOND, 2));

		return true;



	}

}
