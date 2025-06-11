package org.ncu.fresh.event;

import com.almasb.fxgl.entity.Entity;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

public class PlayerEvent extends Event {
    public static final EventType<PlayerEvent> ANY = new EventType<>(Event.ANY, "PLAYER_EVENT");
    public static final EventType<PlayerEvent> DAMAGE = new EventType<>(ANY, "DAMAGE");

    Entity enemy;

    public PlayerEvent(EventType<? extends Event> eventType, Entity enemy) {
        super(eventType);
        this.enemy = enemy;
    }

    public Entity getEnemy() {
        return enemy;
    }
}
