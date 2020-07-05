package com.jaoafa.jaoSuperAchievement2.Task;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

public class Task_OpenInventory extends BukkitRunnable {
	Player player;
	Inventory inv;

	public Task_OpenInventory(Player player, Inventory inv) {
		this.player = player;
		this.inv = inv;
	}

	@Override
	public void run() {
		player.openInventory(inv);
	}
}
