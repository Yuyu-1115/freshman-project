package org.ncu.fresh.core.entity.component.player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;
import org.ncu.fresh.core.constant.Constant;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.gui.UIManager;

import static org.ncu.fresh.core.constant.Constant.TILE_SIZE;

public class PlayerAnimationComponent extends Component {
    private final AnimatedTexture texture;
    private final AnimationChannel animMove, animDie;
    private boolean died = false;

    public PlayerAnimationComponent() {
        animMove = new AnimationChannel(FXGL.image("entity/characterMove.png"), 8, TILE_SIZE * 2, TILE_SIZE * 2, Duration.seconds(1), 0, 7);
        animDie = new AnimationChannel(FXGL.image("entity/characterDied.png"), 8, TILE_SIZE * 2, TILE_SIZE * 2, Duration.seconds(1), 0, 7);
        texture = new AnimatedTexture(animMove);
        texture.setTranslateX(-TILE_SIZE);
        texture.setTranslateY(-TILE_SIZE);
    }

    @Override
    public void onAdded() {
        entity.getViewComponent().addChild(texture);
        texture.loopAnimationChannel(animMove);

        texture.setOnCycleFinished(() -> {
            if (died) {
                UIManager.showResult();
                FXGL.getGameController().pauseEngine();
                FXGL.getWorldProperties().setValue(Constant.IS_PAUSED, true);
                ReferenceHelper.getPlayer().setVisible(false);
            }
            if (ReferenceHelper.getPlayer().getComponent(HealthDoubleComponent.class).isZero()) {
                died = true;
                texture.loopNoOverride(animDie);
            }
        });
    }
}
