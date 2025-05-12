package org.ncu.fresh.core.entity.component;

import com.almasb.fxgl.entity.component.Component;
import javafx.scene.effect.ColorAdjust;

public class EnemyComponent extends Component {
    private final int experienceDropped;
    private final ColorAdjust colorAdjust = new ColorAdjust();


    public EnemyComponent(int experienceDropped) {
        this.experienceDropped = experienceDropped;
    }

    public int getExperienceDropped() {
        return experienceDropped;
    }

    public void onHit() {

    }
}
