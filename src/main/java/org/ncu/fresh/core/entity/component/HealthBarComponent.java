package org.ncu.fresh.core.entity.component;

import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HealthBarComponent extends Component {
    private static final double DISPLAY_TIME = 0.5f;

    private final Rectangle healthBar = new Rectangle(40, 10, Color.RED);
    private double remainTimeToDisplay = 0;

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
        healthBar.setScaleX(percentageChanged / 100);
        healthBar.setOpacity(100);
    }
}
