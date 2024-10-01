package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AlumnoController {

    @FXML
    private Button btnCrearAlumno;

    @FXML
    private Button btnEliminarAlumno;

    @FXML
    private Button btnMostrarAlumnos;

    @FXML
    private Button btnVolverMenu;

    @FXML
    public void initialize() {
        btnCrearAlumno.setOnMouseEntered(event -> btnCrearAlumno.setStyle("-fx-background-color: #002153;"));
        btnCrearAlumno.setOnMouseExited(event -> btnCrearAlumno.setStyle("-fx-background-color: #1d4e96;"));

        btnEliminarAlumno.setOnMouseEntered(event -> btnEliminarAlumno.setStyle("-fx-background-color: #002153;"));
        btnEliminarAlumno.setOnMouseExited(event -> btnEliminarAlumno.setStyle("-fx-background-color: #1d4e96;"));

        btnMostrarAlumnos.setOnMouseEntered(event -> btnMostrarAlumnos.setStyle("-fx-background-color: #002153;"));
        btnMostrarAlumnos.setOnMouseExited(event -> btnMostrarAlumnos.setStyle("-fx-background-color: #1d4e96;"));

        btnVolverMenu.setOnMouseEntered(event -> btnVolverMenu.setStyle("-fx-background-color: #002153;"));
        btnVolverMenu.setOnMouseExited(event -> btnVolverMenu.setStyle("-fx-background-color: #1d4e96;"));

        btnCrearAlumno.setOnAction(event -> openWindow("crearAgregarAlumnoACurso.fxml", "Crear Alumno", btnCrearAlumno));
        btnEliminarAlumno.setOnAction(event -> openWindow("eliminarAlumno.fxml", "Eliminar Alumno", btnEliminarAlumno));
        btnMostrarAlumnos.setOnAction(event -> openWindow("mostrarAlumnos.fxml", "Mostrar Alumnos", btnMostrarAlumnos));
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

            Stage currentStage = (Stage) button.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
