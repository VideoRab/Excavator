package me.videorab.client.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.player.LocalPlayer;

public interface PlayerOnSneakStartEvent {
    Event<PlayerOnSneakStartEvent> EVENT = EventFactory.createArrayBacked(PlayerOnSneakStartEvent.class,
            (listeners) -> (player) -> {
                for (PlayerOnSneakStartEvent listener : listeners) {
                    listener.onSneakStart(player);
                }
            });

    void onSneakStart(LocalPlayer player);
}