package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PagamentosController {
    @FXML private TableView<String> pagamentosTable;
    @FXML private TableColumn<String, String> alunoCol;
    @FXML private TableColumn<String, String> valorCol;

    private ObservableList<String> pagamentosList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        alunoCol.setCellValueFactory(new PropertyValueFactory<>("aluno"));
        valorCol.setCellValueFactory(new PropertyValueFactory<>("valor"));
        pagamentosList.add("João - R$50.00");
        pagamentosTable.setItems(pagamentosList);
    }

    @FXML private void addPagamento() {}
    @FXML private void editPagamento() {}
    @FXML private void deletePagamento() {}
    @FXML private void backToDashboard() {}
}
