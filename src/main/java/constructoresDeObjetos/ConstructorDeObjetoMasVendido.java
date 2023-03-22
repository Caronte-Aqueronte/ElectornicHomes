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
import dto.ProductoMasVendidoDTO;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorDeObjetoMasVendido implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos MasVendido a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos MasVendido.
     * @throws SQLException
     */
    @Override
    public ObservableList<ProductoMasVendidoDTO> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<ProductoMasVendidoDTO> masVendidos = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombreProduto = resultado.getString("producto");
            int numeroVentas = resultado.getInt("count");
            //apartir de la extraccion de datos crear un nuevo objeto Producto
            ProductoMasVendidoDTO masVendido = new ProductoMasVendidoDTO(nombreProduto, numeroVentas);
            masVendidos.add(masVendido);//agregamos a la lista el objeto creado
        }
        return masVendidos;
    }

    /**
     * Crea un objeto MasVendido a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto MasVendido.
     * @throws SQLException
     */
    @Override
    public ProductoMasVendidoDTO construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombreProduto = resultado.getString("producto");
            int numeroVentas = resultado.getInt("count");
            //apartir de la extraccion de datos crear un nuevo objeto Producto
            return new ProductoMasVendidoDTO(nombreProduto, numeroVentas);
        }
        return null;
    }
}
