package me.neoblade298.neopvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import me.neoblade298.neocore.shared.commands.Arg;
import me.neoblade298.neocore.bukkit.commands.Subcommand;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;
import me.neoblade298.neocore.bukkit.util.Util;
import me.neoblade298.neopvp.PvpAccount;
import me.neoblade298.neopvp.PvpManager;

public class CmdAPvpSet extends Subcommand {
	public CmdAPvpSet(String key, String desc, String perm, SubcommandRunner runner) {
		super(key, desc, perm, runner);
		args.add(new Arg("player"), new Arg("wins/losses/bounty/elo"), new Arg("amount"));
	}

	@Override
	public void run(CommandSender s, String[] args) {
		PvpAccount acct = PvpManager.getAccount(Bukkit.getPlayer(args[0]));
		int amt = Integer.parseInt(args[2]);
		switch (args[1]) {
		case "wins":
			acct.setWins(amt);
			Util.msg(s, "&7Successfully changed player's wins!");
			break;
		case "losses":
			acct.setLosses(amt);
			Util.msg(s, "&7Successfully changed player's losses!");
			break;
		case "bounty":
			acct.setPvpBalance(amt);
			Util.msg(s, "&7Successfully changed player's bounty!");
			break;
		case "elo":
			acct.setElo(amt);
			Util.msg(s, "&7Successfully changed player's elo!");
			break;
		default:
			Util.msg(s, "&cInvalid field to change!");
			break;
		}
	}
}
