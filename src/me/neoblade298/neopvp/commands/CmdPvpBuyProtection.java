package me.neoblade298.neopvp.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neoblade298.neocore.bukkit.NeoCore;

import me.neoblade298.neocore.bukkit.commands.Subcommand;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;
import me.neoblade298.neopvp.NeoPvp;
import me.neoblade298.neopvp.PvpManager;

public class CmdPvpBuyProtection extends Subcommand {
	public CmdPvpBuyProtection(String key, String desc, String perm, SubcommandRunner runner) {
		super(key, desc, perm, runner);
	}

	private static final int PRICE = NeoPvp.PVP_PROTECTION_COST;
	private static final int MINUTES = 30;

	@Override
	public void run(CommandSender s, String[] args) {
		Player p = (Player) s;
		NeoCore.getEconomy().withdrawPlayer(p, PRICE);
		PvpManager.getAccount(p).addProtection(1000 * 60 * MINUTES);
	}
}
