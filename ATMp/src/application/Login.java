package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class Login {

    @FXML
    private PasswordField pinField;

    private final String correctPin = "1234"; 

    @FXML
    private void handleLoginButtonAction() {
        String enteredPin = pinField.getText();
        if (enteredPin.equals(correctPin)) {
            proceedToMainATM();
        } else {
            showLoginError();
        }
    }

    private void proceedToMainATM() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ATM_FXML.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) pinField.getScene().getWindow(); 
            stage.setScene(new Scene(root));  
            stage.setTitle("ATM");  
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showLoginError() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginError.fxml"));
            Parent root = loader.load();
            Stage errorStage = new Stage();
            errorStage.setScene(new Scene(root));
            errorStage.setTitle("Login Error");
            errorStage.initModality(javafx.stage.Modality.APPLICATION_MODAL); 
            errorStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
