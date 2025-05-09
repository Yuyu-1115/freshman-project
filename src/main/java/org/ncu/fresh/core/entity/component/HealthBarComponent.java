package org.ncu.fresh.core.entity.component;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import org.ncu.fresh.core.entity.factory.HealthBarFactory;

public class HealthBarComponent extends Component {
    private static final double DISPLAY_TIME = 0.8f;

    private Entity healthBar;
    private double remainTimeToDisplay = 0;

    @Override
    public void onAdded() {
        healthBar = HealthBarFactory.createHealthBar(entity.getCenter().add(-20, 40));
    }

    @Override
    public void onUpdate(double tpf) {
        if (remainTimeToDisplay > 0) {
            remainTimeToDisplay -= tpf;
        }
        if (remainTimeToDisplay <= 0) {
            healthBar.setOpacity(0);
        }
    }

    public void onDamaged() {
        double percentageChanged = entity.getComponent(HealthDoubleComponent.class).getValuePercent();
        System.out.println(percentageChanged + " An entity got damaged!");
        healthBar.setScaleX(percentageChanged / 100.0);
        remainTimeToDisplay = DISPLAY_TIME;
        healthBar.setOpacity(1);
        if (!healthBar.isActive()) {
            FXGL.getGameWorld().addEntity(healthBar);
        }
    }
}
