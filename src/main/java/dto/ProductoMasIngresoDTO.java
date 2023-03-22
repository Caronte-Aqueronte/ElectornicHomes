/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Luis Monterroso
 */
public class ProductoMasIngresoDTO {

    private String nombreProducto;
    private double totalIngresos;

    public ProductoMasIngresoDTO(String nombreProducto, double totalIngresos) {
        this.nombreProducto = nombreProducto;
        this.totalIngresos = totalIngresos;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(double totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

}
