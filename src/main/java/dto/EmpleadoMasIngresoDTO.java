/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Luis Monterroso
 */
public class EmpleadoMasIngresoDTO {

    private String nombre;
    private String sucursal;
    private double totalIngresos;

    public EmpleadoMasIngresoDTO(String nombre, String sucursal, double totalIngresos) {
        this.nombre = nombre;
        this.sucursal = sucursal;
        this.totalIngresos = totalIngresos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(double totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

}
