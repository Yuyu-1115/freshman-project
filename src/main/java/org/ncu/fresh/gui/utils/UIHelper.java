package org.ncu.fresh.gui.utils;

import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.component.player.PlayerComponent;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.core.utils.WeaponHelper;
import org.ncu.fresh.gui.UIManager;


public class UIFactory {
    private static final Image upgradeChoice = FXGL.getAssetLoader().loadImage("ui/upgrade/upgradeChoice.png");

    public static void createUpgradeOption(WeaponData id, AnchorPane buttonView) {
        buttonView.getChildren().clear();
        ImageView background = new ImageView(upgradeChoice);
        ImageView skillIcon = new ImageView(WeaponHelper.getIcon(id.getId()));
        Button button = new Button("", background);
        Label skillName = new Label(id.getName());
        Label skillDesc = new Label(id.getLongDesc());

        button.setOnAction(event -> {
            System.out.println("Button pressed");
            ReferenceHelper.getPlayer().getComponent(PlayerComponent.class).giveWeapon(id.getComponentSupplier().get());

            UIManager.hindLevelUpUI();
            FXGL.getWorldProperties().setValue("isPaused", false);
        });

        buttonView.getChildren().addAll(button, skillIcon, skillName, skillDesc);

        buttonView.setPrefWidth(128);
        buttonView.setPrefHeight(196);

        // some constant for alignment
        background.setLayoutX(0);
        background.setLayoutY(0);
        background.setFitWidth(upgradeChoice.getWidth() / 2);
        background.setFitHeight(upgradeChoice.getHeight() / 2);

        skillIcon.setLayoutX(48);
        skillIcon.setLayoutY(16);
        skillIcon.setLayoutY(16);

        skillName.getStyleClass().add("skillName");
        skillName.setFont(FontHelper.alagard(13));
        skillName.setLayoutX(16);
        skillName.setLayoutY(64);
        skillName.setPrefWidth(96);

        skillDesc.getStyleClass().add("skillDesc");
        skillDesc.setFont(FontHelper.shareTechMono(7));
        skillDesc.setLayoutX(16);
        skillDesc.setLayoutY(96);
        skillDesc.setPrefWidth(96);
        skillDesc.setMaxHeight(96);
    }
}
