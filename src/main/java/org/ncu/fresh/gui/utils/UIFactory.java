package org.ncu.fresh.gui.utils;

import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import org.ncu.fresh.core.constant.WeaponData;


public class UIFactory {
    private static final Image upgradeChoice = FXGL.getAssetLoader().loadImage("ui/upgradeChoice.png");

    public static StackPane createUpgradeOption(WeaponData id) {
        ImageView background = new ImageView(upgradeChoice);
        StackPane buttonView = new StackPane();
        Label skillName = new Label(id.getName());
        background.setFitHeight(upgradeChoice.getHeight() / 2);
        background.setFitWidth(upgradeChoice.getWidth() / 2);

        return buttonView;
    }
}
