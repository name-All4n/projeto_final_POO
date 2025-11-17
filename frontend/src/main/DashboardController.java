package main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class DashboardController {
    @FXML private Label contentLabel;

    private void loadView(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) contentLabel.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML private void showAlunos() { loadView("AlunosView.fxml"); }
    @FXML private void showInstrutores() { loadView("InstrutoresView.fxml"); }
    @FXML private void showPlanos() { loadView("PlanosView.fxml"); }
    @FXML private void showTreinos() { loadView("TreinosView.fxml"); }
    @FXML private void showPagamentos() { loadView("PagamentosView.fxml"); }
}