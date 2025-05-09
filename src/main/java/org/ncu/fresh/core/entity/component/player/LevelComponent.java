package org.ncu.fresh.core.entity.component.player;

import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import org.ncu.fresh.core.entity.component.EnemyComponent;
import org.ncu.fresh.core.entity.component.resourcebar.ExperienceBarComponent;
import org.ncu.fresh.core.entity.component.resourcebar.HealthBarComponent;

public class LevelComponent extends Component {
    private int[] experienceaArray = {10, 20, 30, 40};
    private int level = 1;
    private int currentExperience = 0;
    private int experienceGained = 0;

    @Override
    public void onUpdate(double tpf) {
        if (canLevelUp()) {
            currentExperience -= experienceaArray[level - 1];
            level += 1;
            entity.getComponent(HealthDoubleComponent.class).restorePercentageMax(50);
            entity.getComponent(HealthBarComponent.class).updateBar();
            System.out.println("Level up!");
        }
    }

    public void giveExperience(int amount) {
        currentExperience += amount;
        experienceGained += amount;
        entity.getComponent(ExperienceBarComponent.class).updateBar();
    }

    public double getExpProgressPercent() {
        return 100.0 * (double) currentExperience / experienceaArray[level - 1];
    }

    public void gainExperienceFrom(Entity enemy) {
        int amount = enemy.getComponent(EnemyComponent.class).getExperienceDropped();
        currentExperience += amount;
        experienceGained += amount;
        entity.getComponent(ExperienceBarComponent.class).updateBar();
    }

    private boolean canLevelUp() {
        return currentExperience >= experienceaArray[level - 1];
    }
}
