package org.ncu.fresh.core.entity.component.attack.base;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import org.ncu.fresh.core.constant.Constant;
import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.factory.ProjectileFactory;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;

public abstract class KnotProjectileComponent extends Component implements Weapon{
    private final String assetName;
    protected int direction;
    protected int level = 1;
    protected int damage;
    protected double speed;
    protected boolean isPiercing;
    protected double cooldown;

    private double currentDirection = 0;
    private double attackTimer = 0;

    public abstract void levelUp();
    public abstract WeaponData getWeaponData();

    @Override
    public int getLevel() {
        return level;
    }

    public KnotProjectileComponent(String assetName, int direction, int damage, double speed, boolean isPiercing, double cooldown) {
        this.assetName = assetName;
        this.direction = direction;
        this.damage = damage;
        this.speed = speed;
        this.isPiercing = isPiercing;
        this.cooldown = cooldown;
    }

    @Override
    public void onUpdate(double tpf) {
        if (FXGL.getWorldProperties().getBoolean(Constant.IS_PAUSED)) {
            return;
        }
        if (attackTimer <= 0) {
            ProjectileFactory.createOnHitProjectile(
                    assetName,
                    4,
                    ReferenceHelper.getPlayer().getCenter().add(Constant.TILE_SIZE * Math.cos(currentDirection), Constant.TILE_SIZE * Math.sin(currentDirection)),
                    new Point2D(Math.cos(currentDirection), Math.sin(currentDirection)),
                    damage,
                    speed,
                    5,
                    isPiercing,
                    getWeaponData()
            );
            attackTimer = cooldown;
            currentDirection = (currentDirection + Math.PI * 2 / direction ) % (Math.PI * 2);
        }
        else {
            attackTimer -= tpf;
        }
    }
}
