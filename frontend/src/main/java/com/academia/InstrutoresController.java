package main.java.com.academia;

import com.academia.backend.Instrutor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class InstrutoresController {
    @FXML private TableView<Instrutor> instrutoresTable;
    @FXML private TableColumn<Instrutor, String> nomeCol;
    @FXML private TableColumn<Instrutor, String> cpfCol;
    @FXML private TableColumn<Instrutor, String> especialidadeCol;

    private ObservableList<Instrutor> instrutoresList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cpfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        especialidadeCol.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
        instrutoresList.add(new Instrutor("Maria", "09876543210", "Musculação"));
        instrutoresTable.setItems(instrutoresList);
    }

    @FXML private void addInstrutor() {}
    @FXML private void editInstrutor() {}
    @FXML private void deleteInstrutor() {}
    @FXML private void backToDashboard() {}
}
