package org.ncu.fresh.gui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.ui.UI;
import javafx.fxml.FXMLLoader;
import org.ncu.fresh.Main;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.gui.ui.GameHUDUIController;
import org.ncu.fresh.gui.ui.UpgradeUIController;

import java.io.IOException;

public class UIManager {
    private static final UI GAME_HUD_UI;
    private static final UI LEVEL_UP_UI;
    private static boolean isLevelUpUiPresent = false;

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
        if (!isLevelUpUiPresent) {
            ((GameHUDUIController)GAME_HUD_UI.getController()).levelUp(level);
            ((GameHUDUIController)GAME_HUD_UI.getController()).toggleInfo();
            ((UpgradeUIController)LEVEL_UP_UI.getController()).updateOption();
            isLevelUpUiPresent = true;
            FXGL.getGameScene().addUI(LEVEL_UP_UI);
            FXGL.getWorldProperties().setValue("isPaused", true);
        }
    }

    public static void hindLevelUpUI() {
        isLevelUpUiPresent = false;
        FXGL.getGameScene().removeUI(LEVEL_UP_UI);
        ((GameHUDUIController)GAME_HUD_UI.getController()).toggleInfo();
    }


    public static void updateBar() {
        ((GameHUDUIController)GAME_HUD_UI.getController()).updateBar(
                ReferenceHelper.getPlayer().getComponent(HealthDoubleComponent.class).getValuePercent() / 100.0,
                ReferenceHelper.getPlayer().getComponent(LevelComponent.class).getExpProgressPercent() / 100.0
        );
    }

    public static void updateInventory() {
        ((GameHUDUIController)GAME_HUD_UI.getController()).updateInventory();
    }
}
