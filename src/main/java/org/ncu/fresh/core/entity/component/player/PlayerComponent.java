package org.ncu.fresh.core.entity.component.player;

import com.almasb.fxgl.entity.component.Component;
import org.ncu.fresh.core.entity.constant.PlayerProperties;
import org.ncu.fresh.core.utils.helper.PropertyHelper;
import org.ncu.fresh.gui.UIManager;

public class PlayerComponent extends Component {
    /*
    Contain every basic data and behaviour related to the player
     */

    private int movementSpeed() {
        return PropertyHelper.getIntProperty(entity, PlayerProperties.MOVEMENT_SPEED);
    }

    public void moveUp() {
        entity.translateY(-movementSpeed());
    }
    public void moveDown() {
        entity.translateY(movementSpeed());
    }
    public void moveLeft() {
        entity.translateX(-movementSpeed());
    }
    public void moveRight() {
        entity.translateX(movementSpeed());
    }
    public void addComponent() {

    }

    @Override
    public void onUpdate(double tpf) {
        UIManager.updateBar();
    }
}
