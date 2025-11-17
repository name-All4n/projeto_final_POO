package com.academia.controller;

import com.academia.model.Pagamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PagamentosController {

    @FXML private TableView<Pagamento> pagamentosTable;
    @FXML private TableColumn<Pagamento, String> alunoCol;
    @FXML private TableColumn<Pagamento, String> valorCol;

    private ObservableList<Pagamento> pagamentosList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        alunoCol.setCellValueFactory(new PropertyValueFactory<>("aluno"));
        valorCol.setCellValueFactory(new PropertyValueFactory<>("valor"));

        pagamentosList.add(new Pagamento("João", "R$50,00"));

        pagamentosTable.setItems(pagamentosList);
    }

    @FXML private void addPagamento() {}
    @FXML private void editPagamento() {}
    @FXML private void deletePagamento() {}
    @FXML private void backToDashboard() {}
}
