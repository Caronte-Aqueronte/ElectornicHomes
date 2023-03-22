/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dto.ProductoDTO;
import java.util.UUID;
import javafx.collections.ObservableList;
import models.Cliente;
import models.Venta;
import repostitories.VentaRepository;

/**
 *
 * @author Luis Monterroso
 */
public class VentaService {

    private VentaRepository ventaRepository;

    public VentaService() {
        this.ventaRepository = new VentaRepository();
    }

    /**
     * Valida los parametros de una venta, calcula el descuento de la compra,
     * genera un codigo de venta y luego manda a registrar la venta mediante el
     * metodo registrarVenta de VentaRepository.
     *
     * @param cliente
     * @param venta
     * @param carrito
     * @return
     * @throws Exception
     */
    public String registrarVentaConNit(Cliente cliente, Venta venta, ObservableList<ProductoDTO> carrito) throws Exception {
        String respuesta = "Se registró la venta con exito.";
        if (cliente.getNit() <= 0 || cliente.getNit() > 9999999) {
            throw new Exception("NIT invalido.\nEl NIT debe ser MENOR O IGUAL a 9999999 o MAYOR a 0.");
        }
        //verificamos que todos los parametros del cliente sean validos
        if (venta.getFecha() == null || cliente.getNombre().isBlank() || cliente.getTelefono() <= 10000000) {
            throw new Exception("Parámetros vacíos o inválidos.");
        }
        //verificamos que el carrito tenga al menos un articulo
        if (carrito.size() <= 0) {
            throw new Exception("El carrito está vacío.");
        }
        //creamos el codigo de la venta
        venta.setIdVenta(UUID.randomUUID().toString());
        //mandamos a traer la ultima compra del usuario para calcular el descuento y el importe de la venta
        Venta ultimaVenta = ventaRepository.traerUltimaCompraDeUnCliente(cliente);
        //si hay una ultima venta entonces podemos calcular el descuento
        double descuento = 0;
        if (ultimaVenta != null) {
            if (ultimaVenta.getImporteVenta() >= 1000 && ultimaVenta.getImporteVenta() < 5000) {
                descuento = ultimaVenta.getImporteVenta() * 2 / 100;
                respuesta += "\nSe hizo un descuento del 2%.";
            } else if (ultimaVenta.getImporteVenta() >= 5000 && ultimaVenta.getImporteVenta() < 10000) {
                descuento = ultimaVenta.getImporteVenta() * 5 / 100;
                respuesta += "\nSe hizo un descuento del 5%.";
            } else if (ultimaVenta.getImporteVenta() >= 10000) {
                descuento = ultimaVenta.getImporteVenta() * 10 / 100;
                respuesta += "\nSe hizo un descuento del 10%.";
            }
        }
        //guardamos el descuento y calculamos el importe de la venta a parti del mismo
        venta.setDescuento(descuento);
        //si el importe es menor a el descuento entonces seteamos en cero para que no haya errores
        if (venta.getTotal() < descuento) {
            venta.setImporteVenta(0);
        } else {
            venta.setImporteVenta(venta.getTotal() - descuento);
        }
        //podemos mandar a gaurdar la venta
        if (!ventaRepository.registrarVenta(cliente, venta, carrito)) {
            throw new Exception("No se registró la venta.");
        }
        return respuesta;
    }

    /**
     * Valida los datos de una venta y manda a registrar la venta en el metodo
     * registrarVenta de VentaRepository.
     *
     * @param venta
     * @param carrito
     * @return
     * @throws Exception
     */
    public String registrarVentaSinNit(Venta venta, ObservableList<ProductoDTO> carrito) throws Exception {
        String respuesta = "Se registró la venta con exito.";
        //verificamos que todos los parametros del cliente sean validos
        if (venta.getFecha() == null) {
            throw new Exception("Parámetros vacíos o inválidos.");
        }
        //verificamos que el carrito tenga al menos un articulo
        if (carrito.size() <= 0) {
            throw new Exception("El carrito está vacío.");
        }
        //creamos el codigo de la venta
        venta.setIdVenta(UUID.randomUUID().toString());
        //guardamos el descuento y calculamos el importe de la venta a parti del mismo
        venta.setDescuento(0);
        venta.setImporteVenta(venta.getTotal());
        //podemos mandar a gaurdar la venta
        Cliente cliente = new Cliente(0, "CF", 0);
        if (!ventaRepository.registrarVenta(cliente, venta, carrito)) {
            throw new Exception("No se registró la venta.");
        }
        return respuesta;
    }
}
