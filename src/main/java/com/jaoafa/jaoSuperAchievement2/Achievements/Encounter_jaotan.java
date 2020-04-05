package com.jaoafa.jaoSuperAchievement2.Achievements;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.jaoafa.jaoSuperAchievement2.API.AchievementAPI;
import com.jaoafa.jaoSuperAchievement2.API.Achievementjao;
import com.jaoafa.jaoSuperAchievement2.Lib.AchievementType;

/**
 * No. 7
 *
 * 神との遭遇
 * jaotanに遭遇する
 * tpコマンドでjaotanに飛ぼうとした場合
 * ※隠し要素
 *
 * @since 2020/04/05
 * @category jao Achievement
 *
 */
public class Encounter_jaotan implements Listener {
	JavaPlugin plugin;

	public Encounter_jaotan(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		String command = event.getMessage();
		String[] args = command.split(" ", 0);
		if (args.length >= 2) {
			if (args[0].equalsIgnoreCase("/tp") && args[1].equalsIgnoreCase("jaotan")) {
				if (!Achievementjao.getAchievement(player, new AchievementType(7))) {
					player.sendMessage(AchievementAPI.getPrefix() + "実績の解除中に問題が発生しました。もう一度お試しください。");
					return;
				}
			}
		}
	}
}