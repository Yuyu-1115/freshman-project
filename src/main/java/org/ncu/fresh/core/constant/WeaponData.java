package org.ncu.fresh.core.constant;

import com.almasb.fxgl.entity.component.Component;
import org.ncu.fresh.core.entity.component.attack.YukionnaBreathComponent;
import org.ncu.fresh.core.entity.component.attack.*;
import org.ncu.fresh.core.utils.WeaponHelper;

import java.util.function.Supplier;

public enum WeaponData {
    // fire
    INFERNAL_WHEEL("infernalWheel", InfernalWheelComponent::new),
    ZONE_OF_RA("zoneOfRa", ZoneOfRaComponent::new),
    // water
    AQUA_CUTTER("aquaCutter", AquaCutterComponent::new),
    YUKIONNA_BREATH("yukionnaBreath", YukionnaBreathComponent::new),
    // wind
    WIND_BLADE("windBlade", WindBladeComponent::new),
    ZEPHYR_STAR("zephyrStar", ZephyrStarComponent::new),
    // dark
    ARTEMIS_CRESCENT("artemisCrescent", ArtemisCrescentComponent::new),
    ANUBIS_GUARD("anubisGuard", AnubisGuardComponent::new);

    private final String id;
    private final Supplier<Component> componentSupplier;

    WeaponData(String id, Supplier<Component> supplier) {
        this.id = id;
        this.componentSupplier = supplier;
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
