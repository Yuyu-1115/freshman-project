package org.ncu.fresh.core.entity.helper;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.player.PlayerComponent;

public class ReferenceHelper {
    public static Entity getPlayer() {
        return FXGL.getGameWorld().getSingleton(EntityType.PLAYER);
    }

    public static PlayerComponent getPlayerComponent() {
        return FXGL.getGameWorld().getSingleton(EntityType.PLAYER).getComponent(PlayerComponent.class);
    }
}
