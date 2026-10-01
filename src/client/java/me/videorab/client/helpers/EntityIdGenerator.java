package me.videorab.client.helpers;

import net.minecraft.world.level.Level;

import java.util.concurrent.atomic.AtomicInteger;

public class EntityIdGenerator {
    protected static final AtomicInteger s_NextId = new AtomicInteger();

    public static int getNextId(Level level) {
        int id = 0;

        while (id == 0 || level.getEntity(id) != null) {
            id = s_NextId.incrementAndGet();
        }

        return id;
    }
}
