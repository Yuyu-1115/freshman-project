package org.ncu.fresh.core.entity.component.attack.animation;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.geometry.Point2D;
import javafx.util.Duration;
import org.ncu.fresh.core.entity.EntityType;

public class NormalProjectileAnimationComponent extends Component {
    private final AnimatedTexture texture;
    private final AnimationChannel animNorm, animOnHit;
    private boolean isHit = false;

    /*
    Load the asset
     */
    public NormalProjectileAnimationComponent(String assetName, int normFrame, int onHitFrame) {
        animNorm = new AnimationChannel(FXGL.image(assetName), normFrame + onHitFrame, 16, 16, Duration.seconds(0.25), 0, normFrame - 1);
        animOnHit = new AnimationChannel(FXGL.image(assetName), normFrame + onHitFrame, 16, 16, Duration.seconds(0.25), normFrame, normFrame + onHitFrame - 1);
        texture = new AnimatedTexture(animNorm);
    }

    /*
    Bind the asset to the entity, we do it here because entities are determined only after the component are added
     */
    @Override
    public void onAdded() {
        entity.setScaleOrigin(new Point2D(8, 8));
        entity.getViewComponent().addChild(texture);
        texture.loopAnimationChannel(animNorm);
        /*
        remove the projectile from world only if:
        - 1. The projectile is not piercing
        - 2. the projectile finish its on-hit animation
         */
        texture.setOnCycleFinished(() -> {
            if (isHit) {
                if (entity.getType().equals(EntityType.PROJECTILE)) {
                    entity.removeFromWorld();
                }
                else {
                    isHit = false;
                }
            }
        });
    }

    /*
    play on hit animation
     */
    public void onHit() {
        isHit = true;
        texture.loopNoOverride(animOnHit);
    }
}
