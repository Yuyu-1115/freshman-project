package org.ncu.fresh.gui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.ui.UI;
import javafx.fxml.FXMLLoader;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.gui.ui.GameHUDUIController;

import java.io.IOException;

public class UIManager {
    private static final UI GAME_HUD_UI;
    private static final UI LEVEL_UP_UI;

    static {
        try {
            FXMLLoader loader = new FXMLLoader(UIManager.class.getResource("/menu/HUD.fxml"));
            GAME_HUD_UI = new UI(loader.load(), loader.getController());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            FXMLLoader loader = new FXMLLoader(UIManager.class.getResource("/menu/UpgradeUI.fxml"));
            LEVEL_UP_UI = new UI(loader.load(), loader.getController());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UIManager() {
        FXGL.getGameScene().addUI(GAME_HUD_UI);
    }

    public static void levelUp(int level) {
        ((GameHUDUIController)GAME_HUD_UI.getController()).levelUp(level);
        ((GameHUDUIController)GAME_HUD_UI.getController()).toggleInfo();
        FXGL.getGameScene().addUI(LEVEL_UP_UI);

        FXGL.getGameController().pauseEngine();
    }

    public static void updateBar() {
        ((GameHUDUIController)GAME_HUD_UI.getController()).updateBar(
                ReferenceHelper.getPlayer().getComponent(HealthDoubleComponent.class).getValuePercent() / 100.0,
                ReferenceHelper.getPlayer().getComponent(LevelComponent.class).getExpProgressPercent() / 100.0
        );
    }
}
