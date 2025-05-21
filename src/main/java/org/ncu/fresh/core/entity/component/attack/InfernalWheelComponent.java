package org.ncu.fresh.core.entity.component.attack;

import org.ncu.fresh.core.entity.component.attack.base.SpinningProjectileComponent;

import static org.ncu.fresh.core.constant.Constant.TILE_SIZE;
import static org.ncu.fresh.core.constant.weapon.WeaponId.INFERNAL_WHEEL;

public class InfernalWheelComponent extends SpinningProjectileComponent {
    public InfernalWheelComponent() {
        super(INFERNAL_WHEEL.getAssetName(), 3, 20, 0.8, 2 * TILE_SIZE);
    }

    @Override
    public void levelUp() {
        level += 1;
        damage += 10;
    }
}
