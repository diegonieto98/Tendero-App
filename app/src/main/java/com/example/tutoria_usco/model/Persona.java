package com.example.tutoria_usco.model;

import android.text.Html;

public class Persona {

    private String Nombre;
    private String Telefono;
    private String Dias;
    private String uid;
    private String Asignatura;

    public Persona(){
    }

    public String getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(String asignatura) {
        Asignatura = asignatura;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDias() {
        return Dias;
    }

    public void setDias(String dias) {
        Dias = dias;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }


    @Override
    public String toString() {
        return "Tutor:" + Nombre + Html.fromHtml("<br/>")+ "Telefono:"+ Telefono + Html.fromHtml("<br/>") + "Horarios:" + Dias
                + Html.fromHtml("<br/>") + "Asignaturas:" + Asignatura;
    }
}
