package com.jaoafa.jaoSuperAchievement2.Achievements;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import com.jaoafa.jaoSuperAchievement2.API.AchievementAPI;
import com.jaoafa.jaoSuperAchievement2.API.Achievementjao;
import com.jaoafa.jaoSuperAchievement2.Lib.AchievementType;

/**
 * No. 18
 *
 * 胞子まみれ
 * Hirotaisou2012のあたまを被る
 * Hirotaisou2012のあたまを被る
 *
 * @since 2020/04/05
 * @category jao Achievement
 *
 */
public class SporesCovered {
	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void OnSporesCovered(PlayerMoveEvent event) { // インベントリ系のイベントだといまいちなのであえて移動イベント
		if (event.getFrom().distance(event.getTo()) == 0)
			return;
		Player player = (Player) event.getPlayer();

		ItemStack helmet = player.getInventory().getHelmet();
		if (helmet == null)
			return;
		if (helmet.getType() != Material.SKULL_ITEM) {
			return;
		}
		SkullMeta skull = (SkullMeta) helmet.getItemMeta();
		OfflinePlayer offplayer = skull.getOwningPlayer();

		if (offplayer == null) {
			return;
		}

		if (!offplayer.getUniqueId().toString().equalsIgnoreCase("39cf878b-ef0b-44fc-a2c6-de3d540a4728")) {
			return;
		}

		if (!Achievementjao.getAchievement(player, new AchievementType(18))) {
			player.sendMessage(AchievementAPI.getPrefix() + "実績の解除中に問題が発生しました。もう一度お試しください。");
			return;
		}
	}
}