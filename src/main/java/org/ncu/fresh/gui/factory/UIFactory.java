package org.ncu.fresh.gui.factory;

import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class UIFactory {
    public static Button createUpgradeOption() {
        Button button = new Button();
        button.setPrefSize(180, 100);
        button.setGraphic(new Rectangle(0, 0, 180, 100));
        button.setOnAction(event -> System.out.println("Upgrade Chosen"));
        return button;
    }
}
