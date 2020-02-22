package com.example.demo1.models;

import java.util.Date;

public class Post   {
    private int id = 1;
    private String descripcion = "descripcion";
    private String urlImg = "http://localhost:9000/img/mongodb.png";
    private Date fecha = new Date();
    private String titulo = "titulo";

    public Post(int id, String descripcion, String urlImg, Date fecha, String titulo) {
        this.id = id;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
        this.fecha = fecha;
        this.titulo = titulo;
    }

    public Post() {
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void mostrar(){
        System.out.println(this.id);
        System.out.println(this.descripcion);
        System.out.println(this.urlImg);
        System.out.println(this.fecha);
        System.out.println(this.titulo);
    }
}
