/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import models.Compra;
import repostitories.CompraRepository;

/**
 *
 * @author Luis Monterroso
 */
public class CompraService {

    private CompraRepository compraRepository;

    public CompraService() {
        this.compraRepository = new CompraRepository();
    }

    /**
     * Verifica los parametros, invoca insertarCompraEnBodega de
     * ProductoDTORepository para insertar una nueva compra y registrarla en a
     * bodega
     *
     * @param compra
     * @return
     * @throws Exception
     */
    public String insertarCompraEnBodega(Compra compra) throws Exception {
        if (compra.getFechaCompra() == null || compra.getNombre().isBlank() || compra.getCodigoBarras() <= 0) {
            throw new Exception("Parametros vacios o invalidos.");
        }
        if (!this.compraRepository.insertarCompraEnBodega(compra)) {
            return "No se guardó el producto en la bodega.";
        }
        return "El producto se guardó con exito en la bodega.";
    }

    /**
     * Invoca modificarCompra de CompraRepository para editar un registro en la
     * bodega.
     *
     * @param compra
     * @param codigoAnterior
     * @return
     * @throws Exception
     */
    public String modificarCompra(Compra compra, int codigoAnterior) throws Exception {
        if (compra.getFechaCompra() == null || compra.getNombre().isBlank() || compra.getCodigoBarras() <= 0) {
            throw new Exception("Parametros vacios o invalidos.");
        }
        if (!this.compraRepository.modificarCompra(compra, codigoAnterior)) {
            return "No se modificó el producto en la bodega.";
        }
        return "El producto se modificó con exito en la bodega.";
    }

    /**
     * Invoca buscarCompraPorCodigo de CompraRepository para encontrar una
     * compra por su codigo de barras.
     *
     * @param codigoBarras
     * @return
     * @throws Exception
     */
    public Compra buscarCompraPorCodigo(int codigoBarras) throws Exception {
        //mandamos a traer la busqueda
        Compra compra = this.compraRepository.buscarCompraPorCodigo(codigoBarras);
        if (compra == null) {
            throw new Exception("No pudimos encontrar el producto buscado debido a un error inesperado.");
        }
        return compra;
    }
}
