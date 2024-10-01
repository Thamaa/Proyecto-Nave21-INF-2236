package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EliminarRecursoController {

    @FXML
    private Button btnVolverMenu;

    @FXML
    private Button btnEliminarRecurso;

    @FXML
    private TextField inputCursoID;

    @FXML
    private TableView<?> tablaRecursos;

    @FXML
    private TableColumn<?, ?> columnaID;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    public void initialize() {
        btnVolverMenu.setOnMouseEntered(event -> btnVolverMenu.setStyle("-fx-background-color: #002153;"));
        btnVolverMenu.setOnMouseExited(event -> btnVolverMenu.setStyle("-fx-background-color: #1d4e96;"));

        btnEliminarRecurso.setOnMouseEntered(event -> btnEliminarRecurso.setStyle("-fx-background-color: #002153;"));
        btnEliminarRecurso.setOnMouseExited(event -> btnEliminarRecurso.setStyle("-fx-background-color: #1d4e96;"));

        btnVolverMenu.setOnAction(event -> openWindow("MenuPrincipal.fxml", "Menú Principal", btnVolverMenu));
        btnEliminarRecurso.setOnAction(event -> eliminarRecurso());
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

    private void eliminarRecurso() {
        String cursoID = inputCursoID.getText();
        if (cursoID.isEmpty()) {
            System.out.println("Debe ingresar el ID del curso.");
        } else {
            System.out.println("Recurso eliminado del curso con ID: " + cursoID);
        }
    }
}
