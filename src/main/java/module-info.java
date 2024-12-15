module org.example.ispwprogect {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ispwprogect to javafx.fxml;
    exports org.example.ispwprogect;
}