package com.androiddesdecero.toolbar;

/**
 * Created by albertopalomarrobledo on 12/11/18.
 */

public class Curso {

    private String profesor;
    private String nombreCurso;

    public Curso(String profesor, String nombreCurso) {
        this.profesor = profesor;
        this.nombreCurso = nombreCurso;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
}
