package org.ncu.fresh.core.entity.component.attack;

import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.component.attack.base.SpinningProjectileComponent;
import org.ncu.fresh.core.utils.WeaponHelper;

import static org.ncu.fresh.core.constant.Constant.TILE_SIZE;

public class ZoneOfRaComponent extends SpinningProjectileComponent {
    public ZoneOfRaComponent() {
        super(WeaponHelper.getAssetName("zoneOfRa"), 8, 2, 8, TILE_SIZE * 3.5);
    }

    @Override
    public void levelUp() {
        level += 1;
        damage += 1;

    }

    @Override
    public WeaponData getWeaponData() {
        return WeaponData.ZONE_OF_RA;
    }
}
