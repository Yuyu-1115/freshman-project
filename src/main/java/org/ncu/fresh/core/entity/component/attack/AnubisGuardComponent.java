package org.ncu.fresh.core.entity.component.attack;

import javafx.geometry.Point2D;
import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.component.attack.base.BezierProjectileComponent;
import org.ncu.fresh.core.utils.WeaponHelper;

import static org.ncu.fresh.core.constant.Constant.TILE_SIZE;

public class AnubisGuardComponent extends BezierProjectileComponent {
    public AnubisGuardComponent() {
        super(WeaponHelper.getAssetName("anubisGuard"), 15, 8, 4 * TILE_SIZE, 2, new Point2D(0, 0), new Point2D(20, 10), new Point2D(10, 20), new Point2D(0, 0));
    }

    @Override
    public void levelUp() {
        level += 1;
        damage += 5;
    }

    @Override
    public WeaponData getWeaponData() {
        return WeaponData.ANUBIS_GUARD;
    }
}
