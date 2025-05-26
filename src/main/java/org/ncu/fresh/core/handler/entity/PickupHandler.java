package org.ncu.fresh.core.handler.entity;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.constant.ItemDropProperties;
import org.ncu.fresh.core.utils.PropertyHelper;

public class PickupHandler extends CollisionHandler {
    public PickupHandler() {
        super(EntityType.DROP, EntityType.PLAYER);
    }

    @Override
    protected void onCollisionBegin(Entity a, Entity b) {
        FXGL.getEventBus().fireEvent(PropertyHelper.getEventProperty(a, ItemDropProperties.EVENT_TO_FIRE));
        a.removeFromWorld();

    }

}
