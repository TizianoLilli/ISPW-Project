package org.example.ispwprogect.control.graphic.buyDreamGuitar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextAlignment;
import org.example.ispwprogect.control.graphic.GraphicController;
import org.example.ispwprogect.utils.bean.DreamGuitarBean;
import org.example.ispwprogect.utils.exception.SystemException;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.sql.SQLException;

public class ToLuthierController extends GraphicController {

    @Override
    public void init(int sessionId, DreamGuitarBean dreamGuitarBean) throws SystemException, IOException, LoginException, SQLException {
        // da implementare
    }

    @FXML
    private ImageView arrowImage;

    @FXML
    private Image luthierImage;

    @FXML
    private Image noticeboardImage;

    @FXML
    private ImageView image;

    @FXML
    private Button luthierButton;

    @FXML
    private Label luthierDescription;

    private boolean stateOne = true;
    public void handleSwitch(MouseEvent mouseEvent) {
        image.setImage(image.getImage() == luthierImage ? noticeboardImage : luthierImage);

        if (stateOne) {
            luthierButton.setText("Publish Now");
            luthierDescription.setText("Share your new Dream Guitar with other users and obtain rates and comments.\nLet others take inspiration from your creation.");
            luthierDescription.setWrapText(true);
            luthierButton.setAlignment(Pos.CENTER);
            luthierDescription.setTextAlignment(TextAlignment.CENTER);
            luthierButton.setOnAction(event -> {System.out.println("Dream Guitar successfully published!");});
        } else {
            luthierButton.setText("Contact a Master");
            luthierDescription.setText("Send your Dream Guitar to a Master Luthier and let him realize your project.\nTouch your creation and enjoy playing your favourite songs.");
            luthierDescription.setWrapText(true);
            luthierButton.setAlignment(Pos.CENTER);
            luthierDescription.setTextAlignment(TextAlignment.CENTER);
            luthierButton.setOnAction(event -> {System.out.println("Dream Guitar successfully ordered!");});
        }
        stateOne = !stateOne;
    }

    public void handleBackClick(ActionEvent actionEvent) {
        // da implementare
    }

    public void handleSaveClick(ActionEvent actionEvent) {
        // da implementare
    }
}
