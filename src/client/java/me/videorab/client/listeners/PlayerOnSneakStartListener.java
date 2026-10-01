package me.videorab.client.listeners;

import me.videorab.algos.BlockClusterFinder;
import me.videorab.client.entities.GlowingTransparentBlockDisplay;
import me.videorab.client.events.PlayerOnSneakStartEvent;
import me.videorab.client.helpers.GlowingColors;
import me.videorab.client.helpers.PlayerMathHelper;
import me.videorab.helpers.OreDetector;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;

public class PlayerOnSneakStartListener implements PlayerOnSneakStartEvent {
    @Override
    public void onSneakStart(LocalPlayer player) {
        var blockData = PlayerMathHelper.getBlockDataPlayerLookAt(player);
        if (!this.isValidBlock(blockData)) {
            return;
        }

        var cluster = BlockClusterFinder.getInstance()
                .getCluster(player.level(), blockData.blockPos());

        for (var blockPos : cluster) {
            GlowingTransparentBlockDisplay.spawnAt(blockPos, (ClientLevel) player.level(), GlowingColors.getGlowingColor(blockData.block()));
        }
    }

    protected boolean isValidBlock(PlayerMathHelper.BlockDataPlayerLookAt blockData) {
        return blockData != null && OreDetector.isOre(blockData.block());
    }
}
