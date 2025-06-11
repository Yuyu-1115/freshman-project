package org.ncu.fresh.core.entity.helper;

import com.almasb.fxgl.entity.Entity;
import javafx.event.EventType;
import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.constant.ItemDropProperties;
import org.ncu.fresh.core.entity.constant.PlayerProperties;
import org.ncu.fresh.core.entity.constant.ProjectileProperties;
import org.ncu.fresh.core.entity.factory.ProjectileFactory;
import org.ncu.fresh.event.ItemPickedUpEvent;

public class InitializationHelper {
    public static void initializeItemDrop(Entity entity, int expWorth) {
        entity.setProperty(ItemDropProperties.EXP_WORTH, expWorth);
        entity.setProperty(ItemDropProperties.EVENT_TO_FIRE, new ItemPickedUpEvent(ItemPickedUpEvent.ANY, entity));
    }
    public static void initializeItemDrop(Entity entity, int expWorth, EventType<ItemPickedUpEvent> eventToTrigger) {
        entity.setProperty(ItemDropProperties.EXP_WORTH, expWorth);
        entity.setProperty(ItemDropProperties.EVENT_TO_FIRE, new ItemPickedUpEvent(eventToTrigger, entity));
    }

    public static void initializePlayer(Entity entity) {
        entity.setProperty(PlayerProperties.MOVEMENT_SPEED, 3);
    }

    public static void initializeProjectile(Entity entity, int damage, double speed, double size, boolean isPiercing, WeaponData source) {
        entity.setProperty(ProjectileProperties.DAMAGE, damage);
        entity.setProperty(ProjectileProperties.SIZE, size);
        entity.setProperty(ProjectileProperties.SPEED, speed);
        entity.setProperty(ProjectileProperties.IS_PIERCING, isPiercing);
        entity.setProperty(ProjectileProperties.SOURCE, source);
    }
}
