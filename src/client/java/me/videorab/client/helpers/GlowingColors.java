package me.videorab.client.helpers;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Hashtable;

public class GlowingColors {
    protected static Hashtable<Block, Integer> s_Colors = new Hashtable<>(){{
        put(Blocks.COAL_ORE, 0x2d2d2d);
        put(Blocks.DEEPSLATE_COAL_ORE, 0x2d2d2d);
        put(Blocks.COPPER_ORE, 0x9b5136);
        put(Blocks.DEEPSLATE_COPPER_ORE, 0x9b5136);
        put(Blocks.LAPIS_ORE, 0x456eda);
        put(Blocks.DEEPSLATE_LAPIS_ORE, 0x456eda);
        put(Blocks.IRON_ORE, 0xad8c76);
        put(Blocks.DEEPSLATE_IRON_ORE, 0xad8c76);
        put(Blocks.GOLD_ORE, 0xf5e547);
        put(Blocks.DEEPSLATE_GOLD_ORE, 0xf5e547);
        put(Blocks.REDSTONE_ORE, 0xeb0707);
        put(Blocks.DEEPSLATE_REDSTONE_ORE, 0xeb0707);
        put(Blocks.DIAMOND_ORE, 0x1bcad0);
        put(Blocks.DEEPSLATE_DIAMOND_ORE, 0x1bcad0);
        put(Blocks.EMERALD_ORE, 0x12c240);
        put(Blocks.DEEPSLATE_EMERALD_ORE, 0x12c240);
        put(Blocks.NETHER_QUARTZ_ORE, 0xcec4b4);
        put(Blocks.NETHER_GOLD_ORE, 0xf1a529);
    }};

    public static int getGlowingColor(Block block) {
        return s_Colors.getOrDefault(block, 0xffffff);
    }
}
