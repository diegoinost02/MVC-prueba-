package com.example.pruebamvc.controlador;

import com.example.pruebamvc.Jackson;
import com.example.pruebamvc.Main;
import com.example.pruebamvc.modelo.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class LoginControlador {

    @FXML
    private Label usuario;
    @FXML
    private TextField txtUsuario;
    @FXML
    private Label contraseña;
    @FXML
    private TextField txtContraseña;
    @FXML
    private Button btnIngresar;
    @FXML
    private Label aviso;

    @FXML
    private Button crear;

    @FXML
    void ingresar(ActionEvent event) throws IOException {

        Main m = new Main();

        String pathJson = "src/main/java/com/example/pruebamvc/usuarios.json";
        ArrayList<Persona> usuarios = Jackson.deserializarArrayList(pathJson, Persona.class);

        if (txtUsuario.getText().isEmpty() || txtContraseña.getText().isEmpty()) {
            aviso.setText("Debe completar todos los campos");
            aviso.setAlignment(Pos.CENTER);

        } else {
            Persona persona = new Persona(txtUsuario.getText(), txtContraseña.getText());

            if (usuarios != null && usuarios.contains(persona)) {
                for (Persona p : usuarios) {

                    if (p.equals(persona)) {

                        if (p.getContraseña().equals(persona.getContraseña())) {
                            m.changeScene("vista/bienvenida.fxml","Sistema");
                        } else {
                            aviso.setText("Contraseña incorrecta");
                            aviso.setAlignment(Pos.CENTER);
                        }
                        break;
                    }
                }
            } else {
                aviso.setText("No se encontro el usuario");
                aviso.setAlignment(Pos.CENTER);
                txtUsuario.setText("");
                txtContraseña.setText("");
            }
        }
    }

    @FXML
    void crear(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("vista/crearUsuario.fxml","Crear usuario");
    }
}
