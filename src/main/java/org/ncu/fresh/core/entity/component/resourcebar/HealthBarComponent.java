package org.ncu.fresh.core.entity.component.resourcebar;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import javafx.util.Duration;
import org.ncu.fresh.core.entity.factory.ResourceBarFactory;

public class HealthBarComponent extends Component {
    private static final double DISPLAY_TIME = 0.8f;

    private Entity healthBar;
    private double remainTimeToDisplay = 0;



    @Override

    public void onAdded() {
        healthBar = ResourceBarFactory.createHealthBar(entity.getCenter().add(-20, 40));
    }

    @Override
    public void onUpdate(double tpf) {
        if (remainTimeToDisplay > 0) {
            remainTimeToDisplay -= tpf;
            healthBar.setPosition(entity.getPosition().add(-20, 40));
        }
        if (remainTimeToDisplay <= 0) {
            healthBar.setOpacity(0);
        }
    }

    public void damage() {
        // reset display time
        remainTimeToDisplay = DISPLAY_TIME;

        if (!healthBar.isActive()) {
            FXGL.getGameWorld().addEntity(healthBar);
        }

        updateBar();

        // making the health bar visible
        healthBar.setOpacity(1);

    }

    public void updateBar() {
        double percentageChanged = entity.getComponent(HealthDoubleComponent.class).getValuePercent();
        FXGL.animationBuilder()
                .duration(Duration.millis(200))
                .scale(healthBar)
                .from(new Point2D(healthBar.getScaleX(), 1))
                .to(new Point2D(percentageChanged / 100.0, 1))
                .buildAndPlay();
    }
}
