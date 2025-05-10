package org.ncu.fresh.core.handler.entity;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.resourcebar.HealthBarComponent;
import org.ncu.fresh.core.entity.constants.ProjectileProperties;
import org.ncu.fresh.core.entity.factory.ItemDropFactory;
import org.ncu.fresh.core.utils.helper.PropertyHelper;

public class PlayerProjectileHandler extends CollisionHandler {
    public PlayerProjectileHandler() {
        super(EntityType.PROJECTILE, EntityType.ENEMY);
    }

    @Override
    protected void onCollision(Entity a, Entity b) {
        b.getComponent(HealthDoubleComponent.class).damage(PropertyHelper.getIntProperty(a, ProjectileProperties.DAMAGE));
        b.getComponent(HealthBarComponent.class).damage();
        FXGL.getGameWorld().removeEntity(a);
        if (b.getComponent(HealthDoubleComponent.class).isZero()) {
            ItemDropFactory.createExperienceOrb(b.getPosition(), 10);
            FXGL.getGameWorld().removeEntity(b);
        }
    }
}
