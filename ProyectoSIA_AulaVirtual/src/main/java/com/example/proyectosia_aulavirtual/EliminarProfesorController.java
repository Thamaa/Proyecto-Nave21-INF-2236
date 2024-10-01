package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
public class EliminarProfesorController {

    @FXML
    private Button buttonVolverMenu;

    @FXML
    private Button buttonEliminarProfesor;

    @FXML
    public void initialize() {
        buttonVolverMenu.setOnMouseEntered(event -> buttonVolverMenu.setStyle("-fx-background-color: #002153;"));
        buttonVolverMenu.setOnMouseExited(event -> buttonVolverMenu.setStyle("-fx-background-color: #1d4e96;"));

        buttonEliminarProfesor.setOnMouseEntered(event -> buttonEliminarProfesor.setStyle("-fx-background-color: #002153;"));
        buttonEliminarProfesor.setOnMouseExited(event -> buttonEliminarProfesor.setStyle("-fx-background-color: #1d4e96;"));

        buttonVolverMenu.setOnAction(event -> openWindow("Profesor.fxml", "Menú Profesor", buttonVolverMenu));
        buttonEliminarProfesor.setOnAction(event -> eliminarProfesor());
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

    private void eliminarProfesor() {
        // Implementar lógica para eliminar al profesor utilizando el RUT ingresado
        // Ejemplo: obtener el texto del TextField, realizar búsqueda en la base de datos o lista.
    }
}
