/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import dto.ProductoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorDeObjetoProductoDTO implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos ProductoDTO a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos ProductoDTO.
     * @throws SQLException
     */
    @Override
    public ObservableList<ProductoDTO> contruirLista(ResultSet resultado) throws SQLException {
        ObservableList<ProductoDTO> productos = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            int codigoBarras = resultado.getInt("codigo_barras");
            String nombre = resultado.getString("nombre");
            double precioVenta = resultado.getDouble("precio_venta");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoDTO
            ProductoDTO producto = new ProductoDTO(codigoBarras, nombre, precioVenta);
            productos.add(producto);//agregamos a la lista el objeto creado
        }
        return productos;
    }

    /**
     * Crea un objeto ProductoDTO a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto ProductoDTO.
     * @throws SQLException
     */
    @Override
    public ProductoDTO contruirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            int codigoBarras = resultado.getInt("codigo_barras");
            String nombre = resultado.getString("nombre");
            double precioVenta = resultado.getDouble("precio_venta");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoDTO
            return new ProductoDTO(codigoBarras, nombre, precioVenta);
        }
        return null;
    }
}
