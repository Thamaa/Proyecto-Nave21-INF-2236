package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CrearProfesorController {

    @FXML
    private Button buttonVolverMenu;

    @FXML
    private Button buttonCrearProfesor;

    @FXML
    private TextField textFieldNombreProfesor;

    @FXML
    private TextField textFieldApellidoProfesor;

    @FXML
    private TextField textFieldEdadProfesor;

    @FXML
    private TextField textFieldRutProfesor;

    @FXML
    private Label labelAulaVirtual;

    @FXML
    private Label labelCrearProfesor;

    @FXML
    private Label labelDatos;

    @FXML
    private Label labelTechnologicalSchool;

    @FXML
    public void initialize() {
        buttonVolverMenu.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> buttonVolverMenu.setStyle("-fx-background-color: #3a6aa1;"));
        buttonVolverMenu.addEventHandler(MouseEvent.MOUSE_EXITED, event -> buttonVolverMenu.setStyle("-fx-background-color: #1d4e96;"));

        buttonCrearProfesor.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> buttonCrearProfesor.setStyle("-fx-background-color: #3a6aa1;"));
        buttonCrearProfesor.addEventHandler(MouseEvent.MOUSE_EXITED, event -> buttonCrearProfesor.setStyle("-fx-background-color: #1d4e96;"));
        buttonVolverMenu.setOnAction(event -> volverMenuPrincipal());
        buttonCrearProfesor.setOnAction(event -> crearProfesor());
    }

    private void volverMenuPrincipal() {
        try {
            // Cargar el archivo FXML del menú del profesor
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Profesor.fxml"));
            Parent root = loader.load();

            // Obtener la ventana actual y establecer la nueva escena
            Stage stage = (Stage) buttonVolverMenu.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

            System.out.println("Volviendo al menú del profesor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void crearProfesor() {
        String nombre = textFieldNombreProfesor.getText();
        String apellido = textFieldApellidoProfesor.getText();
        String edad = textFieldEdadProfesor.getText();
        String rut = textFieldRutProfesor.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || edad.isEmpty() || rut.isEmpty()) {
            System.out.println("Por favor complete todos los campos.");
            return;
        }
        System.out.println("Profesor creado: " + nombre + " " + apellido + ", Edad: " + edad + ", RUT: " + rut);
    }
}
