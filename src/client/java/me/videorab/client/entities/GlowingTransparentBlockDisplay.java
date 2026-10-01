package me.videorab.client.entities;

import me.videorab.client.blocks.ModBlocks;
import me.videorab.client.helpers.EntityIdGenerator;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class GlowingTransparentBlockDisplay extends Display.BlockDisplay {
    protected final int c_Lifetime;

    public GlowingTransparentBlockDisplay(EntityType<?> type, Level level) {
        super(type, level);

        this.c_Lifetime = 20 * 6;
        this.setBlockState(ModBlocks.TRANSPARENT_BLOCK.defaultBlockState());
        this.setGlowingTag(true);
    }

    @Override
    public void tick() {
        var blockState = this.level().getBlockState(this.blockPosition());
        if (this.shouldBeRemoved(blockState)) {
            this.remove(RemovalReason.DISCARDED);
        }

        super.tick();
    }

    protected boolean shouldBeRemoved(BlockState blockState) {
        return blockState.isAir() || this.tickCount >= this.c_Lifetime;
    }

    public static void spawnAt(BlockPos pos, ClientLevel level, int glowColor) {
        var entity = new GlowingTransparentBlockDisplay(ModEntityTypes.GLOWING_TRANSPARENT_BLOCK_DISPLAY,  level);
        entity.setPos(pos.getX(), pos.getY(), pos.getZ());
        entity.setGlowColorOverride(glowColor);
        var id = EntityIdGenerator.getNextId(level);
        entity.setId(id);

        level.addEntity(entity);
    }

    public static void spawnAt(BlockPos pos, ClientLevel level) {
        GlowingTransparentBlockDisplay.spawnAt(pos, level, 0xffffff);
    }

    @Override
    public boolean isCurrentlyGlowing() {
        return true;
    }
}