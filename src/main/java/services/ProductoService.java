/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import javafx.collections.ObservableList;
import models.Producto;
import repostitories.ProductoRepository;

/**
 *
 * @author Luis Monterroso
 */
public class ProductoService {

    private ProductoRepository productoRepository;

    public ProductoService() {
        this.productoRepository = new ProductoRepository();
    }

    /**
     * Invoca a insertarProducto de ProductoRepository para insertar un producto
     * a la base de datos
     *
     *
     * @param producto
     * @return
     * @throws Exception
     */
    public String insertarProducto(Producto producto) throws Exception {
        //se validan los parametros del producto
        if (producto.getNombre().isBlank() || producto.getDescripcion().isBlank()
                || producto.getPrecioCompra() <= 0 || producto.getPrecioVenta() <= 0) {
            throw new Exception("Parametros invalidos o vacios.");
        }
        if (!productoRepository.insertarProducto(producto)) {
            throw new Exception("No se guardó el producto.");
        }

        return "Se guardó el producto con exito.";
    }

    /**
     * Invoca a mostrarProductos de ProductoRepository para mostrar los
     * productos existentes.
     *
     * @return
     */
    public ObservableList<Producto> mostrarProductos() {
        return productoRepository.mostrarProductos();
    }

    /**
     * Invoca a mostrarProductos de ProductoRepository para mostrar los
     * productos existentes.
     *
     * @param nombre
     * @return
     */
    public ObservableList<Producto> buscarProducto(String nombre) {
        return productoRepository.buscarProducto(nombre);
    }
}
