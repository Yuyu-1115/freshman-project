package org.ncu.fresh.gui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.ui.UI;
import javafx.fxml.FXMLLoader;
import org.ncu.fresh.Main;
import org.ncu.fresh.core.constant.Constant;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.gui.ui.GameHUDUIController;
import org.ncu.fresh.gui.ui.ResultMenuController;
import org.ncu.fresh.gui.ui.UpgradeUIController;

import java.io.IOException;

public class UIManager {
    /*
    This class is for the UI in game.
     */
    private static final UI GAME_HUD_UI;
    private static final UI LEVEL_UP_UI;
    private static final UI RESULT_UI;
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
            FXMLLoader loader = new FXMLLoader(UIManager.class.getResource("/menu/upgradeUI.fxml"));
            LEVEL_UP_UI = new UI(loader.load(), loader.getController());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        try {
            FXMLLoader loader = new FXMLLoader(UIManager.class.getResource("/menu/resultMenu.fxml"));
            RESULT_UI = new UI(loader.load(), loader.getController());
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public UIManager() {
        FXGL.getGameScene().addUI(GAME_HUD_UI);
    }

    public static void levelUp(int level) {
        if (!isLevelUpUiPresent) {
            ((GameHUDUIController)GAME_HUD_UI.getController()).levelUp(level);
            ((GameHUDUIController)GAME_HUD_UI.getController()).toggleInfo();
            ((UpgradeUIController)LEVEL_UP_UI.getController()).updateOption(level);
            isLevelUpUiPresent = true;
            FXGL.getGameScene().addUI(LEVEL_UP_UI);
            FXGL.getWorldProperties().setValue("isPaused", true);
            ((GameHUDUIController)GAME_HUD_UI.getController()).updateUsername();
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

    public static void updateCount() {
        ((GameHUDUIController)GAME_HUD_UI.getController()).updateKillCount(FXGL.getWorldProperties().getInt(Constant.ENEMY_KILLED));
    }

    public static void updateTimer(int count) {
        ((GameHUDUIController)GAME_HUD_UI.getController()).updateSurviveTime(count);
    }

    public static void updateInventory() {
        ((GameHUDUIController)GAME_HUD_UI.getController()).updateInventory();
    }

    public static void showResult() {
        ((ResultMenuController)RESULT_UI.getController()).updateResult();
        FXGL.getGameScene().removeUI(GAME_HUD_UI);
        FXGL.getGameScene().addUI(RESULT_UI);
    }


}
