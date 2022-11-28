package com.hola.pruebafinal.Datos;

public class Libros {
    public int img;
    public String nom_libro;
    public String autor;

    public Libros(int img,String nom_libro, String autor) {
        this.img = img;
        this.nom_libro = nom_libro;
        this.autor = autor;
    }

    public String getNom_libro() {
        return nom_libro;
    }

    public void setNom_libro(String nom_libro) {
        this.nom_libro = nom_libro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getImg() {return img;}

    public void setImg(int img) {this.img = img;}
}
