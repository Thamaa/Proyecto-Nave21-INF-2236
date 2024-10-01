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

public class MostrarProfesoresController {

    @FXML
    private Button buttonVolverMenu;

    @FXML
    private TableView<String> tablaProfesores;

    @FXML
    private TableColumn<String, String> columnaNombre;

    @FXML
    private TableColumn<String, String> columnaApellido;

    @FXML
    private TableColumn<String,String> columnaRut;

    @FXML
    public void initialize() {
        buttonVolverMenu.setOnMouseEntered(event -> buttonVolverMenu.setStyle("-fx-background-color: #002153;"));
        buttonVolverMenu.setOnMouseExited(event -> buttonVolverMenu.setStyle("-fx-background-color: #1d4e96;"));

        buttonVolverMenu.setOnAction(event -> openWindow("MenuPrincipal.fxml", "Menú Principal", buttonVolverMenu));

        cargarProfesores();
    }

    private void cargarProfesores() {
        // Aquí puedes agregar la lógica para obtener los datos de los profesores
        // Ejemplo: tablaProfesores.setItems(listaProfesores); donde listaProfesores es una ObservableList con los datos
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
