/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repostitories;

import config.Conector;
import constructoresDeObjetos.ConstructorDeObjetoProductoDTO;
import dto.ProductoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Monterroso
 */
public class ProductoDTORepository extends ConstructorDeObjetoProductoDTO {

    /**
     * Se comunica a la base de datos y obtiene el inventario de una sucursal.
     *
     * @param sucursal
     * @return
     */
    public ObservableList<ProductoDTO> mostrarProductosDtoPorSucursal(String sucursal) {
        String query = "SELECT a.codigo_barras, b.nombre, b.precio_venta, c.sucursal FROM "
                + "RegistroRecursos.Compra a INNER JOIN RegistroRecursos.Producto "
                + "b ON a.producto =  b.nombre INNER JOIN RegistroRecursos.Inventario "
                + "c ON c.compra = a.codigo_barras WHERE c.sucursal = ? AND c.estado != ?;";
        try (PreparedStatement ps = Conector.CONEXION.prepareStatement(query)) {
            ps.setString(1, sucursal);
            ps.setString(2, "VENDIDO");
            ResultSet resultado = ps.executeQuery();
            return construirLista(resultado);
        } catch (SQLException ex) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Se comunica a la base de datos y obtiene el inventario de todas las
     * sucursales.
     *
     * @return
     */
    public ObservableList<ProductoDTO> mostrarProductosDtoDeSucursales() {
        String query = "SELECT a.codigo_barras, b.nombre, b.precio_venta, c.sucursal FROM "
                + "RegistroRecursos.Compra a INNER JOIN RegistroRecursos.Producto "
                + "b ON a.producto =  b.nombre INNER JOIN RegistroRecursos.Inventario "
                + "c ON c.compra = a.codigo_barras WHERE c.estado != ?;";
        try (PreparedStatement ps = Conector.CONEXION.prepareStatement(query)) {
            ps.setString(1, "VENDIDO");
            ResultSet resultado = ps.executeQuery();
            return construirLista(resultado);
        } catch (SQLException ex) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Se comunica a la base de datos y obtiene el producto segun la sucursal y
     * el codigo de barras.
     *
     * @param sucursal
     * @param codigoBarras
     * @return
     */
    public ObservableList<ProductoDTO> buscarProductoPorCodigoDeBarrasYSucursal(String sucursal, String codigoBarras) {
        String query = "SELECT a.codigo_barras, b.nombre, b.precio_venta, c.sucursal FROM "
                + "RegistroRecursos.Compra a INNER JOIN RegistroRecursos.Producto "
                + "b ON a.producto =  b.nombre INNER JOIN RegistroRecursos.Inventario "
                + "c ON c.compra = a.codigo_barras WHERE c.sucursal = ? AND c.estado != ? AND CAST(a.codigo_barras AS TEXT) LIKE ?;";
        try (PreparedStatement ps = Conector.CONEXION.prepareStatement(query)) {
            ps.setString(1, sucursal);
            ps.setString(3, "%" + codigoBarras + "%");
            ps.setString(2, "VENDIDO");
            ResultSet resultado = ps.executeQuery();
            return construirLista(resultado);
        } catch (SQLException ex) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Se comunica a la base de datos y obtiene el producto segun el codigo de
     * barras.
     *
     * @param codigoBarras
     * @return
     */
    public ObservableList<ProductoDTO> buscarProductoPorCodigoDeBarras(String codigoBarras) {
        String query = "SELECT a.codigo_barras, b.nombre, b.precio_venta, c.sucursal FROM "
                + "RegistroRecursos.Compra a INNER JOIN RegistroRecursos.Producto "
                + "b ON a.producto =  b.nombre INNER JOIN RegistroRecursos.Inventario "
                + "c ON c.compra = a.codigo_barras WHERE c.estado != ? AND CAST(a.codigo_barras AS TEXT) LIKE ?;";
        try (PreparedStatement ps = Conector.CONEXION.prepareStatement(query)) {
            ps.setString(2, "%" + codigoBarras + "%");
            ps.setString(1, "VENDIDO");
            ResultSet resultado = ps.executeQuery();
            return construirLista(resultado);
        } catch (SQLException ex) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Edita la sucursal en donde un producto esta.
     *
     * @param producto
     * @param sucursal
     * @return
     */
    public boolean cambiarProductoDeSucursal(ProductoDTO producto, String sucursal) {
        try {
            //desactivar el autocomit
            Conector.CONEXION.setAutoCommit(false);
            PreparedStatement ps = Conector.CONEXION.prepareStatement(
                    "UPDATE RegistroRecursos.Inventario SET sucursal = ? WHERE compra = ?;");
            //damos valor a los ? con la sucursal nueva y el producto en cuestion
            ps.setString(1, sucursal);
            ps.setInt(2, producto.getCodigoBarras());
            //ahora ejecutamos a query y evaluamos si se edito alguna tupla
            if (ps.executeUpdate() <= 0) {
                throw new SQLException();
            }
            Conector.CONEXION.commit();
            Conector.CONEXION.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            try {
                Conector.CONEXION.rollback();
            } catch (SQLException e) {
            }
            return false;
        }
    }
}
