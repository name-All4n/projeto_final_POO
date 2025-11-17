package com.academia.controller;

import com.academia.model.treino.Exercicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TreinosController {

    @FXML private TableView<Exercicio> treinosTable;
    @FXML private TableColumn<Exercicio, String> nomeCol;
    @FXML private TableColumn<Exercicio, String> exerciciosCol;

    private ObservableList<Exercicio> treinosList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        // Liga as colunas às propriedades do modelo Exercicio
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        exerciciosCol.setCellValueFactory(new PropertyValueFactory<>("instrucao"));
        // OBS: você pode ajustar o nome da propriedade dependendo do atributo real da classe Exercicio

        treinosTable.setItems(treinosList);
    }

    @FXML
    private void addTreino() {
        // TODO: adicionar lógica
    }

    @FXML
    private void editTreino() {
        // TODO: adicionar lógica
    }

    @FXML
    private void deleteTreino() {
        // TODO: adicionar lógica
    }

    @FXML
    private void backToDashboard() {
        // TODO: voltar para o dashboard
    }
}
