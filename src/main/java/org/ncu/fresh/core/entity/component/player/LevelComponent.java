package org.ncu.fresh.core.entity.component.player;

import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.component.Component;
import org.ncu.fresh.gui.UIManager;

public class LevelComponent extends Component {
    private int level = 1;
    private int currentExperience = 0;
    private int experienceGained = 0;

    @Override
    public void onUpdate(double tpf) {
        if (canLevelUp()) {
            currentExperience -= level * 200;
            level += 1;
            entity.getComponent(HealthDoubleComponent.class).restorePercentageMax(50);
            UIManager.levelUp();
        }
    }

    public void giveExperience(int amount) {
        currentExperience += amount;
        experienceGained += amount;
    }

    public double getExpProgressPercent() {
        return 100.0 * (double) currentExperience / (level * 200);
    }


    private boolean canLevelUp() {
        return currentExperience >= level * 200;
    }
}
