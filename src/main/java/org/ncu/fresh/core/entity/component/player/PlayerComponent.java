package org.ncu.fresh.core.entity.component.player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import org.ncu.fresh.core.constant.Constant;
import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.component.attack.base.Weapon;
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
        if (FXGL.getWorldProperties().getBoolean(Constant.IS_PAUSED)) {
            return;
        }
        entity.translateY(-movementSpeed());
    }
    public void moveDown() {
        if (FXGL.getWorldProperties().getBoolean(Constant.IS_PAUSED)) {
            return;
        }
        entity.translateY(movementSpeed());
    }
    public void moveLeft() {
        if (FXGL.getWorldProperties().getBoolean(Constant.IS_PAUSED)) {
            return;
        }
        entity.translateX(-movementSpeed());
    }
    public void moveRight() {
        if (FXGL.getWorldProperties().getBoolean(Constant.IS_PAUSED)) {
            return;
        }
        entity.translateX(movementSpeed());
    }

    @Override
    public void onUpdate(double tpf) {
        UIManager.updateBar();
    }

    public void giveWeapon(Component weapon) {
        if (entity.getComponentOptional(weapon.getClass()).isEmpty()) {
            entity.addComponent(weapon);
            weaponOwned.addLast(weapon);
        }
        else {
            ((Weapon)weapon).levelUp();
        }
    }

    public void givePowerUp(Component powerUp) {
        powerUpOwned.addLast(powerUp);
    }

    public ArrayList<Component> getWeaponOwned() {
        return weaponOwned;
    }

    public ArrayList<Component> getPowerUpOwned() {
        return powerUpOwned;
    }
}
