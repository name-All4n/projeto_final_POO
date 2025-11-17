package com.academia.controller;

import com.academia.model.plano.Plano;
import com.academia.model.plano.PlanoMusculacao;
import com.academia.model.plano.PlanoPremium;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PlanosController {

    @FXML private TableView<Plano> planosTable;
    @FXML private TableColumn<Plano, String> nomeCol;
    @FXML private TableColumn<Plano, Double> precoCol;

    private ObservableList<Plano> planosList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {

        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        precoCol.setCellValueFactory(new PropertyValueFactory<>("preco"));

        // Exemplos de planos disponíveis
        planosList.add(new PlanoMusculacao());
        planosList.add(new PlanoPremium());

        planosTable.setItems(planosList);
    }

    @FXML private void addPlano() {}
    @FXML private void editPlano() {}
    @FXML private void deletePlano() {}
    @FXML private void backToDashboard() {}
}
