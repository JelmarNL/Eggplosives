package me.JelmarNL.Eggplosives;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public PluginManager pm = Bukkit.getPluginManager();
	public FileConfiguration config = getConfig();
	
	@Override
	public void onEnable() {
		pm.registerEvents(this, this);
		config.addDefault("eggplosion-size", 3);
		config.addDefault("fire-eggplosion", true);
		config.options().copyDefaults(true);
		saveConfig();
		getLogger().info("Eggplosives has been enabled ENJOY OR DESTROY!");
	}
	
	
	
	@Override
	public void onDisable() {
		getLogger().info("Eggplosives has been disabled!");
	}
	
	
	
	@EventHandler
	public void onInteract(PlayerEggThrowEvent event) {
		event.setHatching(false);
		event.getEgg().getLocation().getWorld().createExplosion(event.getEgg().getLocation(), config.getLong("eggplosion-size"), config.getBoolean("fire-eggplosion"));
	}
	
	
	
}
