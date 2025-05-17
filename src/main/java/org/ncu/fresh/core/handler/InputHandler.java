package org.ncu.fresh.core.handler;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import javafx.scene.input.KeyCode;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.component.player.PlayerComponent;

public class InputHandler {
    public static void initPlayerMovement(Entity player) {
        FXGL.onKey(KeyCode.W,
                () -> player.getComponent(PlayerComponent.class).moveUp());
        FXGL.onKey(KeyCode.S,
                () -> player.getComponent(PlayerComponent.class).moveDown());
        FXGL.onKey(KeyCode.A,
                () -> player.getComponent(PlayerComponent.class).moveLeft());
        FXGL.onKey(KeyCode.D,
                () -> player.getComponent(PlayerComponent.class).moveRight());


        FXGL.onKey(KeyCode.SPACE,
                () -> player.getComponent(LevelComponent.class).giveExperience(5));

        FXGL.onKey(KeyCode.C,
                () -> player.getComponent(HealthDoubleComponent.class).damage(10));

    }
}
