package org.ncu.fresh.core.entity.component.resourcebar;


import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.factory.ResourceBarFactory;

public class ExperienceBarComponent extends Component {
    private Entity experienceBar;
    private final Entity background = FXGL.entityBuilder()
            .type(EntityType.DISPLAY)
            .at(195, 0)
            .view(new Rectangle(410, 50, Color.LIGHTGRAY))
            .buildAndAttach();

    @Override
    public void onAdded() {
        experienceBar = ResourceBarFactory.createExperienceBar(new Point2D(200, 5));
        experienceBar.setScaleX(0);
        FXGL.getGameWorld().addEntity(experienceBar);
    }

    @Override
    public void onUpdate(double tpf) {
        updateBar();
    }

    public void updateBar() {
        double percentageChanged = entity.getComponent(LevelComponent.class).getExpProgressPercent();
        FXGL.animationBuilder()
                .duration(Duration.millis(200))
                .scale(experienceBar)
                .from(new Point2D(experienceBar.getScaleX(), 1))
                .to(new Point2D(percentageChanged / 100.0, 1))
                .buildAndPlay();
    }

}
