package me.videorab.helpers;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

public class OreDetector {
    public static boolean isOre(Block block) {
        return block.defaultBlockState().is(BlockTags.ORES);
    }
}
