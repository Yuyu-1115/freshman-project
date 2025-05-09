package org.ncu.fresh.core.entity.component;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import org.ncu.fresh.core.entity.factory.ProjectileFactory;

public class BasicAttackComponent extends Component {

    private final double ATTACK_COOLDOWN = 1.5;
    private double currentCooldown = 0;


    @Override
    public void onUpdate(double tpf) {
        if (currentCooldown > 0) {
            currentCooldown -= tpf;
        }
        else {
            attack();
        }
    }

    public void attack() {
        if (currentCooldown <= 0) {
            for (int i = 0; i < 4; i++) {
                Entity projectile = ProjectileFactory.createProjectile(entity.getCenter(), new Point2D(Math.cos(Math.PI * i / 2), -1 * Math.sin(Math.PI * i / 2)));
                getEntity().getWorld().addEntity(projectile);
            }
            currentCooldown = ATTACK_COOLDOWN;
        }
    }
}
