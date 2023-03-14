/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Empleado;

/**
 *
 * @author Luis Monterroso
 */
public class ContstructorDeObjetoEmpleado implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos Empleado a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos Empleado.
     * @throws SQLException
     */
    @Override
    public ObservableList<Empleado> contruirLista(ResultSet resultado) throws SQLException {
        ObservableList<Empleado> empleados = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            int idEmpleado = resultado.getInt("id_empleado");
            String nombre = resultado.getString("nombre");
            int edad = resultado.getInt("edad");
            String sucursal = resultado.getString("sucursal");
            String usuario = resultado.getString("usuario");
            String password = resultado.getString("contra");
            String rol = resultado.getString("rol");
            //apartir de la extraccion de datos crear un nuevo objeto Empleado
            Empleado empleado = new Empleado(idEmpleado, nombre, edad, sucursal, usuario, password, rol);
            empleados.add(empleado);//agregamos a la lista el objeto creado
        }
        return empleados;
    }

    /**
     * Crea un objeto Empleado a partir de un ResultSet
     * @param resultado
     * @return El objeto Empleado.
     * @throws SQLException 
     */
    @Override
    public Empleado contruirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Extraer las columnas de la tabla
            int idEmpleado = resultado.getInt("id_empleado");
            String nombre = resultado.getString("nombre");
            int edad = resultado.getInt("edad");
            String sucursal = resultado.getString("sucursal");
            String usuario = resultado.getString("usuario");
            String password = resultado.getString("contra");
            String rol = resultado.getString("rol");
            //apartir de la extraccion de datos crear un nuevo objeto Empleado
            return new Empleado(idEmpleado, nombre, edad, sucursal, usuario, password, rol);
        }
        return null;
    }

}
