/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Venta;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorDeObjetoVenta implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos Venta a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos Venta.
     * @throws SQLException
     */
    @Override
    public ObservableList<Venta> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<Venta> ventas = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String idVenta = resultado.getString("id_venta");
            String sucursal = resultado.getString("sucursal");
            int empleado = resultado.getInt("empleado");
            double total = resultado.getDouble("total");
            double descuento = resultado.getDouble("descuento");
            double importeVenta = resultado.getDouble("importe_venta");
            LocalDate fecha = resultado.getDate("fecha").toLocalDate();
            //apartir de la extraccion de datos crear un nuevo objeto Venta
            Venta venta = new Venta(idVenta, sucursal, empleado, total, descuento, importeVenta, fecha);
            ventas.add(venta);//agregamos a la lista el objeto creado
        }
        return ventas;
    }

    /**
     * Crea un objeto Venta a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto Venta.
     * @throws SQLException
     */
    @Override
    public Venta construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String idVenta = resultado.getString("id_venta");
            String sucursal = resultado.getString("sucursal");
            int empleado = resultado.getInt("empleado");
            double total = resultado.getDouble("total");
            double descuento = resultado.getDouble("descuento");
            double importeVenta = resultado.getDouble("importe_venta");
            LocalDate fecha = resultado.getDate("fecha").toLocalDate();
            //apartir de la extraccion de datos crear un nuevo objeto Venta
            return new Venta(idVenta, sucursal, empleado, total, descuento, importeVenta, fecha);
        }
        return null;
    }
}
