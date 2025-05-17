package org.ncu.fresh.gui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.ui.UI;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.gui.ui.GameHUDUIController;

import java.io.IOException;

public class UIManager {
    private static final Parent GAME_HUD_UI_PARENT;
    private static final GameHUDUIController GAME_HUD_UI_CONTROLLER;
    private static final UI GAME_HUD_UI;

    static {
        try {
            FXMLLoader loader = new FXMLLoader(UIManager.class.getResource("/menu/HUD.fxml"));
            GAME_HUD_UI_PARENT = loader.load();
            GAME_HUD_UI_CONTROLLER = loader.getController();
            GAME_HUD_UI = new UI(GAME_HUD_UI_PARENT, GAME_HUD_UI_CONTROLLER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UIManager() {
        FXGL.getGameScene().addUI(GAME_HUD_UI);
    }

    public static void levelUp() {
        GAME_HUD_UI_CONTROLLER.levelUp();
    }

    public static void updateBar() {
        GAME_HUD_UI_CONTROLLER.updateBar(
                ReferenceHelper.getPlayer().getComponent(HealthDoubleComponent.class).getValuePercent() / 100.0,
                ReferenceHelper.getPlayer().getComponent(LevelComponent.class).getExpProgressPercent() / 100.0
        );
    }
}
