package org.ncu.fresh.core.handler.entity;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.resourcebar.HealthBarComponent;
import org.ncu.fresh.core.entity.constant.ProjectileProperties;
import org.ncu.fresh.core.entity.factory.ItemDropFactory;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.core.utils.PropertyHelper;

public class ProjectileHandler extends CollisionHandler {
    public ProjectileHandler() {
        super(EntityType.PROJECTILE, EntityType.ENEMY);
    }


    @Override
    protected void onCollisionBegin(Entity a, Entity b) {
        b.getComponent(HealthDoubleComponent.class).damage(PropertyHelper.getIntProperty(a, ProjectileProperties.DAMAGE));
        b.getComponent(HealthBarComponent.class).damage();
        ReferenceHelper.getPlayerComponent().updateRecord(
                PropertyHelper.getWeaponDataProperty(a, ProjectileProperties.SOURCE),
                PropertyHelper.getIntProperty(a, ProjectileProperties.DAMAGE)
        );
        if (!PropertyHelper.getBooleanProperty(a, ProjectileProperties.IS_PIERCING)) {
            a.removeFromWorld();
        }
        if (b.getComponent(HealthDoubleComponent.class).isZero()) {
            ItemDropFactory.createExperienceOrb(b.getPosition());
            FXGL.getGameWorld().removeEntity(b);
        }
    }
}
