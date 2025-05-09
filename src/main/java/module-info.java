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

    exports org.ncu.fresh.core.entity.component;
    exports org.ncu.fresh to com.almasb.fxgl.core;
    exports org.ncu.fresh.core.entity to com.almasb.fxgl.core;
    exports org.ncu.fresh.event;

    opens assets.textures;
}