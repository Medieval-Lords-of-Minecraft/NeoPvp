package me.neoblade298.neopvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neoblade298.neocore.shared.commands.Arg;
import me.neoblade298.neocore.bukkit.commands.Subcommand;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;
import me.neoblade298.neocore.bukkit.util.Util;
import me.neoblade298.neopvp.PvpAccount;
import me.neoblade298.neopvp.PvpManager;

public class CmdPvpBase extends Subcommand {
	public CmdPvpBase(String key, String desc, String perm, SubcommandRunner runner) {
		super(key, desc, perm, runner);
		args.add(new Arg("player"));
	}

	@Override
	public void run(CommandSender s, String[] args) {
		if (args.length == 0) {
			PvpManager.getAccount((Player) s).displayAccount(s);
		}
		else {
			PvpAccount acct = PvpManager.getAccount(Bukkit.getPlayer(args[0]));
			if (acct != null) {
				acct.displayAccount(s);
			}
			else {
				Util.msg(s, "&cCould not find player! Maybe they're not online?");
			}
		}
	}
}
