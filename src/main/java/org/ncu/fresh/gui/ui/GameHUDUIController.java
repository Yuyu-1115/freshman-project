package org.ncu.fresh.gui.ui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.ui.UIController;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.ncu.fresh.core.constant.Color;
import org.ncu.fresh.core.constant.Constant;
import org.ncu.fresh.core.entity.component.attack.base.Weapon;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.core.utils.WeaponHelper;
import org.ncu.fresh.gui.utils.FontHelper;
import org.ncu.fresh.gui.utils.UIHelper;

import java.util.ArrayList;
import java.util.List;

public class GameHUDUIController implements UIController {
    @FXML private ImageView hpBackground;
    @FXML private ImageView xpBackground;
    @FXML private ImageView hpFill;
    @FXML private ImageView xpFill;
    @FXML private Text level;
    @FXML private Text username;

    @FXML private ImageView weaponSlot0;
    @FXML private ImageView weaponSlot1;
    @FXML private ImageView weaponSlot2;
    @FXML private ImageView weaponSlot3;
    @FXML private ImageView weaponSlot4;
    @FXML private ImageView weaponSlot5;

    @FXML private ImageView weapon0;
    @FXML private ImageView weapon1;
    @FXML private ImageView weapon2;
    @FXML private ImageView weapon3;
    @FXML private ImageView weapon4;
    @FXML private ImageView weapon5;

    @FXML private Label weaponLevel0;
    @FXML private Label weaponLevel1;
    @FXML private Label weaponLevel2;
    @FXML private Label weaponLevel3;
    @FXML private Label weaponLevel4;
    @FXML private Label weaponLevel5;

    @FXML private Label killCount;
    @FXML private Label surviveTime;



    private final List<ImageView> weaponList = new ArrayList<>();

    private final List<ImageView> weaponSlotList = new ArrayList<>();

    private final List<Label> weaponLevelList = new ArrayList<>();

    public void updateBar(double hpPercent, double xpPercent) {

        // the viewpoint won't be effective if we pass a zero width/height rectangle, so we deliberately add one that it won't affect the display
        // while if fixes the xp bar issue
        if (hpPercent > 0) {
            hpFill.setViewport(new Rectangle2D(0, 0, hpFill.getImage().getWidth() * hpPercent, hpFill.getImage().getHeight()));
        }
        else {
            hpFill.setViewport(new Rectangle2D(0, 0, 1, 1));
        }
        if (xpPercent > 0) {
            xpFill.setViewport(new Rectangle2D(0, 0, xpFill.getImage().getWidth() * xpPercent, xpFill.getImage().getHeight()));
        }
        else {
            xpFill.setViewport(new Rectangle2D(0, 0, 1, 1));
        }


        if (hpPercent <= 0.2) {
            hpFill.setEffect(Color.HP_RED);
        }
        else if (hpPercent <= 0.5) {
            hpFill.setEffect(Color.HP_YELLOW);
        }
        else {
            hpFill.setEffect(null);
        }
    }

    public void levelUp(int currLevel) {
        ColorAdjust colorAdjust = new ColorAdjust();
        xpFill.setEffect(colorAdjust);
        FXGL.animationBuilder()
                .repeat(10)
                .autoReverse(true)
                .duration(Duration.millis(100))
                .animate(colorAdjust.hueProperty())
                .from(0)
                .to(1)
                .buildAndPlay();
        xpFill.setEffect(null);
        level.setText("Lv." + currLevel);
    }

    public void toggleInfo() {
        ImageView[] array = new ImageView[]{hpBackground, xpBackground, hpFill, xpFill};
        for (int i = 0; i < 4; i++) {
            array[i].setVisible(!array[i].isVisible());
        }
        level.setVisible(!level.isVisible());
        username.setVisible(!username.isVisible());
    }

    public void updateInventory() {
        List<Component> weaponDataList = ReferenceHelper.getPlayerComponent().getWeaponOwned().stream().toList();

        if (weaponList.isEmpty() || weaponSlotList.isEmpty()) {
            initializeCollection(weaponList, weapon0, weapon1, weapon2, weapon3, weapon4, weapon5);
            initializeCollection(weaponSlotList, weaponSlot0, weaponSlot1, weaponSlot2, weaponSlot3, weaponSlot4, weaponSlot5);
            initializeCollection(weaponLevelList, weaponLevel0, weaponLevel1, weaponLevel2, weaponLevel3, weaponLevel4, weaponLevel5);

            for (int i = 0; i < 6; i++) {
                weaponLevelList.get(i).setFont(FontHelper.shareTechMono(5));
            }
        }

        updateSlot(weaponDataList, weaponList, weaponSlotList);
        updateLevel(weaponDataList, weaponLevelList);
    }

    private void updateSlot(List<Component> componentList, List<ImageView> iconList, List<ImageView> slotList) {
        for (int i = 0; i < 6; i++) {
            if (i >= componentList.size()) {
                iconList.get(i).setImage(null);
                slotList.get(i).setImage(UIHelper.getItemFrame(0));
                continue;
            }
            Weapon weapon = (Weapon) componentList.get(i);
            iconList.get(i).setImage(WeaponHelper.getIcon(weapon.getWeaponData().getId()));
            slotList.get(i).setImage(UIHelper.getItemFrame(weapon.getLevel()));
            if (weapon.getLevel() == 8) {
                if (i < 3) {
                    iconList.get(i).setLayoutY(280);
                }
                else {
                    iconList.get(i).setLayoutY(324);
                }
            }
        }
    }

    private void updateLevel(List<Component> componentList, List<Label> levelList) {
        for (int i = 0; i < 6; i++) {
            if (i >= componentList.size()) {
                levelList.get(i).setText(null);
                continue;
            }
            Weapon weapon = (Weapon) componentList.get(i);
            int level = weapon.getLevel();
            levelList.get(i).setText(UIHelper.getRomanNumber(level));
            levelList.get(i).setLayoutX(UIHelper.getLayoutX(level) + 40 * (i % 3));
        }
    }

    private void initializeCollection(List<ImageView> list, ImageView... views) {
        list.addAll(List.of(views));
    }

    private void initializeCollection(List<Label> list, Label... views) {
        list.addAll(List.of(views));
    }

    public void updateKillCount(int count) {
        killCount.setText(String.valueOf(count));
    }

    public void updateSurviveTime(int count) {
        surviveTime.setText(count / 60 + ":" + count % 60);
    }

    public void updateUsername() {
        username.setText(FXGL.getWorldProperties().getString(Constant.USERNAME));
    }

    @Override
    public void init() {
        level.setFont(FontHelper.alagard(24));
        username.setFont(FontHelper.alagard(18));
        killCount.setFont(FontHelper.alagard(14));
        updateKillCount(0);
    }
}
