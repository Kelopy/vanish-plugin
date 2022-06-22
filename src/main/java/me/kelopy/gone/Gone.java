package me.kelopy.gone;

import me.kelopy.gone.commands.vanish;
import me.kelopy.gone.events.vanishEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Gone extends JavaPlugin {

    public ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public void onEnable() {
        System.out.println("Gone has been activated.");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("vanish").setExecutor(new vanish(this));
        getServer().getPluginManager().registerEvents(new vanishEvent(this), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Gone has been activated.");
    }
}
