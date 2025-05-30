package org.ncu.fresh.core.entity.component.attack.base;

import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import org.ncu.fresh.core.entity.factory.ProjectileFactory;

public abstract class NormalProjectileComponent extends Component implements Weapon{
    /*
    This abstract class will shoot bullet in projectiles direction.
    projectiles are distributed equally and are determined by the number of projectiles shown at the same time.
     */

    private final double ATTACK_COOLDOWN;
    private double currentCooldown = 0;

    public NormalProjectileComponent(double coolDown) {
        this.ATTACK_COOLDOWN = coolDown;
    }

    // TODO: make this more generalized so it can be used by subclasses, and possibly make it won't auto fire
    @Override
    public void onUpdate(double tpf) {
        if (currentCooldown > 0) {
            currentCooldown -= tpf;
        }
        else {
            attack();
        }
    }

    public final void attack() {
        if (currentCooldown <= 0) {
            for (int i = 0; i < 4; i++) {
                ProjectileFactory.createProjectile(
                        entity.getCenter(),
                        new Point2D(Math.cos(Math.PI * i / 2), -1 * Math.sin(Math.PI * i / 2)),
                        20,
                        20,
                        5,
                        Color.AZURE,
                        false);
            }
            currentCooldown = ATTACK_COOLDOWN;
        }
    }
}
