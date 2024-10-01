package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfesorController {

    @FXML
    private Button agregarP;

    @FXML
    private Button eliminarP;

    @FXML
    private Button crearP;

    @FXML
    private Button mostrarP;

    @FXML
    private Button opVolver;

    @FXML
    public void initialize() {
        // Cambiar estilos cuando el mouse pasa por encima de los botones
        agregarP.setOnMouseEntered(event -> agregarP.setStyle("-fx-background-color: #002153;"));
        agregarP.setOnMouseExited(event -> agregarP.setStyle("-fx-background-color: #1d4e96;"));
        eliminarP.setOnMouseEntered(event -> eliminarP.setStyle("-fx-background-color: #002153;"));
        eliminarP.setOnMouseExited(event -> eliminarP.setStyle("-fx-background-color: #1d4e96;"));
        crearP.setOnMouseEntered(event -> crearP.setStyle("-fx-background-color: #002153;"));
        crearP.setOnMouseExited(event -> crearP.setStyle("-fx-background-color: #1d4e96;"));
        mostrarP.setOnMouseEntered(event -> mostrarP.setStyle("-fx-background-color: #002153;"));
        mostrarP.setOnMouseExited(event -> mostrarP.setStyle("-fx-background-color: #1d4e96;"));
        opVolver.setOnMouseEntered(event -> opVolver.setStyle("-fx-background-color: #002153;"));
        opVolver.setOnMouseExited(event -> opVolver.setStyle("-fx-background-color: #1d4e96;"));

        agregarP.setOnAction(event -> openWindow("asignarProfesorPT2.fxml", "Agregar Profesor", agregarP));
        eliminarP.setOnAction(event -> openWindow("eliminarProfesor.fxml", "Eliminar Profesor", eliminarP));
        crearP.setOnAction(event -> openWindow("crearProfesor.fxml", "Asignar Profesor", crearP));
        mostrarP.setOnAction(event -> openWindow("mostrarProfesores.fxml", "Mostrar Profesores", mostrarP));
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
