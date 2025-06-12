package org.ncu.fresh.core.utils;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.component.Component;
import org.jetbrains.annotations.NotNull;
import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.component.attack.base.Weapon;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;

import java.util.ArrayList;
import java.util.List;

public class RandomizationHelper {
    public static ArrayList<Component> rollNewWeapon(int count) {
        ArrayList<Component> availableNewWeapon = getAvailableNewWeapon();
        ArrayList<Component> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int index = FXGLMath.random(0, availableNewWeapon.size() - 1);
            result.add(availableNewWeapon.get(index));
            availableNewWeapon.remove(index);
        }
        return result;
    }

    public static ArrayList<Component> rollUpgradableWeapon(int count) {
        ArrayList<Component> upgradableWeapon = getUpgradableComponent();
        ArrayList<Component> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int index = FXGLMath.random(0, upgradableWeapon.size() - 1);
            result.add(upgradableWeapon.get(index));
            upgradableWeapon.remove(index);
        }
        return result;
    }

    public static Component rollUpgradableWeapon() {
        return getUpgradableComponent().get(FXGLMath.random(0, getUpgradableComponent().size() - 1));
    }
    @NotNull
    private static ArrayList<Component> getAvailableNewWeapon() {
        ArrayList<Component> candidateList = new ArrayList<>();
        List<Component> currentWeapon = ReferenceHelper.getPlayerComponent().getWeaponOwned();
        for (var weaponData: WeaponData.values()) {
            boolean duplicate = false;
            Component weapon = weaponData.getComponentSupplier().get();
            for (var currWeapon: currentWeapon) {
                if (weapon.getClass() == currWeapon.getClass()) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                candidateList.add(weapon);
            }
        }
        return candidateList;
    }


    @NotNull
    public static ArrayList<Component> getUpgradableComponent() {
        ArrayList<Component> candidateList = new ArrayList<>();
        for (var candidate: ReferenceHelper.getPlayerComponent().getWeaponOwned()) {
            if (((Weapon)candidate).getLevel() < 8) {
               candidateList.add(candidate);
            }
        }
        return candidateList;
    }
}
