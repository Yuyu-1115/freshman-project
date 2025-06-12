package org.ncu.fresh.gui.ui;

import com.almasb.fxgl.dsl.FXGL;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.ncu.fresh.core.constant.Constant;
import org.ncu.fresh.gui.MainMenu;

public class MainMenuController {
    @FXML private TextField username;

    @FXML
    private void gameStart() {
        FXGL.getGameController().startNewGame();
        FXGL.getWorldProperties().setValue(Constant.USERNAME, username.getText());
    }

}
