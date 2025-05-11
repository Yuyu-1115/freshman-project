package org.ncu.fresh;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.geometry.Point2D;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.constant.ItemDropProperties;
import org.ncu.fresh.core.entity.factory.EnemyFactory;
import org.ncu.fresh.core.entity.factory.PlayerFactory;
import org.ncu.fresh.core.handler.entity.PickupHandler;
import org.ncu.fresh.core.handler.entity.PlayerProjectileHandler;
import org.ncu.fresh.core.utils.helper.PropertyHelper;
import org.ncu.fresh.event.ItemPickedUpEvent;

import static org.ncu.fresh.core.constant.ApplicationConfig.WINDOWS_HEIGHT;
import static org.ncu.fresh.core.constant.ApplicationConfig.WINDOWS_WIDTH;

public class Main extends GameApplication {

    @Override
    protected void initGame() {
        Entity player = PlayerFactory.createPlayer();
        for (int i = 0; i < 4; i++) {
            Point2D position = new Point2D(100 + i * 200, 100 + i * 100);
            EnemyFactory.createEnemy(position, 100);
        }
        FXGL.getEventBus().addEventHandler(ItemPickedUpEvent.EXP,
                itemPickedUpEvent -> player.getComponent(LevelComponent.class)
                        .giveExperience(PropertyHelper.getIntProperty(itemPickedUpEvent.getPickup(), ItemDropProperties.EXP_WORTH)));
    }

    @Override
    protected void initPhysics() {
        FXGL.getPhysicsWorld().addCollisionHandler(new PlayerProjectileHandler());
        FXGL.getPhysicsWorld().addCollisionHandler(new PickupHandler());
    }

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(WINDOWS_WIDTH);
        gameSettings.setHeight(WINDOWS_HEIGHT);
        gameSettings.setTitle("Team Project");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
