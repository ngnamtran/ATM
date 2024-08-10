package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginErrorController {

    @FXML
    private Button closeButton;

    @FXML
    private void handleCloseButtonAction() {
        
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
