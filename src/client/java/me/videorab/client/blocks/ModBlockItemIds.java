package me.videorab.client.blocks;

import me.videorab.Excavator;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

public class ModBlockItemIds {
    public static final BlockItemId TRANSPARENT_BLOCK = create("transparent_block");

    private static BlockItemId create(String name) {
        Identifier id = Excavator.id(name);
        return BlockItemId.create(id, id);
    }
}
