package nautilusmc.shriekerswarning;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.entity.Player;

public class ShriekersWarning extends JavaPlugin implements Listener {

    private final String MESSAGE = "&6&lInformations &f» &7Attention, les Sculk Shriekers font spawn des Wardens sur le serveur !";

    @Override
    public void onEnable() {
        // Enregistrement de l'événement de placement de bloc
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        // Vérification du type de bloc placé
        String BLOCK_TYPE = "SCULK_SHRIEKER";
        if (event.getBlock().getType().toString().equalsIgnoreCase(BLOCK_TYPE)) {
            Player player = event.getPlayer();
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', MESSAGE));
        }
    }

}