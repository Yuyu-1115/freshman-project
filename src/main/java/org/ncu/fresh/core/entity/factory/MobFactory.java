package org.ncu.fresh.core.entity.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.HealthBarComponent;
import org.ncu.fresh.core.entity.component.LevelComponent;

public class MobFactory implements EntityFactory {
    public static Entity createMob(Point2D position, double maxHealth) {
        return FXGL.entityBuilder()
                .type(EntityType.ENEMY)
                .at(position)
                .with(new HealthDoubleComponent(maxHealth))
                .with(new HealthBarComponent())
                .with(new LevelComponent())
                .viewWithBBox(new Rectangle(10, 30, Color.GREEN))
                .collidable()
                .buildAndAttach();
    }
}
