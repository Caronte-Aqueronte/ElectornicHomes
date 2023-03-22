/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Luis Monterroso
 */
public class ProductoMasVendidoDTO {
    private String nombreProducto;
    private int numeroVentas;

    public ProductoMasVendidoDTO(String nombreProducto, int numeroVentas) {
        this.nombreProducto = nombreProducto;
        this.numeroVentas = numeroVentas;
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
