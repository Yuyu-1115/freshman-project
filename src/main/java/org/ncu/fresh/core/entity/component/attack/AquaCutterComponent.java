package org.ncu.fresh.core.entity.component.attack;

import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.component.attack.base.SpinningProjectileComponent;
import org.ncu.fresh.core.utils.WeaponHelper;

import static org.ncu.fresh.core.constant.Constant.TILE_SIZE;

public class AquaCutterComponent extends SpinningProjectileComponent {
    public AquaCutterComponent() {
        super(WeaponHelper.getAssetName("aquaCutter"), 4, 8, 0.6, 4 * TILE_SIZE);
    }

    @Override
    public WeaponData getWeaponData() {
        return WeaponData.AQUA_CUTTER;
    }

    @Override
    public void levelUp() {
        level += 1;
        damage += 8;
        reinitializeProjectile();
    }
}
