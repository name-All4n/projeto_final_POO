package com.academia.controller;

import com.academia.model.pessoa.Membro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AlunosController {
    @FXML private TableView<Membro> alunosTable;
    @FXML private TableColumn<Membro, String> nomeCol;
    @FXML private TableColumn<Membro, String> cpfCol;
    @FXML private TableColumn<Membro, String> planoCol;

    private ObservableList<Membro> alunosList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cpfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        planoCol.setCellValueFactory(new PropertyValueFactory<>("plano"));
        alunosTable.setItems(alunosList);
    }

    @FXML private void addAluno() {}
    @FXML private void editAluno() {}
    @FXML private void deleteAluno() {}
    @FXML private void backToDashboard() {}
}
