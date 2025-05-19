package org.ncu.fresh.core.constant.weapon;

public enum WeaponId {
    SPINNING_FIREBALL("spinningFireBall", "spinningFireball.png");

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
