package org.ncu.fresh.core.entity.helper;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import org.ncu.fresh.core.entity.EntityType;

public class ReferenceHelper {
    public static Entity getPlayer() {
        return FXGL.getGameWorld().getSingleton(EntityType.PLAYER);
    }
}
