package org.example.dto;


public class EstudianteDTO {
    private int idEstudiante;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private int documento;
    private String ciudadResidencia;
    private int libretaUniversitaria;

    public EstudianteDTO(int idEstudiante,String nombre, String apellido, int edad, String genero, int documento, String ciudadResidencia, int libretaUniversitaria) {
        this.idEstudiante = idEstudiante;
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.documento = documento;
        this.ciudadResidencia = ciudadResidencia;
        this.libretaUniversitaria = libretaUniversitaria;
    }

    public int getId() {
        return idEstudiante;
    }

    public void setId(int id) {
        this.idEstudiante = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public int getLibretaUniversitaria() {
        return libretaUniversitaria;
    }

    public void setLibretaUniversitaria(int libretaUniversitaria) {
        this.libretaUniversitaria = libretaUniversitaria;
    }
}

