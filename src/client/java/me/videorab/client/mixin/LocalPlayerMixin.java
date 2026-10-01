package me.videorab.client.mixin;

import me.videorab.client.events.PlayerOnSneakStartEvent;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public abstract class LocalPlayerMixin {
    @Unique
    private boolean m_WasSneaking = false;

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
        LocalPlayer player = (LocalPlayer) (Object)this;
        if (!this.m_WasSneaking && player.isShiftKeyDown()) {
            PlayerOnSneakStartEvent.EVENT.invoker().onSneakStart(player);

            this.m_WasSneaking = true;
        }

        if (!player.isShiftKeyDown() && this.m_WasSneaking) {
            this.m_WasSneaking = false;
        }
    }
}
