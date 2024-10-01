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

    public class AgregarYCrearAlumnoController {

        @FXML
        private Button btnVolverMenu;

        @FXML
        private Button btnAgregar;

        @FXML
        private TextField txtNombre;

        @FXML
        private TextField txtApellido;

        @FXML
        private TextField txtEdad;

        @FXML
        private TextField txtRut;

        @FXML
        private TextField txtCursoID;

        @FXML
        private TableView<?> tablaCursos;

        @FXML
        private TableColumn<?, ?> columnaID;

        @FXML
        private TableColumn<?, ?> columnaNombre;

        @FXML
        public void initialize() {
            btnAgregar.setOnMouseEntered(event -> btnAgregar.setStyle("-fx-background-color: #002153;"));
            btnAgregar.setOnMouseExited(event -> btnAgregar.setStyle("-fx-background-color: #1d4e96;"));
            btnVolverMenu.setOnMouseEntered(event -> btnVolverMenu.setStyle("-fx-background-color: #002153;"));
            btnVolverMenu.setOnMouseExited(event -> btnVolverMenu.setStyle("-fx-background-color: #1d4e96;"));
            btnAgregar.setOnAction(event -> agregarAlumno());
            btnVolverMenu.setOnAction(event -> volverAlMenuAlumno());
        }

        private void agregarAlumno() {
            System.out.println("Agregar alumno: " + txtNombre.getText() + " " + txtApellido.getText());
        }

        private void volverAlMenuAlumno() {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Alumno.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) btnVolverMenu.getScene().getWindow();
                stage.setScene(new Scene(root));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
