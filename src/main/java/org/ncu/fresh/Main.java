package org.ncu.fresh;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;
import com.almasb.fxgl.entity.components.TransformComponent;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.ncu.fresh.entity.EntityType;
import org.ncu.fresh.entity.component.BasicAttackComponent;

public class Main extends GameApplication {

    @Override
    protected void initGame() {
        Entity player = FXGL.entityBuilder()
                .type(EntityType.PLAYER)
                .at(400, 300)
                .viewWithBBox(new Rectangle(20, 20, Color.BLUE))
                .with(new TransformComponent())
                .with(new BasicAttackComponent())
                .buildAndAttach();
        FXGL.onKey(KeyCode.W,
                () -> player.translateY(-5));
        FXGL.onKey(KeyCode.S,
                () -> player.translateY(5));
        FXGL.onKey(KeyCode.A,
                () -> player.translateX(-5));
        FXGL.onKey(KeyCode.D,
                () -> player.translateX(5));
    }


    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(800);
        gameSettings.setHeight(600);
        gameSettings.setTitle("Team Project");


    }

    public static void main(String[] args) {
        launch(args);
    }
}
