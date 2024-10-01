package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class MostrarAlumnosController {

    @FXML
    private Button btnVolverMenuAlumno;

    @FXML
    private TableView<?> tablaAlumnos;

    @FXML
    private TableColumn<?, ?> columnaCurso;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private TableColumn<?, ?> columnaApellido;

    @FXML
    private TableColumn<?, ?> columnaRut;

    @FXML
    public void initialize() {
        btnVolverMenuAlumno.setOnMouseEntered(event -> btnVolverMenuAlumno.setStyle("-fx-background-color: #002153;"));
        btnVolverMenuAlumno.setOnMouseExited(event -> btnVolverMenuAlumno.setStyle("-fx-background-color: #1d4e96;"));

        btnVolverMenuAlumno.setOnAction(event -> volverAlMenuAlumno());
    }

    private void volverAlMenuAlumno() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alumno.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btnVolverMenuAlumno.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
