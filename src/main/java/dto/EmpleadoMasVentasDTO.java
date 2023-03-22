/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;



/**
 *
 * @author Luis Monterroso
 */
public class EmpleadoMasVentasDTO {

    private String nombre;
    private String sucursal;
    private int numVentas;

    public EmpleadoMasVentasDTO(String nombre, String sucursal, int numVentas) {
        this.nombre = nombre;
        this.sucursal = sucursal;
        this.numVentas = numVentas;
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

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

}
