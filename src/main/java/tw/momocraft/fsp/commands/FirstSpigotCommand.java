package tw.momocraft.fsp.commands;

import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class FirstSpigotCommand extends Command{

	public FirstSpigotCommand(String name) {
		super("firstspigotcommand");

		setAliases(Arrays.asList("fsc", "fsp"));
		setDescription("a example command");


		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		for (int i = 0; i < args.length; i++) {
			sender.sendMessage("Argument at index" + i + "is: " + args[i]);
		}
		return true;
	}

}
