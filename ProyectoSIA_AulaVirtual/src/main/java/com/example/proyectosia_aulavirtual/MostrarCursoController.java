package com.example.proyectosia_aulavirtual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.io.IOException;

public class MostrarCursoController {

    @FXML
    private Label lblTitulo;

    @FXML
    private Label lblSubtitulo;

    @FXML
    private Label lblCursos;

    @FXML
    private Button btnVolverMenu;

    @FXML
    private TableView<Curso> tableCursos;

    @FXML
    private TableColumn<Curso, Integer> colID;

    @FXML
    private TableColumn<Curso, String> colNombreCurso;

    private ObservableList<Curso> cursosList;

    @FXML
    public void initialize() {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombreCurso.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        cursosList = FXCollections.observableArrayList(
                new Curso(1, "Matemáticas"),
                new Curso(2, "Física"),
                new Curso(3, "Historia"),
                new Curso(4, "Lengua")
        );

        tableCursos.setItems(cursosList);

        btnVolverMenu.setOnMouseEntered(event -> btnVolverMenu.setStyle("-fx-background-color: #002153;"));
        btnVolverMenu.setOnMouseExited(event -> btnVolverMenu.setStyle("-fx-background-color: #1d4e96;"));

        btnVolverMenu.setOnAction(event -> volverAlMenu());
    }

    private void volverAlMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Curso.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Menú Principal");
            stage.setScene(new Scene(root));
            stage.show();

            Stage currentStage = (Stage) btnVolverMenu.getScene().getWindow();
            currentStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Curso {
        private final Integer id;
        private final String nombre;

        public Curso(Integer id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public Integer getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }
    }
}
