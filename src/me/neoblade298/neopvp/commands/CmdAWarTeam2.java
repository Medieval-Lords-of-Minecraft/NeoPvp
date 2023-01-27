package me.neoblade298.neopvp.commands;

import org.bukkit.command.CommandSender;
import me.neoblade298.neocore.bukkit.commands.Subcommand;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;

public class CmdAWarTeam2 extends Subcommand {

	public CmdAWarTeam2(String key, String desc, String perm, SubcommandRunner runner) {
		super(key, desc, perm, runner);
		args.setOverride(CmdAWarTeam1.argOverride);
	}

	@Override
	public void run(CommandSender s, String[] args) {
		CmdAWarTeam1.runCommand(s, args, 2);
	}
}
