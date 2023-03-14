/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author Luis Monterroso
 */
public class Compra extends Producto {

    private int codigoBarras;
    private LocalDate fechaCompra;

    public Compra(int codigoBarras, LocalDate fechaCompra, String nombre) {
        super(nombre);
        this.codigoBarras = codigoBarras;
        this.fechaCompra = fechaCompra;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

}
