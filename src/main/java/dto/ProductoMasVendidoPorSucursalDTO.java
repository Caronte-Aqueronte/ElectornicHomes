/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Luis Monterroso
 */
public class ProductoMasVendidoPorSucursalDTO {

    private String sucursal;
    private String nombreProducto;
    private int numeroVentas;

    public ProductoMasVendidoPorSucursalDTO(String sucursal, String nombreProducto, int numeroVentas) {
        this.sucursal = sucursal;
        this.nombreProducto = nombreProducto;
        this.numeroVentas = numeroVentas;
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

    public int getNumeroVentas() {
        return numeroVentas;
    }

    public void setNumeroVentas(int numeroVentas) {
        this.numeroVentas = numeroVentas;
    }

}
