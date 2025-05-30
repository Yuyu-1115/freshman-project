package org.ncu.fresh.core.entity.component.attack.base;

import org.ncu.fresh.core.constant.WeaponData;

public interface Weapon {
    /*
     * For every weapon, they have to scale in some way.
     * Also, we need a way to retrieve weaponData from component
     * The reason to implement the interface is to solve the problem of we can't inherent from the subclass of Component
     */
    void levelUp();
    int getLevel();
    WeaponData getWeaponData();
}
