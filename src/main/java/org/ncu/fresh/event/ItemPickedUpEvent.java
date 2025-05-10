package org.ncu.fresh.event;

import com.almasb.fxgl.entity.Entity;
import javafx.event.Event;
import javafx.event.EventType;

public class ItemPickedUpEvent extends Event {
    public static final EventType<ItemPickedUpEvent> ANY = new EventType<>(Event.ANY, "PICKUP_EVENT");
    public static final EventType<ItemPickedUpEvent> EXP = new EventType<>(ANY, "EXP_PICKUP");

    private final Entity pickup;

    public ItemPickedUpEvent(EventType<? extends Event> eventType, Entity pickup) {
        super(eventType);
        this.pickup = pickup;
    }

    public Entity getPickup() {
        return pickup;
    }
}
