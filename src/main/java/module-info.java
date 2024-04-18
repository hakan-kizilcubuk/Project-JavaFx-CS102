module org.example.projectjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.projectjavafx to javafx.fxml;
    exports org.example.projectjavafx;
}