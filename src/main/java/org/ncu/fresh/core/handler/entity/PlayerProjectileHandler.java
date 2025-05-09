package org.ncu.fresh.core.handler.entity;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.EnemyComponent;
import org.ncu.fresh.core.entity.component.ProjectileDataComponent;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.component.resourcebar.HealthBarComponent;

public class PlayerProjectileHandler extends CollisionHandler {
    public PlayerProjectileHandler() {
        super(EntityType.PROJECTILE, EntityType.ENEMY);
    }

    @Override
    protected void onCollision(Entity a, Entity b) {
        if (a.getComponent(ProjectileDataComponent.class).getSource().equals(EntityType.PLAYER)) {
            b.getComponent(HealthDoubleComponent.class).damage(a.getComponent(ProjectileDataComponent.class).getDamage());
            b.getComponent(HealthBarComponent.class).damage();
            FXGL.getGameWorld().removeEntity(a);
            if (b.getComponent(HealthDoubleComponent.class).isZero()) {
                FXGL.getGameWorld().getSingleton(EntityType.PLAYER).getComponent(LevelComponent.class).gainExperienceFrom(b);
                FXGL.getGameWorld().removeEntity(b);
            }
        }
    }
}
