package me.kelopy.gone.events;

import me.kelopy.gone.Gone;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class vanishEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        for (int i = 0; i < Gone.getInstance().invisible_list.size(); i++){
            player.hidePlayer(Gone.getInstance(), Gone.getInstance().invisible_list.get(i));
        }
    }

}
