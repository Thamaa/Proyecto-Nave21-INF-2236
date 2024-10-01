package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RecursoController {

    @FXML
    private Button btnAgregarRecurso;

    @FXML
    private Button btnEliminarRecurso;

    @FXML
    private Button btnMostrarRecursos;

    @FXML
    private Button btnVolverMenu;

    @FXML
    public void initialize() {
        // Efectos hover en los botones
        btnAgregarRecurso.setOnMouseEntered(event -> btnAgregarRecurso.setStyle("-fx-background-color: #002153;"));
        btnAgregarRecurso.setOnMouseExited(event -> btnAgregarRecurso.setStyle("-fx-background-color: #1d4e96;"));

        btnEliminarRecurso.setOnMouseEntered(event -> btnEliminarRecurso.setStyle("-fx-background-color: #002153;"));
        btnEliminarRecurso.setOnMouseExited(event -> btnEliminarRecurso.setStyle("-fx-background-color: #1d4e96;"));

        btnMostrarRecursos.setOnMouseEntered(event -> btnMostrarRecursos.setStyle("-fx-background-color: #002153;"));
        btnMostrarRecursos.setOnMouseExited(event -> btnMostrarRecursos.setStyle("-fx-background-color: #1d4e96;"));

        btnVolverMenu.setOnMouseEntered(event -> btnVolverMenu.setStyle("-fx-background-color: #002153;"));
        btnVolverMenu.setOnMouseExited(event -> btnVolverMenu.setStyle("-fx-background-color: #1d4e96;"));

        // Asignar acciones para abrir nuevas ventanas
        btnAgregarRecurso.setOnAction(event -> openWindow("agregarRecursoACursoPT2.fxml", "Agregar Recurso", btnAgregarRecurso));
        btnEliminarRecurso.setOnAction(event -> openWindow("eliminarRecursoDeCursoPT2.fxml", "Eliminar Recurso", btnEliminarRecurso));
        btnMostrarRecursos.setOnAction(event -> openWindow("MostrarRecurso.fxml", "Mostrar Recursos", btnMostrarRecursos));
        btnVolverMenu.setOnAction(event -> openWindow("MenuPrincipal.fxml", "Menú Principal", btnVolverMenu));
    }

    private void openWindow(String fxmlFile, String title, Button button) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();

            // Cerrar la ventana actual
            Stage currentStage = (Stage) button.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
