package me.videorab.client.entities;

import me.videorab.Excavator;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

public class ModEntityTypeIds {
    public static final ResourceKey<EntityType<?>> GLOWING_TRANSPARENT_BLOCK_DISPLAY = create("glowing_transparent_block_display");

    private static ResourceKey<EntityType<?>> create(final String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, Excavator.id(name));
    }
}
