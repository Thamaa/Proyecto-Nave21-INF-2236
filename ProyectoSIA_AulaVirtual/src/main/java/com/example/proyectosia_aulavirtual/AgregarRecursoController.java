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

public class AgregarRecursoController {

    @FXML
    private Button buttonVolverMenuAdmin;

    @FXML
    private Button buttonAgregarRecurso;

    @FXML
    private TextField textFieldRutProfesor;

    @FXML
    private TextField textFieldIdRecurso;

    @FXML
    private TextField textFieldNombreRecurso;

    @FXML
    private TextField textFieldDescripcion;

    @FXML
    private TableView<?> tablaProfesores;

    @FXML
    private TableColumn<?, ?> columnaRut;

    @FXML
    private TableColumn<?, ?> columnaNombreProfesor;

    @FXML
    public void initialize() {
        buttonVolverMenuAdmin.setOnMouseEntered(event -> buttonVolverMenuAdmin.setStyle("-fx-background-color: #002153;"));
        buttonVolverMenuAdmin.setOnMouseExited(event -> buttonVolverMenuAdmin.setStyle("-fx-background-color: #1d4e96;"));

        buttonAgregarRecurso.setOnMouseEntered(event -> buttonAgregarRecurso.setStyle("-fx-background-color: #002153;"));
        buttonAgregarRecurso.setOnMouseExited(event -> buttonAgregarRecurso.setStyle("-fx-background-color: #1d4e96;"));

        buttonVolverMenuAdmin.setOnAction(event -> openWindow("Admin.fxml", "Menú Admin", buttonVolverMenuAdmin));

        buttonAgregarRecurso.setOnAction(event -> agregarRecurso());
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

    private void agregarRecurso() {
        // Aquí puedes implementar la lógica para agregar un recurso
        // Obtener datos de los campos: textFieldRutProfesor, textFieldIdRecurso, etc.
    }
}
