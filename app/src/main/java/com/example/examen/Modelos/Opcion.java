package com.example.examen.Modelos;

import android.content.Intent;
import android.net.Uri;


public class Opcion {
    private String nombre;
    private Intent accion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Intent getAccion() {
        return accion;
    }

    public void setAccion(Intent accion) {
        this.accion = accion;
    }

    public Opcion(String nombre, Intent accion) {
        this.nombre = nombre;
        this.accion = accion;
    }

}
