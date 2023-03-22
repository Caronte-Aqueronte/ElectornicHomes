/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import models.Sucursal;

/**
 *
 * @author Luis Monterroso
 */
public class SucursalMasIngresoDTO extends Sucursal{
    private double totalVentas;

    public SucursalMasIngresoDTO(double totalVentas, String sucursal) {
        super(sucursal);
        this.totalVentas = totalVentas;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }
    
}
