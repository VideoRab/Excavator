package me.videorab.listeners;

import me.videorab.algos.BlockClusterFinder;
import me.videorab.helpers.OreDetector;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents.Before;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerBlockBreakBeforeListener implements Before {
    protected Set<UUID> m_breaking = ConcurrentHashMap.newKeySet();

    @Override
    public boolean beforeBlockBreak(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity) {
        if (!this.m_breaking.add(player.getUUID())) {
            return true;
        }

        if (this.isEverythingOk(state, player)) {
            this.m_breaking.remove(player.getUUID());

            return true;
        }

        var cluster = BlockClusterFinder.getInstance()
                .getCluster(level, pos);

        ServerPlayer serverPlayer = (ServerPlayer) player;
        for (var blockPos : cluster) {
            if (blockPos.equals(pos)) {
                continue;
            }

            serverPlayer.gameMode.destroyBlock(blockPos);
        }

        this.m_breaking.remove(player.getUUID());

        return true;
    }

    protected boolean isEverythingOk(BlockState state, Player player) {
        return !OreDetector.isOre(state.getBlock()) ||
                !player.isShiftKeyDown() ||
                !player.getActiveItem().isCorrectToolForDrops(state);
    }
}
