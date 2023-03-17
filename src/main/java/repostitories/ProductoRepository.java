/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repostitories;

import config.Conector;
import constructoresDeObjetos.ConstructorDeObjetoProducto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Producto;

/**
 *
 * @author Luis Monterroso
 */
public class ProductoRepository extends ConstructorDeObjetoProducto {

    /**
     * Se comunica a la base de datos e inserta un producto nuevo a la base de
     * datos.
     *
     * @param producto
     * @return
     */
    public boolean insertarProducto(Producto producto) {
        try {
            //se trata de una transaccion entonces desactivamos el autocommit
            Conector.CONEXION.setAutoCommit(false);
            //creamos la query
            PreparedStatement ps = Conector.CONEXION.prepareStatement(
                    "INSERT INTO RegistroRecursos.Producto VALUES (?,?,?,?);");
            //damos valores a los ? con los atributos del objeto
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioCompra());
            ps.setDouble(4, producto.getPrecioVenta());
            //evaluamos si se inserto el producto
            if (ps.executeUpdate() <= 0) {
                throw new SQLException();
            }
            //hacemos commit, activamos el auto comit y devolvemos true
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

    /**
     * Se comunica con la base de datos para mostrar todos los productos del
     * catalogo.
     *
     * @return
     */
    public ObservableList<Producto> mostrarProductos() {
        try {
            //crear el statement encargado de la query
            Statement st = Conector.CONEXION.createStatement();
            //ejecutar una uery y obtener el ResultSet
            ResultSet resultado = st.executeQuery("SELECT * FROM RegistroRecursos.Producto;");
            return construirLista(resultado);//devolvemos la construccion de la lista de productos existemtes
        } catch (SQLException ex) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Se comunica con la base de datos para buscar un producto por su nombre.
     *
     * @param nombre
     * @return
     */
    public ObservableList<Producto> buscarProducto(String nombre) {
        try {
            //crear el statement encargado de la query
            PreparedStatement st = Conector.CONEXION.prepareStatement(
                    "SELECT * FROM RegistroRecursos.Producto WHERE LOWER(nombre) LIKE LOWER(?);");
            //damos valor al ? con el nombre del producto buscado
            st.setString(1, "%" + nombre + "%");
            //ejecutar una uery y obtener el ResultSet
            ResultSet resultado = st.executeQuery();
            return construirLista(resultado);//devolvemos la construccion de la lista de productos existemtes
        } catch (SQLException ex) {
            return FXCollections.observableArrayList();
        }
    }
}
