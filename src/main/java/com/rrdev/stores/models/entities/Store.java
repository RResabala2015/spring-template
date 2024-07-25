package com.rrdev.stores.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author rresabala
 */
@Entity
@Table(name = "tiendas")
public class Store implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int stock;
    private Date fechaVencimiento;
    private double costoCompra;
    private double costoVenta;

    // Getters y Setters

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the fechaVencimiento
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * @return the costoCompra
     */
    public double getCostoCompra() {
        return costoCompra;
    }

    /**
     * @param costoCompra the costoCompra to set
     */
    public void setCostoCompra(double costoCompra) {
        this.costoCompra = costoCompra;
    }

    /**
     * @return the costoVenta
     */
    public double getCostoVenta() {
        return costoVenta;
    }

    /**
     * @param costoVenta the costoVenta to set
     */
    public void setCostoVenta(double costoVenta) {
        this.costoVenta = costoVenta;
    }
}
