package com.example.waka.Domain;

import java.io.Serializable;

public class BebidasDomain implements Serializable {
    private String nombre;
    private String pic;
    private String descripcion;
    private Double fee;
    private int numberInCart;

    public BebidasDomain(String nombre, String pic, String descripcion, Double fee) {
        this.nombre = nombre;
        this.pic = pic;
        this.descripcion = descripcion;
        this.fee = fee;
    }

    public BebidasDomain(String nombre, String pic, String descripcion, Double fee, int numberInCart) {
        this.nombre = nombre;
        this.pic = pic;
        this.descripcion = descripcion;
        this.fee = fee;
        this.numberInCart = numberInCart;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
