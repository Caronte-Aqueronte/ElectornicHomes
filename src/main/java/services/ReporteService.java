/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dto.ClientesMasGananciaDTO;
import dto.EmpleadoMasIngresoDTO;
import dto.EmpleadoMasVentasDTO;
import dto.ProductoMasIngresoDTO;
import dto.ProductoMasIngresoPorSucursalDTO;
import dto.ProductoMasVendidoDTO;
import dto.ProductoMasVendidoPorSucursalDTO;
import dto.SucursalMasIngresoDTO;
import dto.SucursalMasVentasDTO;
import javafx.collections.ObservableList;
import repostitories.ReporteRepository;

/**
 *
 * @author Luis Monterroso
 */
public class ReporteService {

    private final ReporteRepository reporteRepository;

    public ReporteService() {
        this.reporteRepository = new ReporteRepository();
    }


    /**
     * Utiliza diezClientesMasIngreso() de ReporteRepository para traer los 10
     * clientes que mas ingreso generan.
     *
     * @return
     */
    public ObservableList<ClientesMasGananciaDTO> diezClientesMasIngreso() {
        return reporteRepository.diezClientesMasIngreso();
    }

    /**
     * Utiliza sucursalesMasVentas() de ReporteRepository para traer las 3
     * sucursales con mas ventas.
     *
     * @return
     */
    public ObservableList<SucursalMasVentasDTO> sucursalesMasVentas() {
        return reporteRepository.sucursalesMasVentas();
    }

    /**
     * Utiliza sucursalesMasVentas() de ReporteRepository para traer las 3
     * sucursales que mas ingresos generan.
     *
     * @return
     */
    public ObservableList<SucursalMasIngresoDTO> sucursalesMasIngresos() {
        return reporteRepository.sucursalesMasIngresos();
    }

    /**
     * Utiliza empleadosMasVentas() de ReporteRepository para traer las 3
     * empleados que mas ventas generan.
     *
     * @return
     */
    public ObservableList<EmpleadoMasVentasDTO> empleadosMasVentas() {
        return reporteRepository.empleadosMasVentas();
    }

    /**
     * Utiliza empleadosMasIngresos()() de ReporteRepository para traer las 3
     * empleados que mas ingresos generan.
     *
     * @return
     */
    public ObservableList<EmpleadoMasIngresoDTO> empleadosMasIngresos() {
        return reporteRepository.empleadosMasIngresos();
    }

    /**
     * Utiliza productoMasVendido() de ReporteRepository para traer los 10
     * productos que mas ventas generan.
     *
     * @return
     */
    public ObservableList<ProductoMasVendidoDTO> productoMasVendido() {
        return reporteRepository.productoMasVendido();
    }

    /**
     * Utiliza productoMasIngresos() de ReporteRepository para traer los 10
     * productos que mas ingresos generan.
     *
     * @return
     */
    public ObservableList<ProductoMasIngresoDTO> productoMasIngresos() {
        return reporteRepository.productoMasIngresos();
    }

    /**
     * Utiliza productoMasVentasPorSucursal() de ReporteRepository para traer
     * los 5 productos que mas ventas generan en una sucursal.
     *
     * @param sucursal
     * @return
     */
    public ObservableList<ProductoMasVendidoPorSucursalDTO> productoMasVentasPorSucursal(String sucursal) {
        return reporteRepository.productoMasVentasPorSucursal(sucursal);
    }

    /**
     * Utiliza productoMasVentasPorSucursal() de ReporteRepository para traer
     * los 5 productos que mas ingresos generan en una sucursal.
     *
     * @param sucursal
     * @return
     */
    public ObservableList<ProductoMasIngresoPorSucursalDTO> productoMasIngresoPorSucursal(String sucursal) {
        return reporteRepository.productoMasIngresoPorSucursal(sucursal);
    }
}
