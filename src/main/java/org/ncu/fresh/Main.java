package org.ncu.fresh;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Point2D;
import org.ncu.fresh.core.entity.factory.EnemyFactory;
import org.ncu.fresh.core.entity.factory.PlayerFactory;
import org.ncu.fresh.core.handler.entity.MobProjectileHandler;
import org.ncu.fresh.core.handler.entity.PlayerProjectileHandler;

public class Main extends GameApplication {

    @Override
    protected void initGame() {
        PlayerFactory.createPlayer();
        for (int i = 0; i < 4; i++) {
            Point2D position = new Point2D(100 + i * 200, 100 + i * 100);
            EnemyFactory.createEnemy(position, 100);
        }
    }

    @Override
    protected void initPhysics() {
        FXGL.getPhysicsWorld().addCollisionHandler(new PlayerProjectileHandler());
        FXGL.getPhysicsWorld().addCollisionHandler(new MobProjectileHandler());
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
