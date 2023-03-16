/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dto.BodegaDTO;
import javafx.collections.ObservableList;
import repostitories.BodegaDTORepository;

/**
 *
 * @author Luis Monterroso
 */
public class BodegaDTOService {

    private BodegaDTORepository bodegaDTORepository;

    public BodegaDTOService() {
        this.bodegaDTORepository = new BodegaDTORepository();
    }

    /**
     * Invoca el metodo de ProductoDTORepository que es capaz de mostrar la
     * bodega.
     *
     * @return
     */
    public ObservableList<BodegaDTO> mostrarBodega() {
        return bodegaDTORepository.mostrarBodega();
    }

    /**
     * Invoca el metodo de ProductoDTORepository que es capaz de mostrar la el
     * prducto buscado en la bodega.
     *
     * @param codigo
     * @return
     */
    public ObservableList<BodegaDTO> buscarEnBodegaPorCodigoBarras(String codigo) {
        return bodegaDTORepository.buscarEnBodegaPorCodigoBarras(codigo);
    }

    /**
     * Invoca el metodo de ProductoDTORepository que es capaz de mostrar la el
     * prducto buscado en la bodega.
     *
     * @param bodega
     * @param sucursal
     * @return
     */
    public String distribuirBodegaASucursal(BodegaDTO bodega, String sucursal) throws Exception {
        if (!bodegaDTORepository.distribuirBodegaASucursal(bodega, sucursal)) {
            throw new Exception("No se ingresó el producto al inventario de la sucursal " + sucursal);
        }
        return "Se ingresó el producto al inventario de la sucursal " + sucursal;
    }

}
