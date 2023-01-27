package me.neoblade298.neopvp;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;

import me.neoblade298.neocore.bukkit.NeoCore;
import me.neoblade298.neocore.bukkit.commands.SubcommandManager;
import me.neoblade298.neocore.shared.commands.SubcommandRunner;
import me.neoblade298.neocore.bukkit.InstanceType;
import me.neoblade298.neocore.bukkit.Manager;
import me.neoblade298.neopvp.commands.*;
import me.neoblade298.neopvp.generators.GeneratorManager;
import me.neoblade298.neopvp.listeners.PvpListener;
import net.md_5.bungee.api.ChatColor;

public class NeoPvp extends JavaPlugin {
	private static NeoPvp inst;
	private static ArrayList<Manager> mngrs = new ArrayList<Manager>();
	public static StateFlag PROTECTION_ALLOWED_FLAG;
	public static final int PVP_PROTECTION_COST = 50000;
	
	public void onEnable() {
		Bukkit.getServer().getLogger().info("NeoPvp Enabled");
		inst = this;
		if (NeoCore.getInstanceType() == InstanceType.TOWNY) {
			mngrs.add(new GeneratorManager());
		}
		initCommands();
		
		NeoCore.registerIOComponent(this, new PvpManager(), "PvpManager");
		Bukkit.getPluginManager().registerEvents(new PvpListener(), this);
	}
	
	private void initCommands() {
		SubcommandManager mngr = new SubcommandManager("adminwar", "mycommand.staff", ChatColor.DARK_RED, this);
		mngr.registerCommandList("");
		mngr.register(new CmdAWarCreate("create", "Completes war creation and schedules it", null, SubcommandRunner.BOTH));
		mngr.register(new CmdAWarClear("clear", "Removes all wars from existence", null, SubcommandRunner.BOTH));
		mngr.register(new CmdAWarDisplay("display", "Sets display name of war", null, SubcommandRunner.BOTH));
		mngr.register(new CmdAWarInfo("info", "Shows war creator", null, SubcommandRunner.BOTH));
		mngr.register(new CmdAWarLimit("limit", "Sets max players in a team", null, SubcommandRunner.BOTH));
		mngr.register(new CmdAWarNew("new", "Starts creation of a war", null, SubcommandRunner.BOTH));
		mngr.register(new CmdAWarTeam1("team1", null, null, SubcommandRunner.BOTH));
		mngr.register(new CmdAWarTeam2("team2", null, null, SubcommandRunner.BOTH));
		mngr.register(new CmdAWarSetWorld("setworld", "Sets world of war", null, SubcommandRunner.BOTH));
		mngr.register(new CmdAWarStart("start", "Starts war", null, SubcommandRunner.BOTH));
		mngr.register(new CmdAWarEnd("end", "Ends War", null, SubcommandRunner.BOTH));
		mngr.register(new CmdAWarExit("exit", "Exits war creation", null, SubcommandRunner.BOTH));
		
		mngr = new SubcommandManager("pvp", null, ChatColor.RED, this);
		mngr.registerCommandList("help");
		mngr.register(new CmdPvpBase("", "Views player's pvp stats", null, SubcommandRunner.BOTH));
		mngr.register(new CmdPvpBuyProtection("buyprotection", "Purchases 30 minutes of protection for " + PVP_PROTECTION_COST + "g", null, SubcommandRunner.PLAYER_ONLY));
		mngr.register(new CmdPvpRemoveProtection("removeprotection", "Removes your protection", null, SubcommandRunner.PLAYER_ONLY));
		mngr.register(new CmdPvpRedeem("redeem", "Redeems your current bounty and resets it", null, SubcommandRunner.PLAYER_ONLY));
		mngr.register(new CmdPvpUniqueKills("uniquekills", "Lists unique kills", null, SubcommandRunner.BOTH));
		
		mngr = new SubcommandManager("adminpvp", "mycommand.staff", ChatColor.DARK_RED, this);
		mngr.registerCommandList("");
		mngr.register(new CmdAPvpAddProtection("addprotection", "Adds protection time to a player", null, SubcommandRunner.BOTH));
		mngr.register(new CmdAPvpRemoveProtection("removeprotection", "Removes protection time from a player", null, SubcommandRunner.BOTH));
		mngr.register(new CmdAPvpReload("reload", "Reloads plugin", null, SubcommandRunner.BOTH));
		mngr.register(new CmdAPvpSet("set", "Sets a field in the player's pvp account", null, SubcommandRunner.BOTH));
		
		mngr = new SubcommandManager("war", null, ChatColor.RED, this);
		mngr.registerCommandList("help");
		mngr.register(new CmdWarBase("", "Views current war status", null, SubcommandRunner.BOTH));
		mngr.register(new CmdWarSpawn("spawn", "Teleport to current war if you're in one", null, SubcommandRunner.BOTH));
	}
	
	@Override
	public void onLoad() {
		// WorldGuard
		FlagRegistry registry = WorldGuard.getInstance().getFlagRegistry();
	    try {
	        // create a flag with the name "my-custom-flag"
	        StateFlag flag = new StateFlag("protection-allowed", false);
	        registry.register(flag);
	        PROTECTION_ALLOWED_FLAG = flag; // only set our field if there was no error
	    } catch (FlagConflictException e) {
	        // some other plugin registered a flag by the same name already.
	        // you can use the existing flag, but this may cause conflicts - be sure to check type
	    	e.printStackTrace();
	    	
	    } catch (IllegalStateException e) {
	    	e.printStackTrace();
	    }
	}
	
	public void onDisable() {
	    org.bukkit.Bukkit.getServer().getLogger().info("NeoPvp Disabled");
	    super.onDisable();
	}
	
	public static NeoPvp inst() {
		return inst;
	}
	
	public static void reload() {
		for (Manager mngr : mngrs) {
			mngr.reload();
		}
	}
}
