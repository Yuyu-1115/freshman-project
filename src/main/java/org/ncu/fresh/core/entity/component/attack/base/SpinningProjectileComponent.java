package org.ncu.fresh.core.entity.component.attack.base;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.factory.ProjectileFactory;

import java.util.ArrayList;

public abstract class SpinningProjectileComponent extends Component implements Weapon {
    /*
    This Component create projectiles that rotates around the entity it attaches to
     */
    private final ArrayList<Entity> projectileList = new ArrayList<>();
    protected double rotationSpeed;
    protected double radius;
    protected int projectileNumber;
    protected int damage;
    protected int level = 1;
    protected String assetName;

    private double angle = 0;

    /**
     *
     * @param assetName the name of the asset
     * @param projectileNumber the number of projectiles there
     * @param damage projectile damage
     * @param rotationSpeed the degree projectile rotate per frame
     * @param radius the distance from the projectile to the player
     */
    public SpinningProjectileComponent(String assetName, int projectileNumber, int damage, double rotationSpeed, double radius) {
        this.assetName = assetName;
        this.projectileNumber = projectileNumber;
        this.rotationSpeed = rotationSpeed;
        this.radius = radius;
        this.damage = damage;
    }



    /**
    * For every weapon, they have to scale in some way.
    * Also, we need a way to retrieve weaponData from component
    */
    public abstract void levelUp();
    public abstract WeaponData getWeaponData();
    public int getLevel() {
        return level;
    }

    @Override
    public final void onAdded() {
        for (int i = 0; i < projectileNumber; i++) {
            projectileList.add(ProjectileFactory.createRotatingProjectile(assetName, entity.getPosition(), damage, rotationSpeed, 5, true, getWeaponData()));
        }
    }


    /**
    * Keep the projectile rotating around the player
    * @param tpf time per frame
    */
    @Override
    public final void onUpdate(double tpf) {
        if (FXGL.getWorldProperties().getBoolean("isPaused")) {
            return;
        }
        angle = (angle + rotationSpeed * tpf) % (Math.PI * 2);
        double diff = Math.PI * 2 / projectileNumber;
        Point2D center = entity.getCenter();
        for (int i = 0; i < projectileNumber; i++) {
            projectileList.get(i).setPosition(center.getX() + radius * Math.cos(angle + diff * i) - 8, center.getY() + radius * Math.sin(angle + diff * i) - 8);
        }
    }



    protected void reinitializeProjectile() {
        for (var proj: projectileList) {
            proj.removeFromWorld();
        }
        projectileList.clear();
        for (int i = 0; i < projectileNumber; i++) {
            projectileList.add(ProjectileFactory.createRotatingProjectile(assetName, entity.getPosition(), damage, rotationSpeed, 5, true, getWeaponData()));
        }
    }

}
