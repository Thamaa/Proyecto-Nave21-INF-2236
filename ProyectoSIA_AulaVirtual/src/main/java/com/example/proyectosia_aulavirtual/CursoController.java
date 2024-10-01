package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CursoController {

    @FXML
    private Button agregarC;

    @FXML
    private Button eliminarC;

    @FXML
    private Button buscarC;

    @FXML
    private Button mostrarC;

    @FXML
    private Button opVolver;

    @FXML
    public void initialize() {
        agregarC.setOnMouseEntered(event -> agregarC.setStyle("-fx-background-color: #002153;"));
        agregarC.setOnMouseExited(event -> agregarC.setStyle("-fx-background-color: #1d4e96;"));
        eliminarC.setOnMouseEntered(event -> eliminarC.setStyle("-fx-background-color: #002153;"));
        eliminarC.setOnMouseExited(event -> eliminarC.setStyle("-fx-background-color: #1d4e96;"));
        buscarC.setOnMouseEntered(event -> buscarC.setStyle("-fx-background-color: #002153;"));
        buscarC.setOnMouseExited(event -> buscarC.setStyle("-fx-background-color: #1d4e96;"));
        mostrarC.setOnMouseEntered(event -> mostrarC.setStyle("-fx-background-color: #002153;"));
        mostrarC.setOnMouseExited(event -> mostrarC.setStyle("-fx-background-color: #1d4e96;"));
        opVolver.setOnMouseEntered(event -> opVolver.setStyle("-fx-background-color: #002153;"));
        opVolver.setOnMouseExited(event -> opVolver.setStyle("-fx-background-color: #1d4e96;"));

        // Asignar acciones a los botones para abrir nuevas ventanas
        agregarC.setOnAction(event -> openWindow("agregarCurso.fxml", "Agregar Curso", agregarC));
        eliminarC.setOnAction(event -> openWindow("eliminarCurso.fxml", "Eliminar Curso", eliminarC));
        buscarC.setOnAction(event -> openWindow("buscarCurso.fxml", "Buscar Curso", buscarC));
        mostrarC.setOnAction(event -> openWindow("mostrarCurso.fxml", "Mostrar Cursos", mostrarC));
        opVolver.setOnAction(event -> openWindow("MenuPrincipal.fxml", "Menú Principal", opVolver));
    }

    private void openWindow(String fxmlFile, String title, Button button) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

            Stage currentStage = (Stage) button.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
