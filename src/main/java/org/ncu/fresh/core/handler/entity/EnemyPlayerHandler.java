package org.ncu.fresh.core.handler.entity;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.EnemyComponent;

public class EnemyPlayerHandler extends CollisionHandler {
    public EnemyPlayerHandler() {
        super(EntityType.ENEMY, EntityType.PLAYER);
    }

    @Override
    protected void onCollisionBegin(Entity a, Entity b) {
        a.getComponent(EnemyComponent.class).setAttacking(true);
    }

    @Override
    protected void onCollisionEnd(Entity a, Entity b) {
        a.getComponent(EnemyComponent.class).setAttacking(false);
    }
}

