/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import dto.ClientesMasGananciaDTO;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorDeObjetoClienteMasGanancia implements ConstructorDeObjeto {

    /**
     * Crea una lista de objetos ClientesMasGanancia a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos ClientesMasGanancia.
     * @throws SQLException
     */
    @Override
    public ObservableList<ClientesMasGananciaDTO> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<ClientesMasGananciaDTO> clientesMasGanancia = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            long nit = resultado.getLong("nit");
            String nombre = resultado.getString("nombre");
            double total = resultado.getDouble("sum");
            //apartir de la extraccion de datos crear un nuevo objeto ClientesMasGanancia
            ClientesMasGananciaDTO cliente = new ClientesMasGananciaDTO(nit, nombre, total);
            clientesMasGanancia.add(cliente);//agregamos a la lista el objeto creado
        }
        return clientesMasGanancia;
    }

    /**
     * Crea un objeto ClientesMasGanancia a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto ClientesMasGanancia.
     * @throws SQLException
     */
    @Override
    public ClientesMasGananciaDTO construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            long nit = resultado.getLong("nit");
            String nombre = resultado.getString("nombre");
            double total = resultado.getDouble("sum");
            //apartir de la extraccion de datos crear un nuevo objeto ClientesMasGanancia
            return new ClientesMasGananciaDTO(nit, nombre, total);
        }
        return null;
    }
}
