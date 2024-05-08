module org.example.projectjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;

    opens org.example.projectjavafx to javafx.fxml;
    exports org.example.projectjavafx;
}