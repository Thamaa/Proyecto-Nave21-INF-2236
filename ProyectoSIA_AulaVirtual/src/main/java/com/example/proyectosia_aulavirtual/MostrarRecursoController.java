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

public class MostrarRecursoController {

    @FXML
    private Button btnVolverMenu;

    @FXML
    private TableView<?> tablaRecursos;

    @FXML
    private TableColumn<?, ?> columnaIDRecurso;

    @FXML
    private TableColumn<?, ?> columnaNombreRecurso;

    @FXML
    private TableColumn<?, ?> columnaRUTProfesor;

    @FXML
    private TableColumn<?, ?> columnaDescripcionRecurso;

    @FXML
    private TableColumn<?, ?> columnaIDCurso;

    @FXML
    public void initialize() {
        btnVolverMenu.setOnMouseEntered(event -> btnVolverMenu.setStyle("-fx-background-color: #002153;"));
        btnVolverMenu.setOnMouseExited(event -> btnVolverMenu.setStyle("-fx-background-color: #1d4e96;"));

        btnVolverMenu.setOnAction(event -> openWindow("Admin.fxml", "Menú Principal", btnVolverMenu));
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
