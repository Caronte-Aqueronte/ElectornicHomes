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
     * Invoca el metodo de ProductoDTORepository que es capaz de mostrar el
     * invnetario de una sucursal.
     *
     * @param sucursal
     * @return
     */
    public ObservableList<ProductoDTO> mostrarInventarioDeSucursal(String sucursal) {
        return productoDTORepository.mostrarProductosDtoPorSucursal(sucursal);
    }

    /**
     * Invoca el metodo de ProductoDTORepository que es capaz de mostrar el
     * producto por el codigoDeBarras y la sucursal del Empleado.
     *
     * @param sucursal
     * @param codigoBarras
     * @return
     */
    public ObservableList<ProductoDTO> buscarProductoDtoPorCodigoBarras(String sucursal, String codigoBarras) {
        return productoDTORepository.buscarProductoPorCodigoDeBarrasYSucursal(sucursal, codigoBarras);
    }

    /**
     * Invoca el metodo de ProductoDTORepository que es capaz de mostrar el el
     * inventario de las sucursales.
     *
     * @return
     */
    public ObservableList<ProductoDTO> mostrarProductosDtoDeSucursales() {
        return productoDTORepository.mostrarProductosDtoDeSucursales();
    }

    /**
     * Invoca el metodo de ProductoDTORepository que es capaz de mostrar el
     * producto buscado en el inventario de las sucursales.
     *
     * @param codigo
     * @return
     */
    public ObservableList<ProductoDTO> buscarProductoPorCodigoDeBarras(String codigo) {
        return productoDTORepository.buscarProductoPorCodigoDeBarras(codigo);
    }

    /**
     * Invoca el metodo cambiarProductoDeSucursal de ProductoDTORepository para
     * cambiar un producto de sucursal.
     *
     * @param producto
     * @param sucursal
     * @return
     * @throws Exception
     */
    public String cambiarProductoDeSucursal(ProductoDTO producto, String sucursal) throws Exception {
        if (!productoDTORepository.cambiarProductoDeSucursal(producto, sucursal)) {
            throw new Exception("El producto no se cambió de sucursal.");
        }
        return "El producto se cambió con éxito de sucursal.";
    }

}
