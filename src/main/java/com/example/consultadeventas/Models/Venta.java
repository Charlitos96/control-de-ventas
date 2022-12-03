package com.example.consultadeventas.Models;

import org.springframework.beans.factory.annotation.Autowired;

public class Venta {
    private int folioVenta;
    private int idProducto;
    private String nombre;
    private int cantidad;
    private float precioUnitario;
    private float total;

    public Venta() {
    }

    @Autowired
    public Venta(int folioVenta, int idProducto, String nombre, int cantidad, float precioUnitario, float total) {
        this.folioVenta = folioVenta;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.total = total;
    }
    public int getFolioVenta() {
        return folioVenta;
    }

    public void setFolioVenta(int folioVenta) {
        this.folioVenta = folioVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
        this.setTotal(cantidad * precioUnitario);
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "folioVenta=" + folioVenta +
                ", idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", total=" + total +
                '}';
    }
}
