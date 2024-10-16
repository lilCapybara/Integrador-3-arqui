package org.example.dto;

public class InscripcionDTO {
    private int idInscripcion;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private String nombreCarrera;
    private Integer antiguedad;
    private Integer anioInscripcion;
    private boolean graduado;

    public InscripcionDTO(int idInscripcion, String nombreEstudiante, String apellidoEstudiante, String nombreCarrera, Integer antiguedad, Integer anioInscripcion, boolean graduado) {
        this.idInscripcion = idInscripcion;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidoEstudiante = apellidoEstudiante;
        this.nombreCarrera = nombreCarrera;
        this.antiguedad = antiguedad;
        this.anioInscripcion = anioInscripcion;
        this.graduado = graduado;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Integer getAnioInscripcion() {
        return anioInscripcion;
    }

    public void setAnioInscripcion(Integer anioInscripcion) {
        this.anioInscripcion = anioInscripcion;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }
}
