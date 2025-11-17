package main;

import com.academia.backend.Treino;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TreinosController {
    @FXML private TableView<Treino> treinosTable;
    @FXML private TableColumn<Treino, String> nomeCol;
    @FXML private TableColumn<Treino, String> exerciciosCol;

    private ObservableList<Treino> treinosList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        exerciciosCol.setCellValueFactory(new PropertyValueFactory<>("exercicios"));
        treinosList.add(new Treino("Treino A", "Agachamento, Supino"));
        treinosTable.setItems(treinosList);
    }

    @FXML private void addTreino() {}
    @FXML private void editTreino() {}
    @FXML private void deleteTreino() {}
    @FXML private void backToDashboard() {}
}