package com.academia.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField usuarioField;
    @FXML private PasswordField senhaField;
    @FXML private Label mensagemErro;

    @FXML
    private void onLogin() {
        String user = usuarioField.getText();
        String pass = senhaField.getText();

        // Login simples (pode trocar depois por autenticação real)
        if (user.equals("admin") && pass.equals("123")) {
            abrirDashboard();
        } else {
            mensagemErro.setText("Usuário ou senha incorretos.");
        }
    }

    private void abrirDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Dashboard.fxml"));
            Scene scene = new Scene(loader.load());

            Stage stage = (Stage) usuarioField.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Academia - Dashboard");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
