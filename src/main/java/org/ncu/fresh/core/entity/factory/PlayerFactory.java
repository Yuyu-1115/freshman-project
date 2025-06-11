package org.ncu.fresh.core.entity.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.attack.ZephyrStarComponent;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.component.player.PlayerComponent;
import org.ncu.fresh.core.entity.helper.InitializationHelper;
import org.ncu.fresh.core.handler.InputHandler;

public class PlayerFactory implements EntityFactory {
    @Spawns("player")
    public static Entity createPlayer() {

        Entity player = FXGL.entityBuilder()
                .type(EntityType.PLAYER)
                .at(400, 300, -1)
                .viewWithBBox(new Rectangle(20, 20, Color.BLUE))
                .with(new PlayerComponent())
                .with(new LevelComponent())
                .with(new HealthDoubleComponent(500))
                .collidable()
                .buildAndAttach();
        InitializationHelper.initializePlayer(player);
        InputHandler.initPlayerMovement(player);
        return player;
    }
}
