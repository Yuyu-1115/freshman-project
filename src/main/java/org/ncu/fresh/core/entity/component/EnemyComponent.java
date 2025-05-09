package org.ncu.fresh.core.entity.component;

import com.almasb.fxgl.entity.component.Component;

public class EnemyComponent extends Component {
    private final int experienceDropped;


    public EnemyComponent(int experienceDropped) {
        this.experienceDropped = experienceDropped;
    }

    public int getExperienceDropped() {
        return experienceDropped;
    }
}
