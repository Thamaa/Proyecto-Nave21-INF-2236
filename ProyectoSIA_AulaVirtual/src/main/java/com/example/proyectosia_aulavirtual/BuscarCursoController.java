package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

import java.io.IOException;

public class BuscarCursoController {

    @FXML
    private Button opVolver;

    @FXML
    private TreeTableView<?> treeTableView;

    @FXML
    public void initialize() {
        opVolver.setOnMouseEntered(event -> opVolver.setStyle("-fx-background-color: #002153;"));
        opVolver.setOnMouseExited(event -> opVolver.setStyle("-fx-background-color: #1d4e96;"));

        opVolver.setOnAction(event -> openWindow("Curso.fxml", "Menú Principal"));
    }

    private void openWindow(String fxmlFile, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

            Stage currentStage = (Stage) opVolver.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
