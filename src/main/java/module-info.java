module org.example.csmainmenu {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.csmainmenu to javafx.fxml;
    exports org.example.csmainmenu;
}