package org.ncu.fresh.core.entity.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.components.TransformComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.BasicAttackComponent;
import org.ncu.fresh.core.entity.component.PlayerComponent;
import org.ncu.fresh.core.entity.io.InputHandler;

public class PlayerFactory implements EntityFactory {
    public static void createPlayer() {
        Entity player =  FXGL.entityBuilder()
                .type(EntityType.PLAYER)
                .at(400, 300)
                .viewWithBBox(new Rectangle(20, 20, Color.BLUE))
                .with(new TransformComponent())
                .with(new BasicAttackComponent())
                .with(new PlayerComponent())
                .buildAndAttach();
        InputHandler.initPlayerMovement(player);
    }
}
