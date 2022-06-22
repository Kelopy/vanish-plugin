package me.kelopy.gone.commands;

import me.kelopy.gone.Gone;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class vanish implements CommandExecutor {

    Gone plugin;

    public vanish(Gone plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){

            if(plugin.invisible_list.contains(p)){
                for (Player people : Bukkit.getOnlinePlayers()){
                    people.showPlayer(plugin, p);
                }
                plugin.invisible_list.remove(p);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("vanish-off")));
            }else if(!plugin.invisible_list.contains(p)){
                for (Player people : Bukkit.getOnlinePlayers()){
                    people.hidePlayer(plugin, p);
                }
                plugin.invisible_list.add(p);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("vanish-on")));
            }

        }else{
            System.out.println("This command can only be executed by a player.");
        }

        return true;
    }
}
