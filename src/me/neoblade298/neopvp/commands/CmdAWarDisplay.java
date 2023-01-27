package me.neoblade298.neopvp.commands;

import org.bukkit.command.CommandSender;

import me.neoblade298.neocore.bukkit.commands.Subcommand;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;
import me.neoblade298.neopvp.wars.WarManager;

public class CmdAWarDisplay extends Subcommand {

	public CmdAWarDisplay(String key, String desc, String perm, SubcommandRunner runner) {
		super(key, desc, perm, runner);
		args.setOverride("[display]");
	}

	@Override
	public void run(CommandSender s, String[] args) {
		String display = args[0];
		for (int i = 1; i < args.length; i++) {
			display += " " + args[i];
		}
		WarManager.getWarCreator(s).setDisplay(display);
		WarManager.displayWarCreation(s);
	}
}
