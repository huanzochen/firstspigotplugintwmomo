package tw.momocraft.fsp.events;



import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.EquipmentSlot;

import tw.momocraft.fsp.utils.Common;

public class PlayerListener implements Listener {


	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJoin(PlayerJoinEvent e)  {
		final Player player = e.getPlayer();

		Common.tell(player, "&7歡迎加入伺服器,  &e" + player.getName());
	}

	@EventHandler(ignoreCancelled = true)
	public void onInteract(PlayerInteractEvent e) {
		if(!(e.getHand() == EquipmentSlot.HAND)) {
			return;
		}
		final Action a = e.getAction();
		if (a == Action.RIGHT_CLICK_BLOCK) {
			Common.tell(e.getPlayer(),"&lHey you!" + " &f你剛剛碰觸了一個方塊叫做 " ,
					"&7下一行 &f" + e.getClickedBlock().getType());

		}
	}

	/*
	new BukkitRunnable() {

		@Override
		public void run() {

		}
	}.runTaskLater(FirstSpigotPlugin.getInstance(), 1);
	 */

}
