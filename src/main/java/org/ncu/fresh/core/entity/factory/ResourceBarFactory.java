package org.ncu.fresh.core.entity.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.ncu.fresh.core.entity.EntityType;

public class ResourceBarFactory implements EntityFactory {
    public static Entity createHealthBar(Point2D position) {
        return FXGL.entityBuilder()
                .type(EntityType.DISPLAY)
                .at(position)
                .view(new Rectangle(80, 10, Color.ORANGERED))
                .build();
    }
    public static Entity createExperienceBar(Point2D position) {
        return FXGL.entityBuilder()
                .type(EntityType.DISPLAY)
                .at(position)
                .view(new Rectangle(400, 40, Color.LIMEGREEN))
                .build();
    }
}
