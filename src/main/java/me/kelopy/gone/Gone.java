package me.kelopy.gone;

import me.kelopy.gone.commands.vanish;
import me.kelopy.gone.commands.vanishList;
import me.kelopy.gone.events.vanishEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Gone extends JavaPlugin {

    public ArrayList<Player> invisible_list = new ArrayList<>();

    private static Gone instance;

    @Override
    public void onEnable() {
        System.out.println("Gone has been activated.");

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        instance = this;

        getCommand("vanish").setExecutor(new vanish());
        getCommand("vanishlist").setExecutor(new vanishList());
        getServer().getPluginManager().registerEvents(new vanishEvent(), this);
    }

    public static Gone getInstance(){
        return instance;
    }

}
