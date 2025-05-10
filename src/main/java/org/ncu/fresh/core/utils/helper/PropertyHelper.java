package org.ncu.fresh.core.utils.helper;


import com.almasb.fxgl.entity.Entity;
import javafx.event.Event;

public class PropertyHelper {
    public static int getIntProperty(Entity entity, String property) {
        return entity.getProperties().getInt(property);
    }

    public static double getDoubleProperty(Entity entity, String property) {
        return entity.getProperties().getDouble(property);
    }

    public static String getStringProperty(Entity entity, String property) {
        return entity.getProperties().getString(property);
    }

    public static Event getEventProperty(Entity entity, String property) {
        return entity.getProperties().getObject(property);
    }

    public static Object getObjectProperty(Entity entity, String property) {
        return entity.getProperties().getObject(property);
    }
}
