/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Luis Monterroso
 */
public class ProductoDTO {
    
    private int codigoBarras;
    private String nombre;
    private double precioVenta;

    public ProductoDTO(int codigoBarras, String nombre, double precioVenta) {
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.precioVenta = precioVenta;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    
}
