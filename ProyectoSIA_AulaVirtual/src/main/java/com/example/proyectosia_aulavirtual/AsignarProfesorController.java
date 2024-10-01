package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AsignarProfesorController {

    @FXML
    private Button buttonVolverMenu;

    @FXML
    private Button buttonAsignar;

    @FXML
    private TextField textFieldRutProfesor;

    @FXML
    private TableView<?> tableViewProfesores;

    @FXML
    private TableColumn<?, ?> columnNombreProfesor;

    @FXML
    private TableColumn<?, ?> columnRutProfesor;

    @FXML
    private Label labelAulaVirtual;

    @FXML
    private Label labelAsignarProfesor;

    @FXML
    private Label labelListaProfesores;

    @FXML
    private Label labelTechnologicalSchool;

    @FXML
    public void initialize() {
        buttonAsignar.setOnMouseEntered(event -> buttonAsignar.setStyle("-fx-background-color: #002153;"));
        buttonAsignar.setOnMouseExited(event -> buttonAsignar.setStyle("-fx-background-color: #1d4e96;"));
        buttonVolverMenu.setOnMouseEntered(event -> buttonVolverMenu.setStyle("-fx-background-color: #002153;"));
        buttonVolverMenu.setOnMouseExited(event -> buttonVolverMenu.setStyle("-fx-background-color: #1d4e96;"));
        buttonAsignar.setOnAction(event -> asignarProfesor());
        buttonVolverMenu.setOnAction(event -> volverAlMenuProfesor());
    }

    private void asignarProfesor() {
        String rut = textFieldRutProfesor.getText();
        System.out.println("Asignar profesor con RUT: " + rut);
    }

    private void volverAlMenuProfesor() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Profesor.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) buttonVolverMenu.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

            System.out.println("Volviendo al menú del profesor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
