/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import dto.ProductoMasIngresoPorSucursalDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorProductoMasIngresoPorSucursalDTO implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos ProductoMasIngresoPorSucursalDTO a partir de un
     * ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos ProductoMasIngresoPorSucursalDTO.
     * @throws SQLException
     */
    @Override
    public ObservableList<ProductoMasIngresoPorSucursalDTO> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<ProductoMasIngresoPorSucursalDTO> productos = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String sucursal = resultado.getString("sucursal");
            String nombre = resultado.getString("producto");
            double total_ventas = resultado.getInt("total_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoMasIngresoPorSucursalDTO
            ProductoMasIngresoPorSucursalDTO producto = new ProductoMasIngresoPorSucursalDTO(sucursal,
                    nombre, total_ventas);
            productos.add(producto);//agregamos a la lista el objeto creado
        }
        return productos;
    }

    /**
     * Crea un objeto ProductoMasIngresoPorSucursalDTO a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto ProductoMasIngresoPorSucursalDTO.
     * @throws SQLException
     */
    @Override
    public ProductoMasIngresoPorSucursalDTO construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String sucursal = resultado.getString("sucursal");
            String nombre = resultado.getString("producto");
            double total_ventas = resultado.getInt("total_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoMasIngresoPorSucursalDTO
            return new ProductoMasIngresoPorSucursalDTO(sucursal,
                    nombre, total_ventas);
        }
        return null;
    }
}
