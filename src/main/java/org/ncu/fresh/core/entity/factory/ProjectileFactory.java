package org.ncu.fresh.core.entity.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.util.Duration;
import org.ncu.fresh.core.entity.EntityType;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ProjectileFactory implements EntityFactory {
    /*
    Create a new Projectile based on given position and direction
     */
    public static Entity createProjectile(Point2D position, Point2D direction) {
        Entity projectile =  FXGL.entityBuilder()
                .type(EntityType.PROJECTILE)
                .at(position)
                .viewWithBBox(new Circle(5, Color.RED))
                .with(new ProjectileComponent(direction, 40))
                .build();
        FXGL.getGameTimer().runOnceAfter(() -> projectile.addComponent(
                new CollidableComponent(true)),
                Duration.millis(100));
        return projectile;
    }
}
