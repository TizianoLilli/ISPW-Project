module org.example.ispwprogect {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens org.example.ispwprogect to javafx.fxml;
    exports org.example.ispwprogect;
    exports org.example.ispwprogect.control.graphic;
    opens org.example.ispwprogect.control.graphic to javafx.fxml;
    exports org.example.ispwprogect.control.graphic.buyDreamGuitar;
    opens org.example.ispwprogect.control.graphic.buyDreamGuitar to javafx.fxml;
    exports org.example.ispwprogect.control.graphic.buyRecommendedGuitar;
    opens org.example.ispwprogect.control.graphic.buyRecommendedGuitar to javafx.fxml;
}