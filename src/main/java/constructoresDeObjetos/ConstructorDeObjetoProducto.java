/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;


import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Producto;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorDeObjetoProducto implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos Producto a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos Producto.
     * @throws SQLException
     */
    @Override
    public ObservableList<Producto> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<Producto> productos = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("nombre");
            String descripcion = resultado.getString("descripcion");
            double precioVenta = resultado.getDouble("precio_venta");
            double precioCompra = resultado.getDouble("precio_compra");
            //apartir de la extraccion de datos crear un nuevo objeto Producto
            Producto producto = new Producto(nombre, descripcion, precioCompra, precioVenta);
            productos.add(producto);//agregamos a la lista el objeto creado
        }
        return productos;
    }

    /**
     * Crea un objeto Producto a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto Producto.
     * @throws SQLException
     */
    @Override
    public Producto construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("nombre");
            String descripcion = resultado.getString("descripcion");
            double precioVenta = resultado.getDouble("precio_venta");
            double precioCompra = resultado.getDouble("precio_compra");
            //apartir de la extraccion de datos crear un nuevo objeto Producto
            return new Producto(nombre, descripcion, precioCompra, precioVenta);
        }
        return null;
    }

}
