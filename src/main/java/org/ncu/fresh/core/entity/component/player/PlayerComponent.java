package org.ncu.fresh.core.entity.component.player;

import com.almasb.fxgl.entity.component.Component;
import org.ncu.fresh.core.entity.constant.PlayerProperties;
import org.ncu.fresh.core.utils.PropertyHelper;
import org.ncu.fresh.gui.UIManager;

import java.util.ArrayList;

public class PlayerComponent extends Component {
    /*
    Contain every basic data and behaviour related to the player
     */

    private final ArrayList<Component> weaponOwned = new ArrayList<>();
    private final ArrayList<Component> powerUpOwned = new ArrayList<>();

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

    @Override
    public void onUpdate(double tpf) {
        UIManager.updateBar();
    }
}
