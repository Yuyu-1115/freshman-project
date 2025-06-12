package org.ncu.fresh.gui.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.ncu.fresh.gui.MainMenu;

public class MainMenuController {
    @FXML private Button startButton;

    private MainMenu mainMenu;

    @FXML
    private void gameStart() {
        mainMenu.startNewGame();
    }

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }
}
