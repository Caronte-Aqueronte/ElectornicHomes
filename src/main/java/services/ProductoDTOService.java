/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dto.ProductoDTO;
import javafx.collections.ObservableList;
import repostitories.ProductoDTORepository;

/**
 *
 * @author Luis Monterroso
 */
public class ProductoDTOService {

    private ProductoDTORepository productoDTORepository;

    public ProductoDTOService() {
        productoDTORepository = new ProductoDTORepository();
    }

    /**
     * Invoca el metodo de ProductoDTORepository que es capaz de mostrar el invnetario de una sucursal.
     * @param sucursal
     * @return 
     */
    public ObservableList<ProductoDTO> buscarProductoDtoPorCodigoBarras(String sucursal) {
        return productoDTORepository.mostrarProductosDtoPorSucursal(sucursal);
    }
}
