package me.videorab.client.helpers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class PlayerMathHelper {
    public record BlockDataPlayerLookAt(Block block, BlockPos blockPos) {
    }

    public static @Nullable BlockDataPlayerLookAt getBlockDataPlayerLookAt(Player player, boolean withLiquids, double range) {
        HitResult hitResult = player.pick(range, 0, withLiquids);
        if (hitResult.getType() != HitResult.Type.BLOCK) {
            return null;
        }

        Vec3 hitPos = hitResult.getLocation();
        Vec3 playerVisionDir = hitPos.subtract(player.getEyePosition()).normalize().scale(1e-5);
        Vec3 correctedHitPos = hitPos.add(playerVisionDir);
        BlockPos blockPos = new BlockPos((int) Math.floor(correctedHitPos.x), (int) Math.floor(correctedHitPos.y), (int) Math.floor(correctedHitPos.z));

        return new BlockDataPlayerLookAt(player.level().getBlockState(blockPos).getBlock(), blockPos);
    }

    public static @Nullable BlockDataPlayerLookAt getBlockDataPlayerLookAt(Player player, boolean withLiquids) {
        return PlayerMathHelper.getBlockDataPlayerLookAt(player, withLiquids, 5);
    }

    public static @Nullable BlockDataPlayerLookAt getBlockDataPlayerLookAt(Player player) {
        return PlayerMathHelper.getBlockDataPlayerLookAt(player, false, 5);
    }
}
