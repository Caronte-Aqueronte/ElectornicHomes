/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import dto.ProductoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Compra;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorDeObjetoCompra implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos Compra a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos Compra.
     * @throws SQLException
     */
    @Override
    public ObservableList<Compra> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<Compra> compras = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            int codigoBarras = resultado.getInt("codigo_barras");
            LocalDate fecha = resultado.getDate("fecha_compra").toLocalDate();
            String nombre = resultado.getString("producto");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoDTO
            Compra compra = new Compra(codigoBarras, fecha, nombre);
            compras.add(compra);//agregamos a la lista el objeto creado
        }
        return compras;
    }

    /**
     * Crea un objeto Compra a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto Compra.
     * @throws SQLException
     */
    @Override
    public Compra construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            int codigoBarras = resultado.getInt("codigo_barras");
            LocalDate fecha = resultado.getDate("fecha_compra").toLocalDate();
            String nombre = resultado.getString("producto");
            //apartir de la extraccion de datos crear un nuevo objeto ProductoDTO
            return new Compra(codigoBarras, fecha, nombre);
        }
        return null;
    }
}
