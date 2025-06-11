package org.ncu.fresh.gui.utils;

import com.almasb.fxgl.app.scene.*;
import org.jetbrains.annotations.NotNull;
import org.ncu.fresh.gui.MainMenu;

public class MenuFactory extends SceneFactory {
    @NotNull
    @Override
    public FXGLMenu newGameMenu() {
        return super.newGameMenu();
    }

    @NotNull
    @Override
    public IntroScene newIntro() {
        return super.newIntro();
    }

    @NotNull
    @Override
    public LoadingScene newLoadingScene() {
        return super.newLoadingScene();
    }

    @NotNull
    @Override
    public FXGLMenu newMainMenu() {
        return new MainMenu(MenuType.MAIN_MENU);
    }

    @NotNull
    @Override
    public StartupScene newStartup(int width, int height) {
        return super.newStartup(width, height);
    }
}
