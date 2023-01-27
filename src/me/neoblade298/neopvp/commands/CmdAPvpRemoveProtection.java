package me.neoblade298.neopvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import me.neoblade298.neocore.shared.commands.Arg;
import me.neoblade298.neocore.bukkit.commands.Subcommand;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;
import me.neoblade298.neopvp.PvpManager;

public class CmdAPvpRemoveProtection extends Subcommand {
	public CmdAPvpRemoveProtection(String key, String desc, String perm, SubcommandRunner runner) {
		super(key, desc, perm, runner);
		args.add(new Arg("player"), new Arg("time (seconds)"));
	}

	@Override
	public void run(CommandSender s, String[] args) {
		PvpManager.getAccount(Bukkit.getPlayer(args[0])).removeProtection();
	}
}
