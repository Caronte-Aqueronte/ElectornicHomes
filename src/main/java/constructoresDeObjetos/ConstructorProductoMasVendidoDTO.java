/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import dto.ProductoMasVendidoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorProductoMasVendidoDTO implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos ProductoMasVendidoDTO a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos ProductoMasVendidoDTO.
     * @throws SQLException
     */
    @Override
    public ObservableList<ProductoMasVendidoDTO> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<ProductoMasVendidoDTO> productos = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("producto");
            int numVentas = resultado.getInt("num_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoMasVendidoDTO
            ProductoMasVendidoDTO producto = new ProductoMasVendidoDTO(nombre, numVentas);
            productos.add(producto);//agregamos a la lista el objeto creado
        }
        return productos;
    }

    /**
     * Crea un objeto ProductoMasVendidoDTO a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto ProductoMasVendidoDTO.
     * @throws SQLException
     */
    @Override
    public ProductoMasVendidoDTO construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("producto");
            int numVentas = resultado.getInt("num_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoMasVendidoDTO
            return new ProductoMasVendidoDTO(nombre, numVentas);
        }
        return null;
    }
}
