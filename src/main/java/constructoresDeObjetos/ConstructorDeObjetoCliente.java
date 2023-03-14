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
import models.Cliente;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorDeObjetoCliente implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos Cliente a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos Cliente.
     * @throws SQLException
     */
    @Override
    public ObservableList<Cliente> contruirLista(ResultSet resultado) throws SQLException {
        ObservableList<Cliente> clientes = FXCollections.observableArrayList();//crear el array;
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            int nit = resultado.getInt("nit");
            String nombre = resultado.getString("nombre");
            int telefono = resultado.getInt("telefono");
            //apartir de la extraccion de datos crear un nuevo objeto Empleado
            Cliente cliente = new Cliente(nit, nombre, telefono);
            clientes.add(cliente);//agregamos a la lista el objeto creado
        }
        return clientes;
    }

    /**
     * Crea un objeto Cliente a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto Cliente.
     * @throws SQLException
     */
    @Override
    public Cliente contruirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            int nit = resultado.getInt("nit");
            String nombre = resultado.getString("nombre");
            int telefono = resultado.getInt("telefono");
            //apartir de la extraccion de datos crear un nuevo objeto Cliente
            return new Cliente(nit, nombre, telefono);
        }
        return null;
    }

}
