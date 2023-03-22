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
public class SucursalMasVentasDTO extends Sucursal {

    private int numVentas;

    public SucursalMasVentasDTO(int numVentas, String sucursal) {
        super(sucursal);
        this.numVentas = numVentas;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        this.numVentas = numVentas;
    }

}
