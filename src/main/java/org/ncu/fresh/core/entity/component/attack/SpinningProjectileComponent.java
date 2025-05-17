package org.ncu.fresh.core.entity.component.attack;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import org.ncu.fresh.core.entity.factory.ProjectileFactory;

import java.util.ArrayList;

public class SpinningProjectileComponent extends Component {
    /*
    This Component create projectiles that rotates around the entity it attaches to
     */
    private final ArrayList<Entity> projectileList = new ArrayList<>();
    private int projectileNumber;
    private double rotationSpeed;
    private double radius;
    private int damage;
    private double angle = 0;

    public SpinningProjectileComponent(int projectileNumber, int damage, double rotationSpeed, double radius) {
        this.projectileNumber = projectileNumber;
        this.rotationSpeed = rotationSpeed;
        this.radius = radius;
        this.damage = damage;
    }

    @Override
    public void onAdded() {
        for (int i = 0; i < projectileNumber; i++) {
            projectileList.add(ProjectileFactory.createRotatingProjectile(entity.getPosition(), damage, rotationSpeed, 5, true));
        }
    }

    @Override
    public void onUpdate(double tpf) {
        angle = (angle + rotationSpeed * tpf) % (Math.PI * 2);
        double diff = Math.PI * 2 / projectileNumber;
        Point2D center = entity.getCenter();
        for (int i = 0; i < projectileNumber; i++) {
            projectileList.get(i).setPosition(center.getX() + radius * Math.cos(angle + diff * i), center.getY() + radius * Math.sin(angle + diff * i));
        }
    }
}
