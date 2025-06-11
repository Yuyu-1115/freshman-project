package org.ncu.fresh.core.utils;

import com.almasb.fxgl.dsl.FXGL;
import javafx.scene.image.Image;

import java.util.ResourceBundle;

public class WeaponHelper {
    private static final ResourceBundle description = ResourceBundle.getBundle("description.weapon_description");

    public static String getWeaponName(String id) {
        return description.getString("weapon." + id + ".name");
    }

    public static String getWeaponUpgradeDesc(String id) {
        return description.getString("weapon." + id + ".upgradeDesc");
    }

    public static String getWeaponBaseDesc(String id) {
        return description.getString("weapon." + id + ".baseDesc");
    }

    public static String getAssetName(String id) {
        return "projectile/" + id + ".png";
    }

    public static Image getIcon(String id) {
        return FXGL.getAssetLoader().loadImage("icon/" + id + ".png");
    }
}
