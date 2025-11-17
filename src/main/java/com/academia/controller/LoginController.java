package com.academia.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class LoginController {

    @FXML
    private TextField cpfField;

    @FXML
    private PasswordField senhaField;

    @FXML
    private Label errorLabel;

    @FXML
    private void handleLogin() {

        String cpf = cpfField.getText();
        String senha = senhaField.getText();

        if ("12345678900".equals(cpf) && "admin".equals(senha)) {
            try {
                FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("/fxml/DashboardView.fxml")
                );

                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) cpfField.getScene().getWindow();
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            errorLabel.setText("CPF ou senha inválidos!");
        }
    }
}
