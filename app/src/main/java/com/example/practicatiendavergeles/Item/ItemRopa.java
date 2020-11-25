package com.example.practicatiendavergeles.Item;

import android.graphics.drawable.Drawable;

public class ItemRopa implements Comparable<ItemRopa> {
    private String descripcion;
    private double precio;
    private Drawable imagen;

    public ItemRopa() {
    }

    public ItemRopa(String descripcion, double precio, Drawable imagen) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "ItemRopa{" +
                "descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", imagen=" + imagen +
                '}';
    }

    @Override
    public int compareTo(ItemRopa o) {
        double sort = this.precio - o.getPrecio();

        return (int) sort;
    }

    public int compareTo2(ItemRopa o) {
        double sort = this.precio - o.getPrecio();

        return -(int) sort;
    }
}
