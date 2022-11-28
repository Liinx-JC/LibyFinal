package com.hola.pruebafinal.Datos;

public class Libreria {
    public int id;
    public int img;
    public String nombre;
    public String fono;
    public String direc;
    public String horario;
    public int lati;
    public int lon;
    public String pag_web;


    public Libreria() {
    }

    public Libreria(int id, int img, String nombre, String fono, String direc, String horario, int lati, int lon, String pag_web) {
        this.id = id;
        this.img = img;
        this.nombre = nombre;
        this.fono = fono;
        this.direc = direc;
        this.horario = horario;
        this.lati = lati;
        this.lon = lon;
        this.pag_web = pag_web;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getLati() {
        return lati;
    }

    public void setLati(int lati) {
        this.lati = lati;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public String getPag_web() {
        return pag_web;
    }

    public void setPag_web(String pag_web) {
        this.pag_web = pag_web;
    }
}
