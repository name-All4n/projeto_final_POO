package com.academia.frontend.controller;

import com.academia.frontend.service.ServiceFacade;
import com.academia.model.pessoa.Instrutor;
import com.academia.model.pessoa.Membro;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class LoginController {

    @FXML private ChoiceBox<String> choiceTipo;
    @FXML private TextField cpfField;
    @FXML private TextArea outputArea;
    @FXML private Button btnOpenDashboard;
    @FXML private Button btnOpenPayments;

    @FXML
    public void initialize() {
        choiceTipo.getItems().addAll("Membro", "Instrutor");
        choiceTipo.setValue("Membro");
        updateButtons(false);
        outputArea.setText("Informe seu CPF e selecione o tipo. Clique em Entrar.");
    }

    @FXML
    private void onEntrar() {
        String tipo = choiceTipo.getValue();
        String cpf = cpfField.getText();
        if (cpf == null || cpf.trim().isEmpty()) {
            outputArea.setText("Informe um CPF válido.");
            return;
        }

        if ("Membro".equals(tipo)) {
            Membro m = ServiceFacade.membroRepo.procurarMembro(cpf);
            if (m == null) {
                outputArea.setText("Membro não encontrado. Verifique o CPF.");
                return;
            }
            ServiceFacade.setLoggedMember(m);
            outputArea.setText("Login realizado como MEMBRO: " + m.getNome());
            updateButtons(true);
        } else { // Instrutor
            Instrutor i = ServiceFacade.instrutorRepo.procurarInstrutor(cpf);
            if (i == null) {
                outputArea.setText("Instrutor não encontrado. Verifique o CPF.");
                return;
            }
            ServiceFacade.setLoggedInstrutor(i);
            outputArea.setText("Login realizado como INSTRUTOR: " + i.getNome());
            updateButtons(true);
        }
    }

    @FXML
    private void onSair() {
        ServiceFacade.clearSession();
        outputArea.setText("Sessão finalizada.");
        updateButtons(false);
    }

    private void updateButtons(boolean logged) {
        btnOpenDashboard.setDisable(!logged);
        btnOpenPayments.setDisable(!logged);
    }

    @FXML
    private void openDashboard() {
        try {
            Stage stage = (Stage) cpfField.getScene().getWindow();
            Parent pane = FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));
            stage.setTitle("Sistema da Academia - Dashboard");
            stage.getScene().setRoot(pane);
        } catch (Exception e) {
            e.printStackTrace();
            outputArea.setText("Erro ao abrir dashboard: " + e.getMessage());
        }
    }

    @FXML
    private void openPayments() {
        try {
            Stage stage = (Stage) cpfField.getScene().getWindow();
            Parent pane = FXMLLoader.load(getClass().getResource("/fxml/PaymentView.fxml"));
            stage.setTitle("Sistema da Academia - Pagamentos");
            stage.getScene().setRoot(pane);
        } catch (Exception e) {
            e.printStackTrace();
            outputArea.setText("Erro ao abrir pagamentos: " + e.getMessage());
        }
    }
}

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            errorLabel.setText("CPF ou senha inválidos!");
        }
    }
}
