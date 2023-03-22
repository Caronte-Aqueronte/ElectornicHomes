/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Luis Monterroso
 */
public class ProductoMasIngresoPorSucursalDTO {

    private String sucursal;
    private String nombreProducto;
    private double totalVentas;

    public ProductoMasIngresoPorSucursalDTO(String sucursal, String nombreProducto, double totalVentas) {
        this.sucursal = sucursal;
        this.nombreProducto = nombreProducto;
        this.totalVentas = totalVentas;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

}
