package org.ncu.fresh.entity.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import org.ncu.fresh.entity.EntityType;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ProjectileFactory implements EntityFactory {
    public static Entity createProjectile(Point2D position, Point2D direction) {
        return FXGL.entityBuilder()
                .type(EntityType.PROJECTILE)
                .viewWithBBox(new Circle(20, Color.RED))
                .with(new ProjectileComponent())
                .collidable()
                .build();
    }
}
