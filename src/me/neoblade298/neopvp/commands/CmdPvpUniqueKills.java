package me.neoblade298.neopvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neoblade298.neocore.shared.commands.Arg;
import me.neoblade298.neocore.bukkit.commands.Subcommand;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;
import me.neoblade298.neopvp.PvpManager;

public class CmdPvpUniqueKills extends Subcommand {
	public CmdPvpUniqueKills(String key, String desc, String perm, SubcommandRunner runner) {
		super(key, desc, perm, runner);
		args.add(new Arg("player", false),new Arg("page", false));
	}

	@Override
	public void run(CommandSender s, String[] args) {
		if (args.length == 0) {
			PvpManager.getAccount((Player) s).displayUniqueKills(s, 0);
		}
		else {
			Player p = null;
			int offset = 0;
			if (Bukkit.getPlayer(args[0]) != null) {
				p = Bukkit.getPlayer(args[0]);
				offset = 1;
			}
			else {
				p = (Player) s;
			}
			
			// If there's still an arg to use
			int page = 0;
			if (args.length > offset) {
				page = Integer.parseInt(args[offset]);
			}
			PvpManager.getAccount(p).displayUniqueKills(s, page);
		}
	}
}
