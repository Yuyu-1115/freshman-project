package org.ncu.fresh;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.dsl.handlers.CollectibleHandler;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import javafx.geometry.Point2D;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.HealthBarComponent;
import org.ncu.fresh.core.entity.factory.MobFactory;
import org.ncu.fresh.core.entity.factory.PlayerFactory;

public class Main extends GameApplication {

    @Override
    protected void initGame() {
        PlayerFactory.createPlayer();
        for (int i = 0; i < 4; i++) {
            Point2D position = new Point2D(100 + i * 200, 100);
            MobFactory.createMob(position, 100);
        }
    }

    @Override
    protected void initPhysics() {
        FXGL.getPhysicsWorld().addCollisionHandler(
                new CollisionHandler(EntityType.PROJECTILE, EntityType.ENEMY) {
                    @Override
                    protected void onCollision(Entity a, Entity b) {
                        b.getComponent(HealthDoubleComponent.class).damage(20);
                        b.getComponent(HealthBarComponent.class).onDamaged();
                        FXGL.getGameWorld().removeEntity(a);
                        if (b.getComponent(HealthDoubleComponent.class).isZero()) {
                            FXGL.getGameWorld().removeEntity(b);
                        }
                    }
                }
        );
    }

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(800);
        gameSettings.setHeight(640);
        gameSettings.setTitle("Team Project");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
