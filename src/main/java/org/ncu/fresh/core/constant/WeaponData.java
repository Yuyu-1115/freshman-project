package org.ncu.fresh.core.constant;

import com.almasb.fxgl.entity.component.Component;
import org.ncu.fresh.core.entity.component.attack.AquaCutterComponent;
import org.ncu.fresh.core.entity.component.attack.InfernalWheelComponent;
import org.ncu.fresh.core.entity.component.attack.WindBladeComponent;
import org.ncu.fresh.core.entity.component.attack.ZephyrStarComponent;
import org.ncu.fresh.core.utils.WeaponHelper;

import java.util.function.Supplier;

public enum WeaponData {
    // fire
    INFERNAL_WHEEL("infernalWheel", new InfernalWheelComponent()),
    // water
    AQUA_CUTTER("aquaCutter", new AquaCutterComponent()),
    // wind
    WIND_BLADE("windBlade", new WindBladeComponent()),
    ZEPHYR_STAR("zephyrStar", new ZephyrStarComponent());

    private final String id;
    private final Supplier<Component> componentSupplier;

    WeaponData(String id, Component component) {
        this.id = id;
        this.componentSupplier = () -> component;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return WeaponHelper.getWeaponName(id);
    }

    public String getUpgradeDesc() {
        return WeaponHelper.getWeaponUpgradeDesc(id);
    }

    public String getBaseDesc() {
        return WeaponHelper.getWeaponBaseDesc(id);
    }

    public Supplier<Component> getComponentSupplier() {
        return componentSupplier;
    }

}
