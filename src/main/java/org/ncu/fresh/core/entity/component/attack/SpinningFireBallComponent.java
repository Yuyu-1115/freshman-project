package org.ncu.fresh.core.entity.component.attack;

import org.ncu.fresh.core.entity.component.attack.base.SpinningProjectileComponent;

import static org.ncu.fresh.core.constant.ApplicationConfig.TILE_SIZE;
import static org.ncu.fresh.core.constant.weapon.WeaponId.SPINNING_FIREBALL;

public class SpinningFireBallComponent extends SpinningProjectileComponent {
    public SpinningFireBallComponent() {
        super(SPINNING_FIREBALL.getAssetName(), 3, 20, 0.8, 2 * TILE_SIZE);
    }

    @Override
    public void levelUp() {
        level += 1;
        damage += 10;
    }
}
