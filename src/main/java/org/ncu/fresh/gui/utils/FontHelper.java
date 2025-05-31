package org.ncu.fresh.gui.utils;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.ui.FontFactory;
import javafx.scene.text.Font;

public class FontHelper {
    private static final FontFactory ALAGARD = FXGL.getAssetLoader().loadFont("alagard.ttf");
    private static final FontFactory SHARETECH_MONO = FXGL.getAssetLoader().loadFont("ShareTechMono-Regular.ttf");

    public static Font alagard(double size) {
        return ALAGARD.newFont(size);
    }

    public static Font shareTechMono(double size) {
        return SHARETECH_MONO.newFont(size);
    }
}
