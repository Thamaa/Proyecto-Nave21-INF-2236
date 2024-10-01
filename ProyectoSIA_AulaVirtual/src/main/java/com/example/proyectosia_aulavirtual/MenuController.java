package com.example.proyectosia_aulavirtual;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button btnAdministrador;

    @FXML
    private Button btnProfesor;

    @FXML
    private Button btnCurso;

    @FXML
    private Button btnAlumno;

    @FXML
    private Button btnSalir;

    @FXML
    public void initialize() {
        btnAdministrador.setOnMouseEntered(event -> btnAdministrador.setStyle("-fx-background-color: #002153;"));
        btnProfesor.setOnMouseEntered(event -> btnProfesor.setStyle("-fx-background-color: #002153;"));
        btnCurso.setOnMouseEntered(event -> btnCurso.setStyle("-fx-background-color: #002153;"));
        btnAlumno.setOnMouseEntered(event -> btnAlumno.setStyle("-fx-background-color: #002153;"));
        btnSalir.setOnMouseEntered(event -> btnSalir.setStyle("-fx-background-color: #002153;"));


        btnAdministrador.setOnMouseExited(event -> btnAdministrador.setStyle("-fx-background-color: #003380;"));
        btnProfesor.setOnMouseExited(event -> btnProfesor.setStyle("-fx-background-color: #003380;"));
        btnCurso.setOnMouseExited(event -> btnCurso.setStyle("-fx-background-color: #003380;"));
        btnAlumno.setOnMouseExited(event -> btnAlumno.setStyle("-fx-background-color: #003380;"));
        btnSalir.setOnMouseExited(event -> btnSalir.setStyle("-fx-background-color: #003380;"));


        btnAdministrador.setOnAction(event -> openWindow("Admin.fxml", "Ventana Administrador", btnAdministrador));
        btnProfesor.setOnAction(event -> openWindow("Profesor.fxml", "Ventana Profesor", btnProfesor));
        btnCurso.setOnAction(event -> openWindow("Curso.fxml", "Ventana Curso", btnCurso));
        btnAlumno.setOnAction(event -> openWindow("Alumno.fxml", "Ventana Alumno", btnAlumno));
        btnSalir.setOnAction(event -> Platform.exit());

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
