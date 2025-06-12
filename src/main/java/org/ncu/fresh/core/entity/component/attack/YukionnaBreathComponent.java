package org.ncu.fresh.core.entity.component.attack;

import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.component.attack.base.KnotProjectileComponent;
import org.ncu.fresh.core.utils.WeaponHelper;

public class YukionnaBreathComponent extends KnotProjectileComponent {
    public YukionnaBreathComponent() {
        super(WeaponHelper.getAssetName("yukionnaBreath"), 16, 10, 120, false, 0.1);
    }

    @Override
    public void levelUp() {
        level += 1;
        damage += 2;
    }

    @Override
    public WeaponData getWeaponData() {
        return WeaponData.YUKIONNA_BREATH;
    }
}
