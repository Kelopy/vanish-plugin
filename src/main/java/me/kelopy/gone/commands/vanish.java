package me.kelopy.gone.commands;

import me.kelopy.gone.Gone;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class vanish implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){

            if(args.length == 0){
                vanishMethod_args0(p);
            }else if(args.length == 1){
                if (p.hasPermission("gone.others")){
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null){
                        vanishMethod_args1(p, target);
                    }else{
                        p.sendMessage(ChatColor.RED + "Player not found.");
                    }
                }else{
                    p.sendMessage("§cYou don't have permission to execute this command.");
                }
            }

        }else{
            System.out.println("This command can only be executed by a player.");
        }

        return true;
    }

    private void vanishMethod_args0(Player p){

        if(Gone.getInstance().invisible_list.contains(p)){
            for (Player people : Bukkit.getOnlinePlayers()) {
                people.showPlayer(Gone.getInstance(), p);
            }
            Gone.getInstance().invisible_list.remove(p);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Gone.getInstance().getConfig().getString("vanish-off")));
        }else if(!Gone.getInstance().invisible_list.contains(p)) {
            for (Player people : Bukkit.getOnlinePlayers()) {
                people.hidePlayer(Gone.getInstance(), p);
            }
            Gone.getInstance().invisible_list.add(p);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', Gone.getInstance().getConfig().getString("vanish-on")));
        }

    }

    private void vanishMethod_args1(Player p, Player target){

        if(Gone.getInstance().invisible_list.contains(p)){
            for (Player people : Bukkit.getOnlinePlayers()) {
                people.showPlayer(Gone.getInstance(), p);
            }
            Gone.getInstance().invisible_list.remove(p);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b" + p.getName() + " &7is now &bvisible&7."));
            target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b" + p.getName() + " &7showed you, you're now &bvisible&7."));
        }else if(!Gone.getInstance().invisible_list.contains(p)) {
            for (Player people : Bukkit.getOnlinePlayers()) {
                people.hidePlayer(Gone.getInstance(), p);
            }
            Gone.getInstance().invisible_list.add(p);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b" + p.getName() + " &7is now &binvisible&7."));
            target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&b" + p.getName() + " &7hid you, you're now &binvisible&7."));
        }

    }

}
