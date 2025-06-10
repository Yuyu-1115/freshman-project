package org.ncu.fresh.core.entity.component;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.effect.ColorAdjust;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;

import java.util.List;

import static org.ncu.fresh.core.constant.Constant.TILE_SIZE;

public class EnemyComponent extends Component {
    private final ColorAdjust colorAdjust = new ColorAdjust();
    private final double speed;

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

        // boids algorithm - separation
        Point2D velocity = ReferenceHelper.getPlayer().getPosition().subtract(entity.getPosition()).normalize();
        Point2D rangePosition = getEntity().getCenter().add(-(double) TILE_SIZE, -(double) TILE_SIZE);
        List<Entity> neighbours = FXGL.getGameWorld().getEntitiesInRange(new Rectangle2D(rangePosition.getX(), rangePosition.getY(), 2 * (double) TILE_SIZE, 2 * (double) TILE_SIZE));
        System.out.println(neighbours.size());
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
        Point2D finalDirection = velocity.multiply(0.1).add(weightedRepulsion.multiply(2)).normalize();

        getEntity().setPosition(getEntity().getPosition().add(finalDirection.multiply(speed * tpf)));
    }


    public void onHit() {

    }
}
