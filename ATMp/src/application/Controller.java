package application;



import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class Controller {

    private Account account = new Account("123456", 1000.00);  // Example account

    @FXML
    private void handleWithdraw() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Withdrawal");
        dialog.setHeaderText("Enter amount to withdraw:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(amountStr -> {
            try {
                double amount = Double.parseDouble(amountStr);
                if (account.withdraw(amount)) {
                    showAlert("Success", "Withdrawal successful. New balance: $" + account.getBalance());
                } else {
                    showAlert("Error", "Insufficient funds or invalid amount.");
                }
            } catch (NumberFormatException e) {
                showAlert("Error", "Invalid input. Please enter a valid number.");
            }
        });
    }

    @FXML
    private void handleDeposit() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Deposit");
        dialog.setHeaderText("Enter amount to deposit:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(amountStr -> {
            try {
                double amount = Double.parseDouble(amountStr);
                account.deposit(amount);
                showAlert("Success", "Deposit successful. New balance: $" + account.getBalance());
            } catch (NumberFormatException e) {
                showAlert("Error", "Invalid input. Please enter a valid number.");
            }
        });
    }

    @FXML
    private void handleCheckBalance() {
        showAlert("Balance", "Current balance: $" + account.getBalance());
    }



    @FXML
    private void handleCardReturn() {
        showAlert("Card Return", "Thank You for using this ATM. Have a great day!");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
