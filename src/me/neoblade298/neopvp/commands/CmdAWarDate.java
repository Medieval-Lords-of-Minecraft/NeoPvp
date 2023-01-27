package me.neoblade298.neopvp.commands;

import org.bukkit.command.CommandSender;

import me.neoblade298.neocore.shared.commands.Arg;
import me.neoblade298.neocore.bukkit.commands.Subcommand;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;
import me.neoblade298.neopvp.wars.WarManager;

public class CmdAWarDate extends Subcommand {
	public CmdAWarDate(String key, String desc, String perm, SubcommandRunner runner) {
		super(key, desc, perm, runner);
		args.add(new Arg("mm/dd/yyyy"), new Arg("hour", false));
	}

	@Override
	public void run(CommandSender s, String[] args) {
		if (args.length == 1) {
			WarManager.getWarCreator(s).setDate(args[0]);
		}
		else {
			WarManager.getWarCreator(s).setDate(args[0], Integer.parseInt(args[1]));
		}
		WarManager.displayWarCreation(s);
	}
}
