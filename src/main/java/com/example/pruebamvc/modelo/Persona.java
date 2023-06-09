package com.example.pruebamvc.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Persona implements Serializable{
    private String usuario;
    private String contraseña;

    public Persona(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    public Persona(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(usuario, persona.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
