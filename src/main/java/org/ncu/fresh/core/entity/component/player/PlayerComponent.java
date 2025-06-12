package org.ncu.fresh.core.entity.component.player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.HealthDoubleComponent;
import com.almasb.fxgl.entity.component.Component;
import org.ncu.fresh.core.constant.Constant;
import org.ncu.fresh.core.constant.WeaponData;
import org.ncu.fresh.core.entity.component.attack.base.Weapon;
import org.ncu.fresh.core.entity.constant.PlayerProperties;
import org.ncu.fresh.core.entity.helper.ReferenceHelper;
import org.ncu.fresh.core.handler.TimerHandler;
import org.ncu.fresh.core.utils.PropertyHelper;
import org.ncu.fresh.gui.UIManager;

import java.util.ArrayList;

public class PlayerComponent extends Component {
    /*
    Contain every data and behaviour related to the player
     */

    private final ArrayList<Component> weaponOwned = new ArrayList<>();
    private final ArrayList<Integer> damageDealt = new ArrayList<>();

    public void moveUp() {
        if (FXGL.getWorldProperties().getBoolean(Constant.IS_PAUSED)) {
            return;
        }
        entity.translateY(-getMovementSpeed());
    }
    public void moveDown() {
        if (FXGL.getWorldProperties().getBoolean(Constant.IS_PAUSED)) {
            return;
        }
        entity.translateY(getMovementSpeed());
    }
    public void moveLeft() {
        if (FXGL.getWorldProperties().getBoolean(Constant.IS_PAUSED)) {
            return;
        }
        entity.translateX(-getMovementSpeed());
    }
    public void moveRight() {
        if (FXGL.getWorldProperties().getBoolean(Constant.IS_PAUSED)) {
            return;
        }
        entity.translateX(getMovementSpeed());
    }

    public void damage(double amount) {
        ReferenceHelper.getPlayer().getComponent(HealthDoubleComponent.class).damage(amount);
    }

    public void updateRecord(WeaponData weaponData, int damage) {
        for (int i = 0; i < damageDealt.size(); i++) {
            if (weaponOwned.get(i).getClass() == weaponData.getComponentSupplier().get().getClass()) {
                damageDealt.set(i, damageDealt.get(i) + damage);
                // System.out.println(weaponData.getName() + " has dealt " + damageDealt.get(i) + " damages");
                return;
            }
        }
    }

    public void giveWeapon(Component weapon) {
        if (entity.getComponentOptional(weapon.getClass()).isEmpty()) {
            entity.addComponent(weapon);
            weaponOwned.addLast(weapon);
            damageDealt.add(0);
        }
        else {
            for (var item: weaponOwned) {
                if (item.getClass() == weapon.getClass()) {
                    ((Weapon)item).levelUp();
                }
            }
        }
    }

    @Override
    public void onUpdate(double tpf) {
        UIManager.updateBar();
        TimerHandler.updateBackground();
        if (ReferenceHelper.getPlayer().getComponent(HealthDoubleComponent.class).isZero()) {
            UIManager.showResult();
            FXGL.getGameController().pauseEngine();
            FXGL.getWorldProperties().setValue(Constant.IS_PAUSED, true);
        }
    }

    private int getMovementSpeed() {
        return PropertyHelper.getIntProperty(entity, PlayerProperties.MOVEMENT_SPEED);
    }

    public ArrayList<Component> getWeaponOwned() {
        return weaponOwned;
    }

    public ArrayList<Integer> getDamageDealt() {
        return damageDealt;
    }
}
