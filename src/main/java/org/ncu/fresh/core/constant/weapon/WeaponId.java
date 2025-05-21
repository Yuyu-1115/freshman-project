package org.ncu.fresh.core.constant.weapon;

import com.almasb.fxgl.entity.component.Component;

import java.util.function.Supplier;

public enum WeaponId {
    INFERNAL_WHEEL("infernalWheel", "infernalWheel.png");

    private final String id;
    private final String assetName;

    WeaponId(String id, String assetName) {
        this.id = id;
        this.assetName = assetName;
    }

    public String getId() {
        return id;
    }

    public String getAssetName() {
        return "projectile/" + assetName;
    }
}
