package org.ncu.fresh.core.entity.component;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.effect.ColorAdjust;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.event.PlayerEvent;

import java.util.ArrayList;
import java.util.List;

import static org.ncu.fresh.core.constant.Constant.TILE_SIZE;

public class EnemyComponent extends Component {
    private final ColorAdjust colorAdjust = new ColorAdjust();
    private final double speed;
    private final double attack = 1;
    private List<Entity> neighbours = new ArrayList<>();
    public static final double cacheTime = 0.5;
    public static final double attackTime = 0.1;
    private double refreshTimer = 0;
    private double attackTimer = 0;
    private boolean isAttacking = false;

    public EnemyComponent(double speed) {
        this.speed = speed;
    }

    @Override
    public void onUpdate(double tpf) {
        if (FXGL.getWorldProperties().getBoolean("isPaused")) {
            return;
        }
        // remove if too far from player to reduce lag
        if (ReferenceHelper.getPlayer().getPosition().distance(getEntity().getPosition()) > 1000) {
            entity.removeFromWorld();
            return;
        }

        if (isAttacking) {
            if (attackTimer >= attackTime) {
                FXGL.getEventBus().fireEvent(new PlayerEvent(PlayerEvent.DAMAGE, getEntity()));
                attackTimer = 0;
            }
            else {
                attackTimer += tpf;
                System.out.println("Attacking... timer: " + attackTimer);
            }
        }

        // boids algorithm - separation
        Point2D velocity = ReferenceHelper.getPlayer().getPosition().subtract(entity.getPosition()).normalize();
        Point2D rangePosition = getEntity().getCenter().add(-(double) TILE_SIZE, -(double) TILE_SIZE);
        // caching neighbours every 0.5 seconds so it won't lag the game
        if (refreshTimer <= 0) {
            neighbours = FXGL.getGameWorld().getEntitiesInRange(new Rectangle2D(rangePosition.getX(), rangePosition.getY(), 2 * (double) TILE_SIZE, 2 * (double) TILE_SIZE));
            refreshTimer = cacheTime;
        }
        else {
            refreshTimer -= tpf;
        }
        Point2D weightedRepulsion = Point2D.ZERO;
        for (Entity neighbour: neighbours) {
            // the weight is the reciprocals of the distance (1/L)
            // and the vector is the normalized version of the directional vector
            if (getEntity().distance(neighbour) == 0) {
                continue;
            }
            Point2D repulsionVector = getEntity().getCenter().add(neighbour.getCenter().multiply(-1)).normalize().multiply(1.0 / getEntity().distance(neighbour));
            weightedRepulsion = weightedRepulsion.add(repulsionVector);
        }
        // take the weighted sum and then normalize
        // TODO: the weight need to be adjusted more
        Point2D finalDirection = velocity.multiply(0.1).add(weightedRepulsion.multiply(1.8)).normalize();

        getEntity().setPosition(getEntity().getPosition().add(finalDirection.multiply(speed * tpf)));
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public void setAttacking(boolean attacking) {
        isAttacking = attacking;
    }

    public double getAttack() {
        return attack;
    }
}
