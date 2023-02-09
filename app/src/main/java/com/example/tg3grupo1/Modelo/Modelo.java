package com.example.tg3grupo1.Modelo;

public class Modelo {
    private String id;
    private String titulo;
    private String ultimaactualizacion;
    private String coordenadas;
    private String icono;

    public Modelo(String id, String titulo, String ultimaactualizacion, String coordenadas, String icono) {
        this.id = id;
        this.titulo = titulo;
        this.ultimaactualizacion = ultimaactualizacion;
        this.coordenadas = coordenadas;
        this.icono = icono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUltimaactualizacion() {
        return ultimaactualizacion;
    }

    public void setUltimaactualizacion(String ultimaactualizacion) {
        this.ultimaactualizacion = ultimaactualizacion;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }
}
