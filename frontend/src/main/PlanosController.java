package main;

import com.academia.backend.Plano;
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
        planosList.add(new Plano("Mensal", 50.0));
        planosTable.setItems(planosList);
    }

    @FXML private void addPlano() {}
    @FXML private void editPlano() {}
    @FXML private void deletePlano() {}
    @FXML private void backToDashboard() {}
}
