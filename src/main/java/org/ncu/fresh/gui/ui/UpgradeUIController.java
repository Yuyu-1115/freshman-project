package org.ncu.fresh.gui.ui;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.ui.UIController;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.ncu.fresh.core.entity.component.attack.base.Weapon;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.core.utils.RandomizationHelper;
import org.ncu.fresh.gui.utils.UIHelper;

import java.util.ArrayList;

public class UpgradeUIController implements UIController {

    @FXML AnchorPane option1;
    @FXML AnchorPane option2;
    @FXML AnchorPane option3;

    // TODO: Make it compatible with power-ups
    public void updateOption() {
        // First weapon
        if (ReferenceHelper.getPlayer().getComponent(LevelComponent.class).getLevel() == 1 || RandomizationHelper.getUpgradableComponent().isEmpty()) {
            ArrayList<Component> options = RandomizationHelper.rollNewWeapon(3);
            UIHelper.createUpgradeOption(((Weapon)options.get(0)).getWeaponData(), option1);
            UIHelper.createUpgradeOption(((Weapon)options.get(1)).getWeaponData(), option2);
            UIHelper.createUpgradeOption(((Weapon)options.get(2)).getWeaponData(), option3);
        }
        else if (RandomizationHelper.getUpgradableComponent().size() > 1 && FXGLMath.random(0, 1) == 0) {
            // check if there are upgradable options
            // if there are generate 1 upgrade option, 1 new weapon/power-up, the rest is completely random, with 50% of each.
            ArrayList<Component> options = RandomizationHelper.rollNewWeapon(2);
            UIHelper.createUpgradeOption(((Weapon)options.get(0)).getWeaponData(), option1);
            UIHelper.createUpgradeOption(((Weapon)RandomizationHelper.rollNewWeapon()).getWeaponData(), option2);
            UIHelper.createUpgradeOption(((Weapon)options.get(1)).getWeaponData(), option3);
        }
        else {
            // if there is only one upgradable option
            UIHelper.createUpgradeOption(((Weapon)RandomizationHelper.rollUpgradableWeapon()).getWeaponData(), option1);
            UIHelper.createUpgradeOption(((Weapon)RandomizationHelper.rollNewWeapon()).getWeaponData(), option2);
            UIHelper.createUpgradeOption(((Weapon)RandomizationHelper.rollNewWeapon()).getWeaponData(), option3);
        }
    }

    @Override
    public void init() {
    }
}
