package org.ncu.fresh.core.entity.component.attack;

import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.component.attack.base.KnotProjectileComponent;
import org.ncu.fresh.core.utils.WeaponHelper;

public class ArtemisCrescentComponent extends KnotProjectileComponent {
    public ArtemisCrescentComponent() {
        super(WeaponHelper.getAssetName("artemisCrescent"), 8, 20, 100, false, 0.2);
    }

    @Override
    public void levelUp() {
        level += 1;
        damage += 4;
    }

    @Override
    public WeaponData getWeaponData() {
        return WeaponData.ARTEMIS_CRESCENT;
    }
}
