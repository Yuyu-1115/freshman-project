package org.ncu.fresh.core.entity.component.attack;

import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.component.attack.base.SpinningProjectileComponent;
import org.ncu.fresh.core.utils.WeaponHelper;

import static org.ncu.fresh.core.constant.Constant.TILE_SIZE;

public class InfernalWheelComponent extends SpinningProjectileComponent {
    public InfernalWheelComponent() {
        super(WeaponHelper.getAssetName("infernalWheel"), 3, 20, 0.8, 2 * TILE_SIZE);
    }

    @Override
    public WeaponData getWeaponData() {
        return WeaponData.INFERNAL_WHEEL;
    }

    @Override
    public void levelUp() {
        level += 1;
        projectileNumber += 1;
        reinitializeProjectile();
    }
}
