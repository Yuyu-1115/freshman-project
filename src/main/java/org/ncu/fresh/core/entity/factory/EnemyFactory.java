package org.ncu.fresh.core.entity.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.Spawns;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.BasicAttackComponent;
import org.ncu.fresh.core.entity.component.EnemyComponent;
import org.ncu.fresh.core.entity.component.resourcebar.HealthBarComponent;
import org.ncu.fresh.core.entity.component.player.LevelComponent;

public class EnemyFactory implements EntityFactory {
    @Spawns("enemy")
    public static Entity createEnemy(Point2D position, double maxHealth, ImageView imageView) {
        return FXGL.entityBuilder()
                .type(EntityType.ENEMY)
                .at(position)
                .with(new HealthDoubleComponent(maxHealth))
                .with(new HealthBarComponent())
                .with(new LevelComponent())
                .with(new EnemyComponent())
                .viewWithBBox(imageView)
                .collidable()
                .buildAndAttach();
    }
}
