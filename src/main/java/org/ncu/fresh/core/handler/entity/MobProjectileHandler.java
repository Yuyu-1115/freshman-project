package org.ncu.fresh.core.handler.entity;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.ProjectileDataComponent;
import org.ncu.fresh.core.entity.component.resourcebar.HealthBarComponent;

public class MobProjectileHandler extends CollisionHandler {
    public MobProjectileHandler() {
        super(EntityType.PROJECTILE, EntityType.PLAYER);
    }

    @Override
    protected void onCollision(Entity a, Entity b) {
        if (a.getComponent(ProjectileDataComponent.class).getSource().equals(EntityType.ENEMY)) {
            b.getComponent(HealthDoubleComponent.class).damage(a.getComponent(ProjectileDataComponent.class).getDamage());
            b.getComponent(HealthBarComponent.class).damage();
            FXGL.getGameWorld().removeEntity(a);
            if (b.getComponent(HealthDoubleComponent.class).isZero()) {
                FXGL.getGameWorld().removeEntity(b);
            }
        }
    }
}
