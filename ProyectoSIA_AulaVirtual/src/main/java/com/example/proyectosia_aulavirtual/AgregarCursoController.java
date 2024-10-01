package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AgregarCursoController {

    @FXML
    private Label idCursoLabel;

    @FXML
    private TextField nombreCursoField;

    @FXML
    private Label mensajeLabel;

    @FXML
    private Button registrarBtn;

    @FXML
    private Button volverBtn;

    private int idCurso;

    @FXML
    public void initialize() {
        idCurso = generarIdCurso();
        idCursoLabel.setText(String.valueOf(idCurso));

        registrarBtn.setOnAction(event -> registrarCurso());
        volverBtn.setOnAction(event -> volverAlMenuP());
    }

    private void registrarCurso() {
        String nombreCurso = nombreCursoField.getText().trim();

        if (nombreCurso.isEmpty()) {
            mensajeLabel.setText("Por favor, ingrese un nombre.");
        } else {
            System.out.println("Curso registrado: ID = " + idCurso + ", Nombre = " + nombreCurso);
            mensajeLabel.setText("Curso registrado exitosamente");

            registrarBtn.setDisable(true);

        }
    }

    private int generarIdCurso() {
        return (int) (Math.random() * 1000 + 1);
    }

    private void volverAlMenuP() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Curso.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) volverBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
