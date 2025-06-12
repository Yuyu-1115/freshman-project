package org.ncu.fresh.core.handler;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.KeyCode;
import org.ncu.fresh.core.entity.component.attack.InfernalWheelComponent;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.component.player.PlayerComponent;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.gui.UIManager;

public class InputHandler {
    public static void initPlayerMovement() {
        FXGL.onKey(KeyCode.W,
                () -> ReferenceHelper.getPlayerComponent().moveUp());
        FXGL.onKey(KeyCode.S,
                () -> ReferenceHelper.getPlayerComponent().moveDown());
        FXGL.onKey(KeyCode.A,
                () -> ReferenceHelper.getPlayerComponent().moveLeft());
        FXGL.onKey(KeyCode.D,
                () -> ReferenceHelper.getPlayerComponent().moveRight());
        FXGL.onKey(KeyCode.Q,
                () -> UIManager.levelUp(ReferenceHelper.getPlayer().getComponent(LevelComponent.class).getLevel() + 1));

    }
}
