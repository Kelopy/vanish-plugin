package me.kelopy.gone.commands;

import me.kelopy.gone.Gone;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class vanishList implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            p.sendMessage(Gone.getInstance().invisible_list.toString());
        }else if(sender instanceof ConsoleCommandSender){
            System.out.println(Gone.getInstance().invisible_list.toString());
        }else{
            System.out.println("This command can only be executed via a player or console.");
        }

        return true;
    }
}
