package me.neoblade298.neopvp.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import me.neoblade298.neocore.bukkit.commands.Subcommand;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;
import me.neoblade298.neocore.bukkit.teleport.TeleportAPI;
import me.neoblade298.neocore.bukkit.util.Util;
import me.neoblade298.neopvp.wars.War;
import me.neoblade298.neopvp.wars.WarManager;
import me.neoblade298.neopvp.wars.WarTeam;

public class CmdWarSpawn extends Subcommand {
	public CmdWarSpawn(String key, String desc, String perm, SubcommandRunner runner) {
		super(key, desc, perm, runner);
	}

	@Override
	public void run(CommandSender s, String[] args) {
		Player p = (Player) s;
		if (WarManager.getOngoingWars().size() > 0) {
			for (War war : WarManager.getOngoingWars().values()) {
				WarTeam t1 = war.getTeams()[0];
				WarTeam t2 = war.getTeams()[1];
				if (t1.isMember(p)) {
					TeleportAPI.teleportPlayer(p, t1.getSpawn());
					return;
				}
				else if (t2.isMember(p)) {
					TeleportAPI.teleportPlayer(p, t2.getSpawn());
					return;
				}
			}
		}
		Util.msg(s, "&cYou're not part of any ongoing war!");
	}
}
