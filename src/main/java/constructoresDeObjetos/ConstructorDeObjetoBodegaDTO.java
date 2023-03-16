/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import dto.BodegaDTO;
import dto.ProductoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorDeObjetoBodegaDTO implements ConstructorDeObjeto{
        /**
     * Crea una lista de objetos BodegaDTO a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos BodegaDTO.
     * @throws SQLException
     */
    @Override
    public ObservableList<BodegaDTO> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<BodegaDTO> productos = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            int codigoBarras = resultado.getInt("codigo_barras");
            String nombre = resultado.getString("nombre");
            double precioVenta = resultado.getDouble("precio_venta");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoDTO
            BodegaDTO producto = new BodegaDTO(codigoBarras, nombre, precioVenta);
            productos.add(producto);//agregamos a la lista el objeto creado
        }
        return productos;
    }

    /**
     * Crea un objeto BodegaDTO a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto BodegaDTO.
     * @throws SQLException
     */
    @Override
    public BodegaDTO construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            int codigoBarras = resultado.getInt("codigo_barras");
            String nombre = resultado.getString("nombre");
            double precioVenta = resultado.getDouble("precio_venta");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoDTO
            return new BodegaDTO(codigoBarras, nombre, precioVenta);
        }
        return null;
    }
}
