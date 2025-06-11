package org.ncu.fresh.core.handler;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.event.EventBus;
import org.ncu.fresh.core.entity.component.EnemyComponent;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.constant.ItemDropProperties;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.core.utils.PropertyHelper;
import org.ncu.fresh.event.ItemPickedUpEvent;
import org.ncu.fresh.event.PlayerEvent;

public class EventHandler {
    public static void initializeEventHandler() {
        EventBus eventBus = FXGL.getEventBus();
        eventBus.addEventHandler(ItemPickedUpEvent.EXP,
                itemPickedUpEvent -> ReferenceHelper.getPlayer().getComponent(LevelComponent.class)
                        .giveExperience(PropertyHelper.getIntProperty(itemPickedUpEvent.getPickup(), ItemDropProperties.EXP_WORTH)));
        eventBus.addEventHandler(PlayerEvent.DAMAGE,
                playerEvent -> ReferenceHelper.getPlayerComponent()
                        .damage(playerEvent.getEnemy().getComponent(EnemyComponent.class).getAttack()));
    }
}
