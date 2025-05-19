package org.ncu.fresh.gui.ui;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.ui.UIController;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.ncu.fresh.core.constant.Color;

public class GameHUDUIController implements UIController {
    @FXML
    private ImageView hpFill;
    @FXML
    private ImageView xpFill;

    public void updateBar(double hpPercent, double xpPercent) {

        // FIXME: Fix the display of xpBar
        hpFill.setViewport(new Rectangle2D(0, 0, hpFill.getImage().getWidth() * hpPercent, hpFill.getImage().getHeight()));
        xpFill.setViewport(new Rectangle2D(0, 0, xpFill.getImage().getWidth() * xpPercent, xpFill.getImage().getHeight()));

        if (hpPercent <= 0.2) {
            hpFill.setEffect(Color.HP_RED);
        }
        else if (hpPercent <= 0.5) {
            hpFill.setEffect(Color.HP_YELLOW);
        }
        else {
            hpFill.setEffect(null);
        }
    }

    public void levelUp() {
        ColorAdjust colorAdjust = new ColorAdjust();
        xpFill.setEffect(colorAdjust);
        FXGL.animationBuilder()
                .repeat(10)
                .autoReverse(true)
                .duration(Duration.millis(100))
                .animate(colorAdjust.hueProperty())
                .from(0)
                .to(1)
                .buildAndPlay();
        xpFill.setEffect(null);
    }

    @Override
    public void init() {
    }
}
