module org.example.ispwprogect {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.ispwprogect to javafx.fxml;
    exports org.example.ispwprogect;
}