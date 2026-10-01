package me.videorab.client;

import me.videorab.client.blocks.ModBlocks;
import me.videorab.client.entities.renderers.ModEntityRenderers;
import me.videorab.client.events.PlayerOnSneakStartEvent;
import me.videorab.client.listeners.PlayerOnSneakStartListener;
import net.fabricmc.api.ClientModInitializer;

public class ExcavatorClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModBlocks.initialize();
		ModEntityRenderers.initialize();

		PlayerOnSneakStartEvent.EVENT.register(new PlayerOnSneakStartListener());
	}
}