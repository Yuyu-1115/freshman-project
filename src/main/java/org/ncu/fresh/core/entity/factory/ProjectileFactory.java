package org.ncu.fresh.core.entity.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.components.BoundingBoxComponent;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
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
                .view(new Circle(5, Color.RED))
                .with(new ProjectileComponent(direction, 40))
                .collidable()
                .build();
        // Making Projectile won't collide with each other so that they won't interfere with each other
        projectile.getComponent(CollidableComponent.class).addIgnoredType(EntityType.PROJECTILE);
        projectile.getComponent(CollidableComponent.class).addIgnoredType(EntityType.PROJECTILE_PIERCING);
        projectile.getComponent(BoundingBoxComponent.class).addHitBox(new HitBox("body", BoundingShape.circle(5)));
        return projectile;
    }
}
