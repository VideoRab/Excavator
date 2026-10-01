package me.videorab.client.entities.renderers;

import me.videorab.client.entities.ModEntityTypes;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class ModEntityRenderers {
    public static void initialize() {
        EntityRenderers.register(
                ModEntityTypes.GLOWING_TRANSPARENT_BLOCK_DISPLAY,
                GlowingTransparentBlockDisplayRenderer::new
        );
    }
}
