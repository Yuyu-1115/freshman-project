package org.ncu.fresh.core.entity.component;

import com.almasb.fxgl.entity.component.Component;

public class PlayerComponent extends Component {
    public static final int MOVEMENT_SPEED = 5;
    /*
    Contain every basic behaviour related to the player
     */

    public void moveUp() {
        entity.translateY(-MOVEMENT_SPEED);
    }
    public void moveDown() {
        entity.translateY(MOVEMENT_SPEED);
    }
    public void moveLeft() {
        entity.translateX(-MOVEMENT_SPEED);
    }
    public void moveRight() {
        entity.translateX(MOVEMENT_SPEED);
    }
}
