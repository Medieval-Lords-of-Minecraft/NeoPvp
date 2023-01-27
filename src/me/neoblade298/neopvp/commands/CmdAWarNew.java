package me.neoblade298.neopvp.commands;

import org.bukkit.command.CommandSender;

import me.neoblade298.neocore.bukkit.commands.Subcommand;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;
import me.neoblade298.neocore.shared.util.SharedUtil;
import me.neoblade298.neopvp.wars.War;
import me.neoblade298.neopvp.wars.WarManager;

public class CmdAWarNew extends Subcommand {

	public CmdAWarNew(String key, String desc, String perm, SubcommandRunner runner) {
		super(key, desc, perm, runner);
		args.setOverride("[key] [display]");
		args.setMin(2);
	}

	@Override
	public void run(CommandSender s, String[] args) {
		WarManager.newWar(s, new War(args[0], SharedUtil.translateColors(SharedUtil.connectArgs(args, 1))));
		WarManager.displayWarCreation(s);
	}
}
