/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import dto.EmpleadoMasVentasDTO;
import dto.ProductoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorEmpleadoMasVentasDTO implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos EmpleadoMasVentasDTO a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos EmpleadoMasVentasDTO.
     * @throws SQLException
     */
    @Override
    public ObservableList<EmpleadoMasVentasDTO> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<EmpleadoMasVentasDTO> empleados = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("nombre");
            String sucursal = resultado.getString("sucursal");
            int numVentas = resultado.getInt("num_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto EmpleadoMasVentasDTO
            EmpleadoMasVentasDTO empleado = new EmpleadoMasVentasDTO(nombre, sucursal, numVentas);
            empleados.add(empleado);//agregamos a la lista el objeto creado
        }
        return empleados;
    }

    /**
     * Crea un objeto EmpleadoMasVentasDTO a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto EmpleadoMasVentasDTO.
     * @throws SQLException
     */
    @Override
    public EmpleadoMasVentasDTO construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("nombre");
            String sucursal = resultado.getString("sucursal");
            int numVentas = resultado.getInt("num_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto EmpleadoMasVentasDTO
            return new EmpleadoMasVentasDTO(nombre, sucursal, numVentas);
        }
        return null;
    }
}
