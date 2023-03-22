/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import dto.ProductoMasIngresoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorProductoMasIngresoDTO implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos ProductoMasIngresoDTO a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos ProductoMasIngresoDTO.
     * @throws SQLException
     */
    @Override
    public ObservableList<ProductoMasIngresoDTO> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<ProductoMasIngresoDTO> productos = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("producto");
            double totalVentas = resultado.getInt("total_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoMasVendidoDTO
            ProductoMasIngresoDTO producto = new ProductoMasIngresoDTO(nombre, totalVentas);
            productos.add(producto);//agregamos a la lista el objeto creado
        }
        return productos;
    }

    /**
     * Crea un objeto ProductoMasIngresoDTO a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto ProductoMasIngresoDTO.
     * @throws SQLException
     */
    @Override
    public ProductoMasIngresoDTO construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("producto");
            double totalVentas = resultado.getInt("total_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoMasVendidoDTO
            return new ProductoMasIngresoDTO(nombre, totalVentas);
        }
        return null;
    }
}

