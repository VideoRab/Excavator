package me.videorab.client.entities.renderers;

import net.minecraft.client.renderer.entity.DisplayRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class GlowingTransparentBlockDisplayRenderer extends DisplayRenderer.BlockDisplayRenderer {
    protected GlowingTransparentBlockDisplayRenderer(EntityRendererProvider.Context context) {
        super(context);
    }
}
