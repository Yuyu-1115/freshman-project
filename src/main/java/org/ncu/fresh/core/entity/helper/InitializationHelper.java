package org.ncu.fresh.core.entity.helper;

import com.almasb.fxgl.entity.Entity;
import javafx.event.EventType;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.constants.ItemDropProperties;
import org.ncu.fresh.core.entity.constants.PlayerProperties;
import org.ncu.fresh.core.entity.constants.ProjectileProperties;
import org.ncu.fresh.event.ItemPickedUpEvent;
import org.w3c.dom.events.Event;

public class InitializationHelper {
    public static void initializeItemDrop(Entity entity, int expWorth, int coinWorth) {
        entity.setProperty(ItemDropProperties.EXP_WORTH, expWorth);
        entity.setProperty(ItemDropProperties.COIN_WORTH, coinWorth);
        entity.setProperty(ItemDropProperties.EVENT_TO_FIRE, new ItemPickedUpEvent(ItemPickedUpEvent.ANY, entity));
    }
    public static void initializeItemDrop(Entity entity, int expWorth, int coinWorth, EventType<ItemPickedUpEvent> eventToTrigger) {
        entity.setProperty(ItemDropProperties.EXP_WORTH, expWorth);
        entity.setProperty(ItemDropProperties.COIN_WORTH, coinWorth);
        entity.setProperty(ItemDropProperties.EVENT_TO_FIRE, new ItemPickedUpEvent(eventToTrigger, entity));
    }

    public static void initializePlayer(Entity entity) {
        entity.setProperty(PlayerProperties.ATTACK_DAMAGE, 10);
        entity.setProperty(PlayerProperties.ABILITY_POWER, 10);

        entity.setProperty(PlayerProperties.MAX_HEALTH, 10);

        entity.setProperty(PlayerProperties.CRITICAL_CHANCE, 10);
        entity.setProperty(PlayerProperties.CRITICAL_DAMAGE, 10);
        entity.setProperty(PlayerProperties.ATTACK_SPEED, 10);

        entity.setProperty(PlayerProperties.MAGIC_RESISTANCE, 10);
        entity.setProperty(PlayerProperties.ARMOR_PENETRATION, 10);
        entity.setProperty(PlayerProperties.MAGIC_PENETRATION, 10);
        entity.setProperty(PlayerProperties.MOVEMENT_SPEED, 5);
    }

    public static void initializeProjectile(Entity entity, int damage, double speed, double size, EntityType source) {
        entity.setProperty(ProjectileProperties.DAMAGE, damage);
        entity.setProperty(ProjectileProperties.SIZE, size);
        entity.setProperty(ProjectileProperties.SPEED, speed);
        entity.setProperty(ProjectileProperties.SOURCE, source);
    }
}
