package tw.momocraft.fsp.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import tw.momocraft.fsp.utils.Common;

public class FirstSpigotCommand extends PlayerCommand{

	public FirstSpigotCommand() {
		super("firstspigotcommand");

		setAliases(Arrays.asList("fsc", "fsp"));
		setDescription("a example command");

	}

	@Override
	protected void run(Player player, String[] args) {
		if(!player.hasPermission("your.cool.permission")) {
			Common.tell(player, "&cYou lack the proper permission, sorry paw :(");

			return;
		}

		if (args.length != 1) {
			Common.tell(player, "&ePlease type your coolname after the command!");

			return;
		}

		final String name = args[0];
		final Material mat = Material.getMaterial(name);

		if(mat == null) {
			Common.tell(player, "&cThe Material " + name + " does not exist.");

			return;
		}

		player.getInventory().addItem(new ItemStack(mat, 1));
		Common.tell(player, "&6You have been given 1 piece of " + name);
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if(sender.hasPermission("your.cool.permission") && args.length == 1) {
			final String arg = args[0];
			final List<String> tab = new ArrayList<>();

			for (final Material m : Material.values()) {
				if(m.toString().startsWith(arg.toUpperCase())) {
					tab.add(m.toString());
				}
			}
			return tab;
		}

		return super.tabComplete(sender, alias, args);
	}



}
