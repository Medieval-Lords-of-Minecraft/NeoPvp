package me.neoblade298.neopvp.commands;

import org.bukkit.command.CommandSender;

import me.neoblade298.neocore.shared.commands.Arg;
import me.neoblade298.neocore.bukkit.commands.Subcommand;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;
import me.neoblade298.neopvp.wars.WarManager;

public class CmdAWarEnd extends Subcommand {
	public CmdAWarEnd(String key, String desc, String perm, SubcommandRunner runner) {
		super(key, desc, perm, runner);
		args.add(new Arg("key"));
	}

	@Override
	public void run(CommandSender s, String[] args) {
		WarManager.endWar(args[0]);
	}
}
