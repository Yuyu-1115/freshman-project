package org.ncu.fresh;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.constant.ItemDropProperties;
import org.ncu.fresh.core.entity.factory.PlayerFactory;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.core.handler.InputHandler;
import org.ncu.fresh.core.handler.TimerHandler;
import org.ncu.fresh.core.handler.entity.PickupHandler;
import org.ncu.fresh.core.handler.entity.ProjectileHandler;
import org.ncu.fresh.core.utils.PropertyHelper;
import org.ncu.fresh.event.ItemPickedUpEvent;
import org.ncu.fresh.gui.UIManager;
import org.ncu.fresh.gui.utils.MenuFactory;

import java.util.Map;

import static org.ncu.fresh.core.constant.Constant.WINDOWS_HEIGHT;
import static org.ncu.fresh.core.constant.Constant.WINDOWS_WIDTH;

public class Main extends GameApplication {

    private Entity player;

    @Override
    protected void initGame() {
        player = PlayerFactory.createPlayer();

        FXGL.getEventBus().addEventHandler(ItemPickedUpEvent.EXP,
                itemPickedUpEvent -> player.getComponent(LevelComponent.class)
                        .giveExperience(PropertyHelper.getIntProperty(itemPickedUpEvent.getPickup(), ItemDropProperties.EXP_WORTH)));
        TimerHandler.initializeTimer();
    }

    @Override
    protected void initUI() {
        UIManager uiManager = new UIManager();
        FXGL.getGameScene().getViewport().bindToEntity(ReferenceHelper.getPlayer(), WINDOWS_WIDTH / 2.0, WINDOWS_HEIGHT / 2.0);
    }

    @Override
    protected void initInput() {
        InputHandler.initPlayerMovement();
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
        gameSettings.setTitle("Lex Elementi: Apotheosis");
        gameSettings.setMainMenuEnabled(true);
        gameSettings.setSceneFactory(new MenuFactory());

    }

    public static void main(String[] args) {
        launch(args);
    }
}
