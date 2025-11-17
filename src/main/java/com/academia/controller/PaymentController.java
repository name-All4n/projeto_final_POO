package com.academia.controller;

import com.academia.services.ServiceFacade;
import com.academia.model.pessoa.Membro;
import com.academia.model.plano.Plano;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class PaymentController {

    @FXML private ComboBox<Membro> cbMembros;
    @FXML private ComboBox<Plano> cbPlanos;
    @FXML private TextField amountField;
    @FXML private TextArea outputArea;

    @FXML
    public void initialize() {
        refresh();
    }

    private void refresh() {
        List<Membro> membros = ServiceFacade.membroRepo.listarMembros();
        cbMembros.setItems(FXCollections.observableArrayList(membros));

        List<Plano> planos = ServiceFacade.planoRepo.listarPlanos();
        cbPlanos.setItems(FXCollections.observableArrayList(planos));
    }

    @FXML
    private void onRegistrarPagamento() {
        Membro m = cbMembros.getSelectionModel().getSelectedItem();
        Plano p = cbPlanos.getSelectionModel().getSelectedItem();
        String amountTxt = amountField.getText();

        if (m == null) {
            outputArea.setText("Selecione um membro.");
            return;
        }
        if (p == null) {
            outputArea.setText("Selecione um plano.");
            return;
        }
        double amount = 0;
        try {
            amount = Double.parseDouble(amountTxt.replace(",", "."));
        } catch (Exception e) {
            outputArea.setText("Valor inválido. Use somente números.");
            return;
        }

        // Simples lógica de pagamento integrada ao backend disponível:
        // - se o membro não tem matrícula: chamar atualizar(cpf, null, plano) para criar
        // - se tem matrícula vencida: renovarMatricula(cpf)
        // - se já ativa: informar e oferecer renovar
        StringBuilder sb = new StringBuilder();
        sb.append("Registrando pagamento de ").append(NumberFormat.getCurrencyInstance(new Locale("pt","BR")).format(amount))
          .append(" para ").append(m.getNome()).append("\\n");

        if (m.getMatricula() == null) {
            // cria matrícula usando atualizar (backend: novo Matricula(plano))
            ServiceFacade.membroRepo.atualizar(m.getCpf(), null, p);
            sb.append("Matrícula criada para o plano: ").append(p.getNome()).append("\\n");
        } else {
            boolean ativa = m.getMatricula().isAtiva();
            if (!ativa) {
                ServiceFacade.membroRepo.renovarMatricula(m.getCpf());
                sb.append("Matrícula renovada (vencida -> renovada) para ").append(m.getNome()).append("\\n");
            } else {
                sb.append("Matrícula já está ativa. Se deseja, pode renovar manualmente.\\n");
                // opcional: perguntar confirmação para renovar mesmo assim
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Matrícula já ativa. Deseja renovar de qualquer forma?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> res = a.showAndWait();
                if (res.isPresent() && res.get() == ButtonType.YES) {
                    ServiceFacade.membroRepo.renovarMatricula(m.getCpf());
                    sb.append("Matrícula renovada por solicitação.\\n");
                } else {
                    sb.append("Nenhuma alteração feita na matrícula.\\n");
                }
            }
        }

        // Log simples do "pagamento" no frontend (não persiste)
        sb.append("\\nPagamento processado (registro em memória apenas):\\n")
          .append(" - Membro: ").append(m.getNome()).append("\\n")
          .append(" - Plano: ").append(p.getNome()).append("\\n")
          .append(" - Valor: ").append(NumberFormat.getCurrencyInstance(new Locale("pt","BR")).format(amount));

        outputArea.setText(sb.toString());

        // Atualiza comboboxes (em caso de mudança de matrícula)
        refresh();
    }

    @FXML
    private void onVoltar() {
        try {
            Stage stage = (Stage) amountField.getScene().getWindow();
            Parent pane = FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));
            stage.getScene().setRoot(pane);
            stage.setTitle("Sistema da Academia - Dashboard");
        } catch (Exception e) {
            e.printStackTrace();
            outputArea.setText("Erro ao voltar: " + e.getMessage());
        }
    }
}
