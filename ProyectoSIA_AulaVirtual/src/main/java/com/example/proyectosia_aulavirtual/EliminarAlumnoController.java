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

public class EliminarAlumnoController {

    @FXML
    private Button btnVolverMenu;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField txtRutAlumno;

    @FXML
    private TableView<?> tablaAlumnos;

    @FXML
    private TableColumn<?, ?> columnaNombre;

    @FXML
    private TableColumn<?, ?> columnaApellido;

    @FXML
    private TableColumn<?, ?> columnaRut;

    @FXML
    public void initialize() {
        btnEliminar.setOnMouseEntered(event -> btnEliminar.setStyle("-fx-background-color: #002153;"));
        btnEliminar.setOnMouseExited(event -> btnEliminar.setStyle("-fx-background-color: #1d4e96;"));

        btnVolverMenu.setOnMouseEntered(event -> btnVolverMenu.setStyle("-fx-background-color: #002153;"));
        btnVolverMenu.setOnMouseExited(event -> btnVolverMenu.setStyle("-fx-background-color: #1d4e96;"));

        btnEliminar.setOnAction(event -> eliminarAlumno());
        btnVolverMenu.setOnAction(event -> volverAlMenu());
    }

    private void eliminarAlumno() {
        String rut = txtRutAlumno.getText();
        System.out.println("Eliminar alumno con RUT: " + rut);
    }

    private void volverAlMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Alumno.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) btnVolverMenu.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
