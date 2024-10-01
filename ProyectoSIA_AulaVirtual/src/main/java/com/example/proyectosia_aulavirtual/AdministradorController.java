package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public class AdministradorController {

    @FXML
    private Button opCurso;

    @FXML
    private Button opProfesor;

    @FXML
    private Button opRecurso;

    @FXML
    private Button opAlumnos;

    @FXML
    private Button opVolver;

    @FXML
    public void initialize() {
        opCurso.setOnMouseEntered(event -> opCurso.setStyle("-fx-background-color: #002153;"));
        opProfesor.setOnMouseEntered(event -> opProfesor.setStyle("-fx-background-color: #002153;"));
        opRecurso.setOnMouseEntered(event -> opRecurso.setStyle("-fx-background-color: #002153;"));
        opAlumnos.setOnMouseEntered(event -> opAlumnos.setStyle("-fx-background-color: #002153;"));
        opVolver.setOnMouseEntered(event -> opVolver.setStyle("-fx-background-color: #002153;"));

        opCurso.setOnMouseExited(event -> opCurso.setStyle("-fx-background-color: #003380;"));
        opProfesor.setOnMouseExited(event -> opProfesor.setStyle("-fx-background-color: #003380;"));
        opRecurso.setOnMouseExited(event -> opRecurso.setStyle("-fx-background-color: #003380;"));
        opAlumnos.setOnMouseExited(event -> opAlumnos.setStyle("-fx-background-color: #003380;"));
        opVolver.setOnMouseExited(mouseEvent -> opVolver.setStyle("-fx-background-color: #003380;"));

        opCurso.setOnAction(event -> openWindow("Curso.fxml", "Ventana Curso", opCurso));
        opProfesor.setOnAction(event -> openWindow("Profesor.fxml", "Ventana Profesor", opProfesor));
        opRecurso.setOnAction(event -> openWindow("Recurso.fxml", "Ventana Recurso", opRecurso));
        opAlumnos.setOnAction(event -> openWindow("Alumno.fxml", "Ventana Alumnos", opAlumnos));

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
