package org.ncu.fresh.core.entity.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.Spawns;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.EnemyComponent;
import org.ncu.fresh.core.entity.component.resourcebar.HealthBarComponent;

public class EnemyFactory implements EntityFactory {
    @Spawns("enemy")
    public static Entity createEnemy(Point2D position, double maxHealth, ImageView imageView) {
        return FXGL.entityBuilder()
                .type(EntityType.ENEMY)
                .at(position)
                .with(new HealthDoubleComponent(maxHealth))
                .with(new HealthBarComponent())
                .with(new EnemyComponent(40, 2))
                .viewWithBBox(imageView)
                .collidable()
                .buildAndAttach();
    }
}
