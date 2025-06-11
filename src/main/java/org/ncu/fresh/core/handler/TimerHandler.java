package org.ncu.fresh.core.handler;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.time.TimerAction;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.ncu.fresh.core.entity.EntityType;
import org.ncu.fresh.core.entity.factory.EnemyFactory;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;


import static com.almasb.fxgl.core.math.FXGLMath.toRadians;

public class TimerHandler {

    private static final TimerAction enemySpawnTimer ;

    static {
       enemySpawnTimer = FXGL.getGameTimer().runAtInterval(TimerHandler::enemySpawn, Duration.seconds(10));
       enemySpawnTimer.pause();
    }


    public static void enemySpawn() {
        int number = FXGL.random(5, 10);
        double radius = FXGL.random(300, 600);
        double degree = FXGL.random(0, 360);
        Point2D center = new Point2D(radius * Math.cos(toRadians(degree)), radius * Math.sin(toRadians(degree))).add(ReferenceHelper.getPlayer().getPosition());
        for (int i = 0; i < number; i++) {
            Point2D offset = new Point2D(FXGLMath.random(-100, 100), FXGLMath.random(-100, 100));
            EnemyFactory.createEnemy(center.add(offset), 50, new ImageView(FXGL.getAssetLoader().loadImage("slime.png")));
        }
    }

    public static void initializeTimer() {
        enemySpawnTimer.resume();
    }

    public static void pauseTimer() {
        enemySpawnTimer.pause();
    }

    public static void resumeTimer() {
        enemySpawnTimer.resume();
    }
}
