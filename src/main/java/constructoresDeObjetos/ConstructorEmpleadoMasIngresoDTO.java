/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import dto.EmpleadoMasIngresoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorEmpleadoMasIngresoDTO implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos EmpleadoMasIngresoDTO a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos EmpleadoMasIngresoDTO.
     * @throws SQLException
     */
    @Override
    public ObservableList<EmpleadoMasIngresoDTO> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<EmpleadoMasIngresoDTO> empleados = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("nombre");
            String sucursal = resultado.getString("sucursal");
            double total = resultado.getDouble("total_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto EmpleadoMasIngresoDTO
            EmpleadoMasIngresoDTO empleado = new EmpleadoMasIngresoDTO(nombre, sucursal, total);
            empleados.add(empleado);//agregamos a la lista el objeto creado
        }
        return empleados;
    }

    /**
     * Crea un objeto EmpleadoMasIngresoDTO a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto EmpleadoMasIngresoDTO.
     * @throws SQLException
     */
    @Override
    public EmpleadoMasIngresoDTO construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("nombre");
            String sucursal = resultado.getString("sucursal");
            double total = resultado.getDouble("total_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto EmpleadoMasIngresoDTO
            return new EmpleadoMasIngresoDTO(nombre, sucursal, total);
        }
        return null;
    }
}
