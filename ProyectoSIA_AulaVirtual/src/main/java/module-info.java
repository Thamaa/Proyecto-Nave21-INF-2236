module com.example.proyectosia_aulavirtual {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.proyectosia_aulavirtual to javafx.fxml;
    exports com.example.proyectosia_aulavirtual;
}