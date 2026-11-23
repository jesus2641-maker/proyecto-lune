package com.microserviciobh.api.model;

public class ofertas {
   private int id_ofertas;
   private int id_productos;
   private double porcentaje_decuento;
   private double precio_oferta;

    public ofertas(int id_ofertas, int id_productos, double porcentaje_decuento, double precio_oferta) {
        this.id_ofertas = id_ofertas;
        this.id_productos = id_productos;
        this.porcentaje_decuento = porcentaje_decuento;
        this.precio_oferta = precio_oferta;
    }

    public int getId_ofertas() {
        return id_ofertas;
    }

    public void setId_ofertas(int id_ofertas) {
        this.id_ofertas = id_ofertas;
    }

    public int getId_productos() {
        return id_productos;
    }

    public void setId_productos(int id_productos) {
        this.id_productos = id_productos;
    }

    public double getPorcentaje_decuento() {
        return porcentaje_decuento;
    }

    public void setPorcentaje_decuento(double porcentaje_decuento) {
        this.porcentaje_decuento = porcentaje_decuento;
    }

    public double getPrecio_oferta() {
        return precio_oferta;
    }

    public void setPrecio_oferta(double precio_oferta) {
        this.precio_oferta = precio_oferta;
    }

    public ofertas() {

    }
}

