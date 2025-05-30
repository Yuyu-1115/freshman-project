package org.ncu.fresh.gui.ui;

import com.almasb.fxgl.ui.UIController;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.gui.utils.UIHelper;

public class UpgradeUIController implements UIController {

    @FXML AnchorPane option1;
    @FXML AnchorPane option2;
    @FXML AnchorPane option3;

    public void updateOption() {
        UIHelper.createUpgradeOption(WeaponData.AQUA_CUTTER, option1);
        UIHelper.createUpgradeOption(WeaponData.INFERNAL_WHEEL, option2);
        UIHelper.createUpgradeOption(WeaponData.WIND_BLADE, option3);
    }

    @Override
    public void init() {
    }
}
