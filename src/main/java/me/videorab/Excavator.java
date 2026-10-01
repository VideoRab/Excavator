package me.videorab;

import me.videorab.listeners.PlayerBlockBreakBeforeListener;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Excavator implements ModInitializer {
	public static final String MOD_ID = "excavator";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		PlayerBlockBreakEvents.BEFORE.register(new PlayerBlockBreakBeforeListener());

		LOGGER.info("Mod initialized!");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
