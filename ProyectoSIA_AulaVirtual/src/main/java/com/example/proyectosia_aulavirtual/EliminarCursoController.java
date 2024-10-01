package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

public class EliminarCursoController {

    @FXML
    private Button btnVolver;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField txtIdCurso;

    @FXML
    public void initialize() {
        btnVolver.setOnMouseEntered(event -> btnVolver.setStyle("-fx-background-color: #002153;"));
        btnEliminar.setOnMouseEntered(event -> btnEliminar.setStyle("-fx-background-color: #002153;"));

        btnVolver.setOnMouseExited(event -> btnVolver.setStyle("-fx-background-color: #1d4e96;"));
        btnEliminar.setOnMouseExited(event -> btnEliminar.setStyle("-fx-background-color: #1d4e96;"));

        btnVolver.setOnAction(event -> openWindow("Curso.fxml", "Menú Curso", btnVolver));
        btnEliminar.setOnAction(event -> eliminarCurso());
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

    private void eliminarCurso() {
        String idCurso = txtIdCurso.getText();

        if (idCurso.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, ingresa un ID de curso.");
            alert.showAndWait();
        } else {
            System.out.println("Curso con ID " + idCurso + " eliminado.");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Curso Eliminado");
            alert.setHeaderText(null);
            alert.setContentText("El curso con ID " + idCurso + " ha sido eliminado exitosamente.");
            alert.showAndWait();

            txtIdCurso.clear();
        }
    }
}
