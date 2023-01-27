package me.neoblade298.neopvp.commands;

import org.bukkit.command.CommandSender;

import me.neoblade298.neocore.bukkit.commands.Subcommand;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;
import me.neoblade298.neopvp.wars.WarManager;

public class CmdAWarLimit extends Subcommand {
	public CmdAWarLimit(String key, String desc, String perm, SubcommandRunner runner) {
		super(key, desc, perm, runner);
	}

	@Override
	public void run(CommandSender s, String[] args) {
		WarManager.getWarCreator(s).setMaxPlayers(Integer.parseInt(args[0]));
		WarManager.displayWarCreation(s);
	}
}
