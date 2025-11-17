package main.java.com.academia;

import com.academia.backend.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AlunosController {
    @FXML private TableView<Aluno> alunosTable;
    @FXML private TableColumn<Aluno, String> nomeCol;
    @FXML private TableColumn<Aluno, String> cpfCol;
    @FXML private TableColumn<Aluno, String> planoCol;

    private ObservableList<Aluno> alunosList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cpfCol.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        planoCol.setCellValueFactory(new PropertyValueFactory<>("plano"));
        alunosList.add(new Aluno("João", "12345678900", "Mensal"));
        alunosTable.setItems(alunosList);
    }

    @FXML private void addAluno() {}
    @FXML private void editAluno() {}
    @FXML private void deleteAluno() {}
    @FXML private void backToDashboard() {}
}
