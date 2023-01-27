package me.neoblade298.neopvp.commands;

import org.bukkit.command.CommandSender;


import me.neoblade298.neocore.bukkit.commands.Subcommand;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;
import me.neoblade298.neocore.bukkit.util.Util;
import me.neoblade298.neopvp.wars.War;
import me.neoblade298.neopvp.wars.WarManager;

public class CmdWarBase extends Subcommand {
	public CmdWarBase(String key, String desc, String perm, SubcommandRunner runner) {
		super(key, desc, perm, runner);
	}

	@Override
	public void run(CommandSender s, String[] args) {
		if (WarManager.getOngoingWars().size() > 0) {
			Util.msg(s, "&7Ongoing Wars:", false);
			for (War war : WarManager.getOngoingWars().values()) {
				war.display(s);
			}
		}
		else {
			Util.msg(s, "&7There are currently no ongoing wars.", false);
		}

		if (WarManager.getWars().size() > 0) {
			Util.msg(s, "&7Scheduled Wars:", false);
			for (War war : WarManager.getWars().values()) {
				war.displayCreator(s);
			}
		}
		else {
			Util.msg(s, "&7There are currently no scheduled wars.", false);
		}
	}
}
