package org.ncu.fresh.core.entity.component.player;

import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.component.Component;
import org.ncu.fresh.gui.UIManager;

public class LevelComponent extends Component {
    private int level = 0;
    private int currentExperience = 0;

    @Override
    public void onUpdate(double tpf) {
        if (canLevelUp()) {
            currentExperience -= getExperienceRequiredToLevelUp();
            level += 1;
            UIManager.levelUp(level);
        }
    }

    public void giveExperience(int amount) {
        currentExperience += amount;
    }

    public double getExpProgressPercent() {
        return 100.0 * (double) currentExperience / getExperienceRequiredToLevelUp();
    }

    private int getExperienceRequiredToLevelUp() {
        return 100 * (level % 10);
    }

    private boolean canLevelUp() {
        return currentExperience >= getExperienceRequiredToLevelUp();
    }

    public int getLevel() {
        return level;
    }
}
