package org.ncu.fresh;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import org.ncu.fresh.core.entity.factory.PlayerFactory;

public class Main extends GameApplication {

    @Override
    protected void initGame() {
        PlayerFactory.createPlayer();
    }


    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(800);
        gameSettings.setHeight(640);
        gameSettings.setTitle("Team Project");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
