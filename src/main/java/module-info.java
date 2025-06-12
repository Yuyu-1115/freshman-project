module org.ncu.fresh {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;
    requires annotations;

    exports org.ncu.fresh.core.entity.component.attack.base;
    exports org.ncu.fresh.core.entity.component.attack.animation to com.almasb.fxgl.core;
    exports org.ncu.fresh to com.almasb.fxgl.core;
    exports org.ncu.fresh.gui to com.almasb.fxgl.core;
    exports org.ncu.fresh.core.entity to com.almasb.fxgl.core;
    exports org.ncu.fresh.event;
    exports org.ncu.fresh.core.constant;
    opens org.ncu.fresh.gui to javafx.fxml;
    opens org.ncu.fresh.gui.ui to javafx.fxml;

    // this solves the issue of texture not loading, but I don't really know about resources encapsulation
    // at least it turns error into warning
    opens assets.textures;
    opens assets.textures.projectile;
    opens assets.textures.itemdrop;
    opens assets.textures.icon;
    opens assets.ui.fonts;
    opens assets.textures.ui.upgrade;
    opens assets.textures.ui.hud;
    opens assets.textures.ui.main_menu;
    opens assets.textures.ui.result;

    opens description;

}