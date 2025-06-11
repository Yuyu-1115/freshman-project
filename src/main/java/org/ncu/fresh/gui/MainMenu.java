package org.ncu.fresh.gui;

import com.almasb.fxgl.app.scene.FXGLMenu;
import com.almasb.fxgl.app.scene.MenuType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.jetbrains.annotations.NotNull;
import org.ncu.fresh.gui.ui.MainMenuController;

import java.io.IOException;

public class MainMenu extends FXGLMenu {

    public MainMenu(@NotNull MenuType type) {
        super(type);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/menu/mainPage.fxml"));
            Parent root = loader.load();
            ((MainMenuController)loader.getController()).setMainMenu(this);
            getContentRoot().getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startNewGame() {
        fireNewGame();
    }

}
