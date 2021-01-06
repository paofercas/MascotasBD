package com.paocas.mascotas.pojo;

public class Mascota {
    private int idMascota;
    private String nombre;
    private int foto;
    private int colorbackground;
    private int numerolikes;
    private int islike=0;

    public Mascota(int idMascota,String nombre, int foto, int numerolikes, int colorbackground) {
        this.idMascota= idMascota;
        this.nombre = nombre;
        this.foto = foto;
        this.colorbackground = colorbackground;
        this.numerolikes = numerolikes;
    }

    public Mascota() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getNumerolikes() {
        return numerolikes;
    }

    public void setNumerolikes(int numerolikes) {
        this.numerolikes = numerolikes;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public void sumarLikes(){
        this.numerolikes++;
    }

    public int getisIslike() {
        return islike;
    }

    public void setIslike(int islike) {
        this.islike = islike;
    }

    public int getColorbackground() {
        return colorbackground;
    }

    public void setColorbackground(int colorbackground) {
        this.colorbackground = colorbackground;
    }
}
