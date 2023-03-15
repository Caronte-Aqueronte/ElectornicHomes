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
public class Venta {
    
    private String idVenta;
    private String sucursal;
    private int empleado;
    private double total;
    private double descuento;
    private double importeVenta;
    private LocalDate fecha;

    public Venta(String idVenta, String sucursal, int empleado, double total, double descuento, double importeVenta, LocalDate fecha) {
        this.idVenta = idVenta;
        this.sucursal = sucursal;
        this.empleado = empleado;
        this.total = total;
        this.descuento = descuento;
        this.importeVenta = importeVenta;
        this.fecha = fecha;
    }

    public double getImporteVenta() {
        return importeVenta;
    }

    public void setImporteVenta(double importeVenta) {
        this.importeVenta = importeVenta;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
    
}
