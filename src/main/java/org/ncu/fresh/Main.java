package org.ncu.fresh;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.constant.ItemDropProperties;
import org.ncu.fresh.core.entity.factory.EnemyFactory;
import org.ncu.fresh.core.entity.factory.PlayerFactory;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.core.handler.entity.PickupHandler;
import org.ncu.fresh.core.handler.entity.ProjectileHandler;
import org.ncu.fresh.core.utils.PropertyHelper;
import org.ncu.fresh.event.ItemPickedUpEvent;
import org.ncu.fresh.gui.UIManager;

import java.util.Map;

import static org.ncu.fresh.core.constant.Constant.WINDOWS_HEIGHT;
import static org.ncu.fresh.core.constant.Constant.WINDOWS_WIDTH;

public class Main extends GameApplication {

    @Override
    protected void initGame() {
        Entity player = PlayerFactory.createPlayer();
        for (int i = 0; i < 4; i++) {
            Point2D position = new Point2D(100 + i * 50, 100 + i * 50);
            EnemyFactory.createEnemy(position, 100, new ImageView(FXGL.getAssetLoader().loadImage("slime.png")));
        }
        FXGL.getEventBus().addEventHandler(ItemPickedUpEvent.EXP,
                itemPickedUpEvent -> player.getComponent(LevelComponent.class)
                        .giveExperience(PropertyHelper.getIntProperty(itemPickedUpEvent.getPickup(), ItemDropProperties.EXP_WORTH)));

    }

    @Override
    protected void initUI() {
        UIManager uiManager = new UIManager();
        FXGL.getGameScene().getViewport().bindToEntity(ReferenceHelper.getPlayer(), WINDOWS_WIDTH / 2.0, WINDOWS_HEIGHT / 2.0);
    }

    @Override
    protected void initPhysics() {
        FXGL.getPhysicsWorld().addCollisionHandler(new ProjectileHandler());
        FXGL.getPhysicsWorld().addCollisionHandler(new PickupHandler());
    }

    @Override
    protected void initGameVars(Map<String, Object> vars) {
        vars.put("isPaused", false);
    }

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(WINDOWS_WIDTH);
        gameSettings.setHeight(WINDOWS_HEIGHT);

        gameSettings.setScaleAffectedOnResize(true);
        gameSettings.setPreserveResizeRatio(true);
        gameSettings.setManualResizeEnabled(true);
        gameSettings.setTitle("Team Project");

    }

    public static void main(String[] args) {
        launch(args);
    }
}
