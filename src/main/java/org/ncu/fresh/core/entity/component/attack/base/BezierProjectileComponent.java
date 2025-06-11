package org.ncu.fresh.core.entity.component.attack.base;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.factory.ProjectileFactory;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;

import java.util.ArrayList;
import java.util.function.Function;

public abstract class BezierProjectileComponent extends Component implements Weapon {
    private final ArrayList<Entity> projectileList = new ArrayList<>();
    private final Function<Double, Point2D> curveSupplier;
    protected double traverseTime;
    protected double radius;
    protected int projectileNumber;
    protected int damage;
    protected int level = 1;
    protected String assetName;

    private double currTime = 0;
    private boolean positive = true;


    @Override
    public abstract WeaponData getWeaponData();
    @Override
    public abstract void levelUp();

    /*
       Take 4 point as input, will use the Bézier curve generated as the trail
       The radius means how far the starting point will be from the player.
        */
    public BezierProjectileComponent(String assetName, int damage, int projectileNumber, double radius, double traverseTime, Point2D point1, Point2D point2, Point2D point3, Point2D point4) {
        this.assetName = assetName;
        this.damage = damage;
        this.projectileNumber = projectileNumber;
        this.radius = radius;
        this.traverseTime = traverseTime;
        curveSupplier = t -> FXGLMath.bezier(point1, point2, point3, point4, t);
    }

    @Override
    public void onAdded() {
        for (int i = 0; i < projectileNumber; i++) {
            projectileList.add(ProjectileFactory.createRotatingProjectile(assetName, entity.getPosition(), damage, 0, 5, true));
        }
    }

    @Override
    public void onUpdate(double tpf) {
        if (FXGL.getWorldProperties().getBoolean("isPaused")) {
            return;
        }
        double diff = Math.PI * 2 / projectileNumber;
        Point2D center = ReferenceHelper.getPlayer().getCenter();
        // calculate T for the Bézier curve
        // hind the projectile once it reach its end
        // and show it when reset
        // this is an ugly approach, but it is what it is I guess
        if (positive) {
            currTime += tpf;
        }
        else {
            currTime -= tpf;
        }

        if (currTime >= traverseTime) {
            positive = false;
        }
        if (currTime <= 0) {
            positive = true;
        }

        for (int i = 0; i < projectileNumber; i++) {
            Point2D currPos = rotate(curveSupplier.apply(currTime / traverseTime), diff * i);
            Point2D position = center.add(radius * Math.cos(diff * i), radius * Math.sin(diff * i)).add(currPos);
            projectileList.get(i).setPosition(position);
        }
    }

    private Point2D rotate(Point2D point, double radians) {
        return new Point2D(point.getX() * Math.cos(radians) - point.getY() * Math.sin(radians), point.getX() * Math.sin(radians) + point.getY() * Math.cos(radians));
    }

    @Override
    public int getLevel() {
        return level;
    }

    protected void reinitializeProjectile() {
        for (var proj: projectileList) {
            proj.removeFromWorld();
        }
        projectileList.clear();
        for (int i = 0; i < projectileNumber; i++) {
            projectileList.add(ProjectileFactory.createRotatingProjectile(assetName, ReferenceHelper.getPlayer().getPosition(), damage, 0, 5, true));
        }
    }
}
