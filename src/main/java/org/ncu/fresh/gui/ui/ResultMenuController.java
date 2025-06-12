package org.ncu.fresh.gui.ui;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.ui.UIController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import org.ncu.fresh.core.entity.component.attack.base.Weapon;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.core.handler.TimerHandler;
import org.ncu.fresh.core.utils.WeaponHelper;
import org.ncu.fresh.gui.utils.UIHelper;

import java.util.ArrayList;
import java.util.List;

public class ResultMenuController implements UIController {
    @FXML private ImageView weapon0;
    @FXML private ImageView weapon1;
    @FXML private ImageView weapon2;
    @FXML private ImageView weapon3;
    @FXML private ImageView weapon4;
    @FXML private ImageView weapon5;

    @FXML private Text weaponName0;
    @FXML private Text weaponName1;
    @FXML private Text weaponName2;
    @FXML private Text weaponName3;
    @FXML private Text weaponName4;
    @FXML private Text weaponName5;

    @FXML private Label weaponDamage0;
    @FXML private Label weaponDamage1;
    @FXML private Label weaponDamage2;
    @FXML private Label weaponDamage3;
    @FXML private Label weaponDamage4;
    @FXML private Label weaponDamage5;


    @FXML private ImageView weaponDiamond0;
    @FXML private ImageView weaponDiamond1;
    @FXML private ImageView weaponDiamond2;
    @FXML private ImageView weaponDiamond3;
    @FXML private ImageView weaponDiamond4;
    @FXML private ImageView weaponDiamond5;


    @FXML private Label weaponLevel0;
    @FXML private Label weaponLevel1;
    @FXML private Label weaponLevel2;
    @FXML private Label weaponLevel3;
    @FXML private Label weaponLevel4;
    @FXML private Label weaponLevel5;

    private final ArrayList<ImageView> weaponList = new ArrayList<>();
    private final ArrayList<Text> weaponNameList = new ArrayList<>();
    private final ArrayList<Label> weaponDamageList = new ArrayList<>();
    private final ArrayList<ImageView> weaponDiamondList = new ArrayList<>();
    private final ArrayList<Label> weaponLevelList = new ArrayList<>();


    public void updateResult() {
        if (weaponList.isEmpty() || weaponNameList.isEmpty() || weaponDamageList.isEmpty() || weaponDiamondList.isEmpty() || weaponLevelList.isEmpty()) {
            weaponList.addAll(List.of(weapon0, weapon1, weapon2, weapon3, weapon4, weapon5));
            weaponNameList.addAll(List.of(weaponName0, weaponName1, weaponName2, weaponName3, weaponName4, weaponName5));
            weaponDamageList.addAll(List.of(weaponDamage0, weaponDamage1, weaponDamage2, weaponDamage3, weaponDamage4, weaponDamage5));
            weaponDiamondList.addAll(List.of(weaponDiamond0, weaponDiamond1, weaponDiamond2, weaponDiamond3, weaponDiamond4, weaponDiamond5));
            weaponLevelList.addAll(List.of(weaponLevel0, weaponLevel1, weaponLevel2, weaponLevel3, weaponLevel4, weaponLevel5));
        }

        ArrayList<Component> buildList = ReferenceHelper.getPlayerComponent().getWeaponOwned();
        ArrayList<Integer> damageDealt = ReferenceHelper.getPlayerComponent().getDamageDealt();

        for (int i = 0; i < weaponList.size(); i++) {
            weaponList.get(i).setImage(null);
            weaponNameList.get(i).setText("");
            weaponDiamondList.get(i).setImage(null);
            weaponLevelList.get(i).setText("");
        }

        for (int i = 0; i < buildList.size(); i++) {
            weaponList.get(i).setImage(
                WeaponHelper.getIcon(
                    ((Weapon)buildList.get(i)).getWeaponData().getId()
                ));
            weaponNameList.get(i).setText(
                ((Weapon)buildList.get(i)).getWeaponData().getName()
            );


        }

        // TODO: Fix number display
        for (int i = 0; i < buildList.size(); i++) {
            int level = ((Weapon) buildList.get(i)).getLevel();
            weaponDiamondList.get(i).setImage(
                UIHelper.getItemLevelDiamond(level)
            );
            weaponLevelList.get(i).setText(
                    UIHelper.getRomanNumber(level)
            );
            weaponLevelList.get(i).setLayoutX(weaponLevel0.getLayoutX() - 19 + UIHelper.getLayoutX(level));
        }

        for (int i = 0; i < 6; i++) {
            if (i >= damageDealt.size()) {
                weaponDamageList.get(i).setText("");
                continue;
            }
            weaponDamageList.get(i).setText(UIHelper.numberFormatting(damageDealt.get(i) / TimerHandler.getGameTime()));
        }
    }

    @Override
    public void init() {

    }
}
