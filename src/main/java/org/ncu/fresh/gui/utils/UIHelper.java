package org.ncu.fresh.gui.utils;

import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.core.utils.WeaponHelper;
import org.ncu.fresh.gui.UIManager;


public class UIHelper {
    private static final Image upgradeChoice = FXGL.getAssetLoader().loadImage("ui/upgrade/upgradeChoice.png");

    private static final Image itemFrame0 = FXGL.getAssetLoader().loadImage("ui/hud/itemFrame0.png");
    private static final Image itemFrame1 = FXGL.getAssetLoader().loadImage("ui/hud/itemFrame1.png");
    private static final Image itemFrame2 = FXGL.getAssetLoader().loadImage("ui/hud/itemFrame2.png");
    private static final Image itemFrame3 = FXGL.getAssetLoader().loadImage("ui/hud/itemFrame3.png");
    private static final Image itemFrame4 = FXGL.getAssetLoader().loadImage("ui/hud/itemFrame4.png");
    private static final Image itemFrame5 = FXGL.getAssetLoader().loadImage("ui/hud/itemFrame5.png");
    private static final Image itemFrame6 = FXGL.getAssetLoader().loadImage("ui/hud/itemFrame6.png");
    private static final Image itemFrame7 = FXGL.getAssetLoader().loadImage("ui/hud/itemFrame7.png");
    private static final Image itemFrame8 = FXGL.getAssetLoader().loadImage("ui/hud/itemFrame8.png");


    private static final Image itemLevel0 = FXGL.getAssetLoader().loadImage("ui/result/itemLevel0.png");
    private static final Image itemLevel1 = FXGL.getAssetLoader().loadImage("ui/result/itemLevel1.png");
    private static final Image itemLevel2 = FXGL.getAssetLoader().loadImage("ui/result/itemLevel2.png");
    private static final Image itemLevel3 = FXGL.getAssetLoader().loadImage("ui/result/itemLevel3.png");
    private static final Image itemLevel4 = FXGL.getAssetLoader().loadImage("ui/result/itemLevel4.png");
    private static final Image itemLevel5 = FXGL.getAssetLoader().loadImage("ui/result/itemLevel5.png");
    private static final Image itemLevel6 = FXGL.getAssetLoader().loadImage("ui/result/itemLevel6.png");
    private static final Image itemLevel7 = FXGL.getAssetLoader().loadImage("ui/result/itemLevel7.png");
    private static final Image itemLevel8 = FXGL.getAssetLoader().loadImage("ui/result/itemLevel8.png");

    public static void createUpgradeOption(WeaponData id, AnchorPane buttonView) {
        buttonView.getChildren().clear();
        ImageView background = new ImageView(upgradeChoice);
        ImageView skillIcon = new ImageView(WeaponHelper.getIcon(id.getId()));
        Button button = new Button();
        Label skillName = new Label(id.getName());
        Label skillDesc = new Label(id.getBaseDesc());

        button.setOnAction(event -> {
            ReferenceHelper.getPlayerComponent().giveWeapon(id.getComponentSupplier().get());
            UIManager.hindLevelUpUI();
            UIManager.updateInventory();
            FXGL.getWorldProperties().setValue("isPaused", false);
        });

        buttonView.getChildren().addAll(background, skillIcon, skillName, skillDesc, button);

        button.setLayoutX(0);
        button.setLayoutY(0);
        button.setPrefSize(128, 196);

        buttonView.setPrefSize(128, 196);

        // some constant for alignment
        background.setLayoutX(0);
        background.setLayoutY(0);
        background.setFitWidth(upgradeChoice.getWidth() / 2);
        background.setFitHeight(upgradeChoice.getHeight() / 2);

        skillIcon.setLayoutX(48);
        skillIcon.setLayoutY(16);

        skillName.getStyleClass().add("skillName");
        skillName.setFont(FontHelper.alagard(13));
        skillName.setLayoutX(16);
        skillName.setLayoutY(64);

        skillDesc.getStyleClass().add("skillDesc");
        skillDesc.setFont(FontHelper.alagard(7));
        skillDesc.setLayoutX(16);
        skillDesc.setLayoutY(96);
    }

    public static Image getItemFrame(int level) {
        return switch (level) {
            case 0 -> itemFrame0;
            case 1 -> itemFrame1;
            case 2 -> itemFrame2;
            case 3 -> itemFrame3;
            case 4 -> itemFrame4;
            case 5 -> itemFrame5;
            case 6 -> itemFrame6;
            case 7 -> itemFrame7;
            case 8 -> itemFrame8;
            default -> null;
        };
    }

    public static Image getItemLevelDiamond(int level) {
        return switch (level) {
            case 0 -> itemLevel0;
            case 1 -> itemLevel1;
            case 2 -> itemLevel2;
            case 3 -> itemLevel3;
            case 4 -> itemLevel4;
            case 5 -> itemLevel5;
            case 6 -> itemLevel6;
            case 7 -> itemLevel7;
            case 8 -> itemLevel8;
            default -> null;
        };
    }


    public static String getRomanNumber(int number) {
        return switch (number) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            default -> "";
        };
    }


    public static double getLayoutX(int number) {
        return switch (number) {
            case 1 -> 21.9;
            case 2 -> 21;
            case 3 -> 19.6;
            case 4 -> 21.2;
            case 5 -> 21.9;
            case 6 -> 20.9;
            case 7 -> 20.2;
            default -> 19;
        };
    }

    public static String numberFormatting(int number) {
        if (number >= 1_000_000_000) {
            return number / 1_000_000_000 + "." +  (number % 1_000_000_000) / 1_000_000 + "B";
        } else if (number >= 1_000_000) {
            return number / 1_000_000 + "." + (number % 1_000_000) / 1_000 + "M";
        } else if (number >= 1_000) {
            return number / 1_000 +  "." + (number % 1_000) + "K";
        }
        else {
            return String.valueOf(number);
        }
    }
}
