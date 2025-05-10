package org.ncu.fresh.event;

import com.almasb.fxgl.entity.Entity;
import javafx.event.Event;
import javafx.event.EventType;

public class DropEvent extends Event {
    public static final EventType<DropEvent> ANY = new EventType<>(Event.ANY, "DROP_EVENT");
    public static final EventType<DropEvent> EXP = new EventType<>(ANY, "EXP_DROP");
    public static final EventType<DropEvent> COIN = new EventType<>(ANY, "COIN_DROP");

    private final Entity entityDead;

    public DropEvent(EventType<? extends Event> eventType, Entity drop) {
        super(eventType);
        this.entityDead = drop;
    }

}
