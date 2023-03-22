/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;


import dto.ProductoMasVendidoPorSucursalDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorProductoMasVentasPorSucursalDTO implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos ProductoMasVendidoPorSucursalDTO a partir de un
     * ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos ProductoMasVendidoPorSucursalDTO.
     * @throws SQLException
     */
    @Override
    public ObservableList<ProductoMasVendidoPorSucursalDTO> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<ProductoMasVendidoPorSucursalDTO> productos = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String sucursal = resultado.getString("sucursal");
            String nombre = resultado.getString("producto");
            int numVentas = resultado.getInt("num_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoMasVendidoPorSucursalDTO
            ProductoMasVendidoPorSucursalDTO producto = new ProductoMasVendidoPorSucursalDTO(sucursal,
                    nombre, numVentas);
            productos.add(producto);//agregamos a la lista el objeto creado
        }
        return productos;
    }

    /**
     * Crea un objeto ProductoMasVendidoPorSucursalDTO a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto ProductoMasVendidoPorSucursalDTO.
     * @throws SQLException
     */
    @Override
    public ProductoMasVendidoPorSucursalDTO construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String sucursal = resultado.getString("sucursal");
            String nombre = resultado.getString("producto");
            int numVentas = resultado.getInt("num_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoMasVendidoPorSucursalDTO
            return new ProductoMasVendidoPorSucursalDTO(sucursal,
                    nombre, numVentas);
        }
        return null;
    }
}
