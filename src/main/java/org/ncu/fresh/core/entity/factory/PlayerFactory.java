package org.ncu.fresh.core.entity.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.TransformComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.BasicAttackComponent;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.component.resourcebar.ExperienceBarComponent;
import org.ncu.fresh.core.entity.component.resourcebar.HealthBarComponent;
import org.ncu.fresh.core.entity.component.player.PlayerComponent;
import org.ncu.fresh.core.handler.InputHandler;

public class PlayerFactory implements EntityFactory {
    @Spawns("player")
    public static void createPlayer() {
        Entity player =  FXGL.entityBuilder()
                .type(EntityType.PLAYER)
                .at(400, 300)
                .viewWithBBox(new Rectangle(20, 20, Color.BLUE))
                .with(new BasicAttackComponent(Color.RED))
                .with(new PlayerComponent())
                .with(new LevelComponent())
                .with(new ExperienceBarComponent())
                .with(new HealthDoubleComponent(500))
                .with(new HealthBarComponent())
                .collidable()
                .buildAndAttach();
        InputHandler.initPlayerMovement(player);
    }
}
