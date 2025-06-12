package org.ncu.fresh.core.entity.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.BoundingBoxComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.component.player.LevelComponent;
import org.ncu.fresh.core.entity.component.player.PlayerAnimationComponent;
import org.ncu.fresh.core.entity.component.player.PlayerComponent;
import org.ncu.fresh.core.entity.helper.InitializationHelper;

public class PlayerFactory implements EntityFactory {
    @Spawns("player")
    public static Entity createPlayer() {
        Entity player = FXGL.entityBuilder()
                .type(EntityType.PLAYER)
                .at(320, 180, -1)
                .with(new PlayerComponent())
                .with(new PlayerAnimationComponent())
                .with(new LevelComponent())
                .with(new HealthDoubleComponent(100))
                .collidable()
                .buildAndAttach();
        InitializationHelper.initializePlayer(player);
        player.getComponent(BoundingBoxComponent.class).addHitBox(new HitBox("body", BoundingShape.circle(10)));
        return player;
    }
}
