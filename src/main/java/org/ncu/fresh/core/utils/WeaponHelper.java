package org.ncu.fresh.core.utils;

import java.util.ResourceBundle;

public class WeaponHelper {
    private static final ResourceBundle description = ResourceBundle.getBundle("description.weapon_description");

    public static String getWeaponName(String id) {
        return description.getString("weapon." + id + ".name");
    }

    public static String getWeaponShortDesc(String id) {
        return description.getString("weapon." + id + ".shortDesc");
    }

    public static String getWeaponLongDesc(String id) {
        return description.getString("weapon." + id + ".longDesc");
    }

    public static String getAssetName(String id) {
        return "projectile/" + id + ".png";
    }
}
