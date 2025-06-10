package org.ncu.fresh.core.entity.component.attack;

import javafx.geometry.Point2D;
import org.ncu.fresh.core.constant.Constant;
import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.component.attack.base.BezierProjectileComponent;
import org.ncu.fresh.core.utils.WeaponHelper;

public class TestComponent extends BezierProjectileComponent {
    public TestComponent() {
        super(WeaponHelper.getAssetName("infernalWheel"), 20, 5, Constant.TILE_SIZE, 2, new Point2D(0, 0), new Point2D(60, 20), new Point2D(60, 60), new Point2D(20, 120));
    }

    @Override
    public WeaponData getWeaponData() {
        return null;
    }

    @Override
    public void levelUp() {
        level += 1;
        damage += 2;
        projectileNumber += 1;
        reinitializeProjectile();
    }
}
