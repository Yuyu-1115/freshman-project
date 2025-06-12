package org.ncu.fresh.core.entity.component.attack;

import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.component.attack.base.SpinningProjectileComponent;
import org.ncu.fresh.core.utils.WeaponHelper;

import static org.ncu.fresh.core.constant.Constant.TILE_SIZE;

public class WindBladeComponent extends SpinningProjectileComponent {
    public WindBladeComponent() {
        super(WeaponHelper.getAssetName("windBlade"), 2, 12, 2, 5 * TILE_SIZE);
    }

    @Override
    public WeaponData getWeaponData() {
        return WeaponData.WIND_BLADE;
    }

    @Override
    public void levelUp() {
        level += 1;
        damage += 12;
        reinitializeProjectile();
    }
}
