package com.example.pruebamvc.controlador;

import com.example.pruebamvc.Jackson;
import com.example.pruebamvc.Main;
import com.example.pruebamvc.modelo.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CrearUsuarioControlador {
    @FXML
    TextField txtUsuario;
    @FXML
    TextField txtContraseña;
    @FXML
    Label txtAviso;

    @FXML
    void crear(ActionEvent event) throws IOException{

        Main m = new Main();

        String pathJson = "src/main/java/com/example/pruebamvc/usuarios.json";
        Persona persona = new Persona(txtUsuario.getText(), txtContraseña.getText());
        ArrayList<Persona> usuarios = Jackson.deserializarArrayList(pathJson, Persona.class);

        if (usuarios != null) {
            if (!usuarios.contains(persona)) {
                usuarios.add(persona);
                Jackson.serializar(usuarios, pathJson);
                m.changeScene("vista/login.fxml","Inicio");
            } else {
                txtAviso.setText("Nombre de usuario no disponible");
                txtAviso.setAlignment(Pos.CENTER);
                txtUsuario.setText("");
                txtContraseña.setText("");
            }
        }
        else{
            usuarios = new ArrayList<>(Arrays.asList(persona));
            Jackson.serializar(usuarios, pathJson);
            m.changeScene("vista/login.fxml","Inicio");
        }
    }
    @FXML
    void volver(ActionEvent event) throws IOException{

        Main m = new Main();
        m.changeScene("vista/login.fxml","Inicio");
    }
}
