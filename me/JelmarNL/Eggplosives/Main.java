package me.JelmarNL.Eggplosives;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	PluginManager pm = Bukkit.getPluginManager();
	
	@Override
	public void onEnable() {
		pm.registerEvents(this, this);
	}
	
	
	
	@Override
	public void onDisable() {
		
	}
	
	
	
	@EventHandler
	public void onInteract(PlayerEggThrowEvent event) {
		event.setHatching(false);
		event.getEgg().getLocation().getWorld().createExplosion(event.getEgg().getLocation(), 3, false);
	}
	
	
	
}
