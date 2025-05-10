package org.ncu.fresh.core.entity.component;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.factory.ProjectileFactory;

public class BasicAttackComponent extends Component {

    private final double ATTACK_COOLDOWN = 1.5;
    private double currentCooldown = 0;
    private Color color;

    public BasicAttackComponent(Color color) {
        this.color = color;
    }

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
                assert entity.getType().getClass() == EntityType.class;
                Entity projectile = ProjectileFactory.createBullet(
                        entity.getCenter(),
                        new Point2D(Math.cos(Math.PI * i / 2), -1 * Math.sin(Math.PI * i / 2)),
                        20,
                        20,
                        5,
                        (EntityType) entity.getType(),
                        color);
                FXGL.getGameWorld().addEntity(projectile);
            }
            currentCooldown = ATTACK_COOLDOWN;
        }
    }
}
