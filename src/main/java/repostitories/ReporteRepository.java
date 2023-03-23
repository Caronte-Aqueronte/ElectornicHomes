/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repostitories;

import dto.ClientesMasGananciaDTO;
import dto.ProductoMasVendidoDTO;
import config.Conector;
import constructoresDeObjetos.ConstructorDeObjetoClienteMasGanancia;
import constructoresDeObjetos.ConstructorEmpleadoMasIngresoDTO;
import constructoresDeObjetos.ConstructorEmpleadoMasVentasDTO;
import constructoresDeObjetos.ConstructorProductoMasIngresoDTO;
import constructoresDeObjetos.ConstructorProductoMasIngresoPorSucursalDTO;
import constructoresDeObjetos.ConstructorProductoMasVentasPorSucursalDTO;
import constructoresDeObjetos.ConstructorProductoMasVendidoDTO;
import constructoresDeObjetos.ConstructorSucursalMasVentasDTO;
import constructoresDeObjetos.ConstrutorSucursalMasIngreso;
import dto.EmpleadoMasIngresoDTO;
import dto.EmpleadoMasVentasDTO;
import dto.ProductoMasIngresoDTO;
import dto.ProductoMasIngresoPorSucursalDTO;
import dto.ProductoMasVendidoPorSucursalDTO;
import dto.SucursalMasIngresoDTO;
import dto.SucursalMasVentasDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Monterroso
 */
public class ReporteRepository {

    private final ConstructorDeObjetoClienteMasGanancia constructorDeObjetoClienteMasGanancia;
    private final ConstructorSucursalMasVentasDTO constructorSucursalMasVentasDTO;
    private final ConstrutorSucursalMasIngreso construtorSucursalMasIngreso;
    private final ConstructorEmpleadoMasVentasDTO constructorEmpleadoMasVentasDTO;
    private final ConstructorEmpleadoMasIngresoDTO constructorEmpleadoMasIngresoDTO;
    private final ConstructorProductoMasVendidoDTO constructorProductoMasVendidoDTO;
    private final ConstructorProductoMasIngresoDTO constructorProductoMasIngresoDTO;
    private final ConstructorProductoMasVentasPorSucursalDTO constructorProductoMasVentasPorSucursalDTO;
    private final ConstructorProductoMasIngresoPorSucursalDTO constructorProductoMasIngresoPorSucursalDTO;

    public ReporteRepository() {
        this.constructorDeObjetoClienteMasGanancia = new ConstructorDeObjetoClienteMasGanancia();
        this.constructorSucursalMasVentasDTO = new ConstructorSucursalMasVentasDTO();
        this.construtorSucursalMasIngreso = new ConstrutorSucursalMasIngreso();
        this.constructorEmpleadoMasVentasDTO = new ConstructorEmpleadoMasVentasDTO();
        this.constructorEmpleadoMasIngresoDTO = new ConstructorEmpleadoMasIngresoDTO();
        this.constructorProductoMasVendidoDTO = new ConstructorProductoMasVendidoDTO();
        this.constructorProductoMasIngresoDTO = new ConstructorProductoMasIngresoDTO();
        this.constructorProductoMasVentasPorSucursalDTO = new ConstructorProductoMasVentasPorSucursalDTO();
        this.constructorProductoMasIngresoPorSucursalDTO = new ConstructorProductoMasIngresoPorSucursalDTO();
    }

    /**
     * Obtiene los 10 clientes que mas ingresos han generado.
     *
     * @return
     */
    public ObservableList<ClientesMasGananciaDTO> diezClientesMasIngreso() {
        try {
            Statement st = Conector.CONEXION.createStatement();
            ResultSet resultado = st.executeQuery("SELECT a.nit, a.nombre, SUM(c.total) "
                    + "FROM RegistroVentas.Cliente a INNER JOIN RegistroVentas.Adquisicion b "
                    + "ON a.nit = b.cliente INNER JOIN RegistroVentas.Venta c ON c.id_venta ="
                    + " b.venta GROUP BY a.nombre, a.nit ORDER BY sum DESC LIMIT 10;");
            return this.constructorDeObjetoClienteMasGanancia.construirLista(resultado);
        } catch (SQLException e) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Obtiene las 3 sucursales con mas ventas.
     *
     * @return
     */
    public ObservableList<SucursalMasVentasDTO> sucursalesMasVentas() {
        try {
            Statement st = Conector.CONEXION.createStatement();
            ResultSet resultado = st.executeQuery("SELECT sucursal, COUNT(sucursal) "
                    + "AS num_ventas FROM RegistroVentas.Venta GROUP BY sucursal ORDER "
                    + "BY num_ventas DESC LIMIT 3;");
            return this.constructorSucursalMasVentasDTO.construirLista(resultado);
        } catch (SQLException e) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Obtiene las 3 sucursales con mas ingresos.
     *
     * @return
     */
    public ObservableList<SucursalMasIngresoDTO> sucursalesMasIngresos() {
        try {
            Statement st = Conector.CONEXION.createStatement();
            ResultSet resultado = st.executeQuery("SELECT sucursal,SUM(total) AS "
                    + "total_ventas FROM RegistroVentas.Venta GROUP BY sucursal"
                    + " ORDER BY total_ventas DESC LIMIT 3;");
            return this.construtorSucursalMasIngreso.construirLista(resultado);
        } catch (SQLException e) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Obtiene las 3 empleados con mas ventas.
     *
     * @return
     */
    public ObservableList<EmpleadoMasVentasDTO> empleadosMasVentas() {
        try {
            Statement st = Conector.CONEXION.createStatement();
            ResultSet resultado = st.executeQuery("SELECT a.nombre,a.sucursal, "
                    + "COUNT(a.nombre) AS num_ventas FROM RegistroPersonal.Empleado "
                    + "a INNER JOIN RegistroVentas.Venta b ON a.id_empleado = b.empleado"
                    + " GROUP BY a.nombre, a.sucursal ORDER BY num_ventas DESC LIMIT 3;");
            return this.constructorEmpleadoMasVentasDTO.construirLista(resultado);
        } catch (SQLException e) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Obtiene las 3 empleados con mas ingrwsos.
     *
     * @return
     */
    public ObservableList<EmpleadoMasIngresoDTO> empleadosMasIngresos() {
        try {
            Statement st = Conector.CONEXION.createStatement();
            ResultSet resultado = st.executeQuery("SELECT a.nombre,a.sucursal, "
                    + "SUM(b.total) AS total_ventas FROM RegistroPersonal.Empleado "
                    + "a INNER JOIN RegistroVentas.Venta b ON a.id_empleado = b.empleado "
                    + "GROUP BY a.nombre, a.sucursal ORDER BY total_ventas DESC LIMIT 3;");
            return this.constructorEmpleadoMasIngresoDTO.construirLista(resultado);
        } catch (SQLException e) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Obtiene las 10 productos con mas ventas.
     *
     * @return
     */
    public ObservableList<ProductoMasVendidoDTO> productoMasVendido() {
        try {
            Statement st = Conector.CONEXION.createStatement();
            ResultSet resultado = st.executeQuery("SELECT b.producto, COUNT(b.producto) "
                    + "AS num_ventas FROM RegistroVentas.Desgloce a INNER JOIN "
                    + "RegistroRecursos.Compra b ON a.inventario = b.codigo_barras"
                    + " GROUP BY b.producto ORDER BY num_ventas DESC LIMIT 10;");
            return this.constructorProductoMasVendidoDTO.construirLista(resultado);
        } catch (SQLException e) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Obtiene las 10 productos con mas ingresos .
     *
     * @return
     */
    public ObservableList<ProductoMasIngresoDTO> productoMasIngresos() {
        try {
            Statement st = Conector.CONEXION.createStatement();
            ResultSet resultado = st.executeQuery("SELECT b.producto, SUM(a.total)"
                    + " AS total_ventas FROM RegistroVentas.Desgloce a INNER JOIN"
                    + " RegistroRecursos.Compra b ON a.inventario = b.codigo_barras "
                    + "GROUP BY b.producto ORDER BY total_ventas DESC LIMIT 10;");
            return this.constructorProductoMasIngresoDTO.construirLista(resultado);
        } catch (SQLException e) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Obtiene las 10 productos con mas ingresos .
     *
     * @param sucursal
     * @return
     */
    public ObservableList<ProductoMasVendidoPorSucursalDTO> productoMasVentasPorSucursal(String sucursal) {
        try {
            PreparedStatement ps = Conector.CONEXION.prepareStatement("SELECT a.sucursal, "
                    + "c.producto, COUNT(c.producto) AS num_ventas FROM RegistroVentas.Venta"
                    + " a INNER JOIN RegistroVentas.Desgloce b ON a.id_venta = b.venta "
                    + "INNER JOIN RegistroRecursos.Compra c ON b.inventario = c.codigo_barras"
                    + " WHERE a.sucursal = ? GROUP BY a.sucursal, c.producto"
                    + " ORDER BY num_ventas DESC LIMIT 5;");
            //dar valor al ? con el nombre de la sucursal
            ps.setString(1, sucursal);
            ResultSet resultado = ps.executeQuery();
            return this.constructorProductoMasVentasPorSucursalDTO.construirLista(resultado);
        } catch (SQLException e) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Obtiene las 10 productos con mas ingresos .
     *
     * @param sucursal
     * @return
     */
    public ObservableList<ProductoMasIngresoPorSucursalDTO> productoMasIngresoPorSucursal(String sucursal) {
        try {
            PreparedStatement ps = Conector.CONEXION.prepareStatement("SELECT a.sucursal, "
                    + "c.producto, SUM(b.total) AS total_ventas FROM RegistroVentas.Venta"
                    + " a INNER JOIN RegistroVentas.Desgloce b ON a.id_venta = b.venta"
                    + " INNER JOIN RegistroRecursos.Compra c ON b.inventario = c.codigo_barras"
                    + " WHERE a.sucursal = ? GROUP BY a.sucursal, c.producto"
                    + " ORDER BY total_ventas DESC LIMIT 5;");
            //dar valor al ? con el nombre de la sucursal
            ps.setString(1, sucursal);
            ResultSet resultado = ps.executeQuery();
            return this.constructorProductoMasIngresoPorSucursalDTO.construirLista(resultado);
        } catch (SQLException e) {
            return FXCollections.observableArrayList();
        }
    }
}
