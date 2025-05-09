package org.ncu.fresh.core.entity.component;

import com.almasb.fxgl.entity.component.Component;
import org.ncu.fresh.core.entity.EntityType;

public class ProjectileDataComponent extends Component {
    private double damage;
    private double speed;
    private double size;
    private EntityType source;

    public ProjectileDataComponent(double damage, double speed, double size, EntityType source) {
        this.damage = damage;
        this.speed = speed;
        this.size = size;
        this.source = source;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public EntityType getSource() {
        return source;
    }
}
