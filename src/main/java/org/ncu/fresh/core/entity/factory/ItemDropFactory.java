package org.ncu.fresh.core.entity.factory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.components.BoundingBoxComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import javafx.geometry.Point2D;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.helper.InitializationHelper;
import org.ncu.fresh.event.ItemPickedUpEvent;

public class ItemDropFactory implements EntityFactory {

    public static Entity createExperienceOrb(Point2D position) {
        Entity experienceOrb = FXGL.entityBuilder()
                .type(EntityType.DROP)
                .at(position)
                .view("itemdrop/expOrb.png")
                .collidable()
                .buildAndAttach();
        InitializationHelper.initializeItemDrop(experienceOrb, 10, ItemPickedUpEvent.EXP);
        experienceOrb.getComponent(BoundingBoxComponent.class).addHitBox(new HitBox(BoundingShape.circle(10)));
        return experienceOrb;
    }
}
