module com.example.pruebamvc {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    opens com.example.pruebamvc to javafx.fxml;
    exports com.example.pruebamvc;
    exports com.example.pruebamvc.controlador;
    exports com.example.pruebamvc.modelo;
    opens com.example.pruebamvc.controlador to javafx.fxml;
}