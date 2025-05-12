package org.ncu.fresh.core.entity.component.player;

import com.almasb.fxgl.animation.AnimationBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.ncu.fresh.core.constant.Color;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.factory.ResourceBarFactory;

public class StatusBarComponent extends Component {
    private static final int HP_X_START = 42 * 2;
    private static final int HP_Y_START = 18 * 2;

    private static final int XP_X_START = 43 * 2;
    private static final int XP_Y_START = 32 * 2;

    private static ImageView backgroundView = FXGL.texture("statBarBg.png");
    private ImageView hpFill = FXGL.texture("statBarHPFill.png");
    private ImageView expFill = FXGL.texture("statBarXPFill.png");

    private Entity background;
    private Entity healthBar;
    private Entity experienceBar;


    @Override
    public void onAdded() {
        background = FXGL.entityBuilder()
                .type(EntityType.DISPLAY)
                .view(backgroundView)
                .at(0, 0, 0)
                .buildAndAttach();
        healthBar = ResourceBarFactory.createHealthBar(new Point2D(HP_X_START, HP_Y_START), hpFill);
        experienceBar = ResourceBarFactory.createHealthBar(new Point2D(XP_X_START, XP_Y_START), expFill);
        expFill.setViewport(new Rectangle2D(0, 0, 0, 0));

    }

    @Override
    public void onUpdate(double tpf) {
        double hpPercent = entity.getComponent(HealthDoubleComponent.class).getValuePercent() / 100.0;
        double xpPercent = entity.getComponent(LevelComponent.class).getExpProgressPercent() / 100.0;

        hpFill.setViewport(new Rectangle2D(0, 0, hpFill.getImage().getWidth() * hpPercent, HP_Y_START + hpFill.getFitHeight()));
        expFill.setViewport(new Rectangle2D(0, 0, expFill.getImage().getWidth() * xpPercent, XP_Y_START + hpFill.getFitHeight()));


        if (hpPercent <= 0.2) {
            hpFill.setEffect(Color.HP_RED);
        }
        else if (hpPercent <= 0.5) {
            hpFill.setEffect(Color.HP_YELLOW);
        }
        else {
            hpFill.setEffect(null);
        }
    }

    public void levelUp() {
        ColorAdjust colorAdjust = new ColorAdjust();
        expFill.setEffect(colorAdjust);
        FXGL.animationBuilder()
                .repeat(10)
                .autoReverse(true)
                .duration(Duration.millis(100))
                .animate(colorAdjust.hueProperty())
                .from(0)
                .to(1)
                .buildAndPlay();
        expFill.setEffect(null);
    }
}
