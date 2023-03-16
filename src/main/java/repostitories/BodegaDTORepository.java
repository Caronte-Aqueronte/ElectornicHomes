/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repostitories;

import config.Conector;
import constructoresDeObjetos.ConstructorDeObjetoBodegaDTO;
import dto.BodegaDTO;
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
public class BodegaDTORepository extends ConstructorDeObjetoBodegaDTO {

    /**
     * Se comunica a la base de datos y obtiene el inventario de bodega.
     *
     * @return
     */
    public ObservableList<BodegaDTO> mostrarBodega() {
        String query = "SELECT a.codigo_barras, b.nombre, b.precio_venta FROM "
                + "RegistroRecursos.Compra a INNER JOIN RegistroRecursos.Producto "
                + "b ON a.producto =  b.nombre INNER JOIN RegistroRecursos.Bodega "
                + "c ON c.compra = a.codigo_barras;";
        try (Statement ps = Conector.CONEXION.createStatement()) {
            ResultSet resultado = ps.executeQuery(query);
            return construirLista(resultado);
        } catch (SQLException ex) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Se comunica a la base de datos y obtiene el producto en la bodega segun
     * su codigo de barras.
     *
     * @param codigo
     * @return
     */
    public ObservableList<BodegaDTO> buscarEnBodegaPorCodigoBarras(String codigo) {
        String query = "SELECT a.codigo_barras, b.nombre, b.precio_venta FROM "
                + "RegistroRecursos.Compra a INNER JOIN RegistroRecursos.Producto "
                + "b ON a.producto =  b.nombre INNER JOIN RegistroRecursos.Bodega "
                + "c ON c.compra = a.codigo_barras WHERE CAST(a.codigo_barras AS TEXT) LIKE ?;";
        try (PreparedStatement ps = Conector.CONEXION.prepareStatement(query)) {
            ps.setString(1, "%" + codigo + "%");
            ResultSet resultado = ps.executeQuery();
            return construirLista(resultado);
        } catch (SQLException ex) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Se comunica a la base de datos, elimina un producto de la bodega y lo
     * agrega a el inventario de una sucursal
     *
     * @param bodega
     * @param sucursal
     * @return
     */
    public boolean distribuirBodegaASucursal(BodegaDTO bodega, String sucursal) {
        try {
            Conector.CONEXION.setAutoCommit(false);
            //query que elimina un producto de la bodega
            PreparedStatement ps = Conector.CONEXION.prepareStatement("DELETE FROM "
                    + "RegistroRecursos.Bodega WHERE compra = ?;");
            //damos valor a los ? con el codigo de barras del producto
            ps.setInt(1, bodega.getCodigoBarras());
            //evaluamos si algo se elimino
            if (ps.executeUpdate() <= 0) {
                throw new SQLException();
            }
            //ahora mandamos a insertar el producto al inventario de una sucursal
            ps = Conector.CONEXION.prepareStatement("INSERT INTO RegistroRecursos.Inventario "
                    + "VALUES(?,?,?);");
            //damos valores a los ? con el codigo de barras, la sucursal y el estado
            ps.setInt(1, bodega.getCodigoBarras());
            ps.setString(2, sucursal);
            ps.setString(3, "DISPONIBLE");
            //evaluamos si algo se elimino
            if (ps.executeUpdate() <= 0) {
                throw new SQLException();
            }
            Conector.CONEXION.commit();
            Conector.CONEXION.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            try {
                Conector.CONEXION.rollback();
            } catch (Exception e) {
            }
            return false;
        }
    }
}
