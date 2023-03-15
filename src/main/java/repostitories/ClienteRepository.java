/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repostitories;

import config.Conector;
import constructoresDeObjetos.ConstructorDeObjetoCliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Cliente;

/**
 *
 * @author Luis Monterroso
 */
public class ClienteRepository extends ConstructorDeObjetoCliente {

    /**
     * Se conecta a la base de datos y busca un cliente por su nit en la tabla
     * Cliente.
     *
     * @param nit
     * @return Retorna el cliente encontrado o nulo si algo falla o no se
     * encuentra.
     */
    public Cliente buscarClientePorNit(long nit) {
        String query = "SELECT * FROM RegistroVentas.Cliente WHERE nit = ? AND nit != ?;";
        try (PreparedStatement ps = Conector.CONEXION.prepareStatement(query)) {
            ps.setLong(1, nit);
            ps.setLong(1, 0);
            ResultSet resultado = ps.executeQuery();
            return construirObjeto(resultado);
        } catch (SQLException ex) {
            return null;
        }
    }

     /**
     * Se conecta a la base de datos y busca un cliente por su nit en la tabla
     * Cliente.
     *
     * @param nombre
     * @return Retorna el cliente encontrado o nulo si algo falla o no se
     * encuentra.
     */
    public ObservableList<Cliente> buscarClientesPorNombre(String nombre) {
        String query = "SELECT * FROM RegistroVentas.Cliente WHERE LOWER(nombre) LIKE LOWER(?) AND nit != ?;";
        try (PreparedStatement ps = Conector.CONEXION.prepareStatement(query)) {
            ps.setString(1, "%"+nombre+"%");
            ps.setLong(2, 0);
            ResultSet resultado = ps.executeQuery();
            return construirLista(resultado);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    /**
     * Busca a todos los clientes registrados en la base de datos a excepcion del cliente CF.
     * @return 
     */
    public ObservableList<Cliente> mostrarClientes() {
        String query = "SELECT * FROM RegistroVentas.Cliente WHERE nit != 0;";
        try (Statement ps = Conector.CONEXION.createStatement()) {
            ResultSet resultado = ps.executeQuery(query);
            return construirLista(resultado);
        } catch (SQLException ex) {
            return FXCollections.observableArrayList();
        }
    }
    
    /**
     * Edita un cliente en la base de datos a partir de su antiguo nit.
     * @param cliente
     * @param nitAnterior
     * @return 
     */
    public boolean editarCliente(Cliente cliente, long nitAnterior){
        try {
            Conector.CONEXION.setAutoCommit(false);
            //Query que edita un cliente en la base de datos.
            PreparedStatement ps = Conector.CONEXION.prepareStatement(
            "UPDATE RegistroVentas.Cliente SET nit = ?, nombre = ?, telefono = ? "
                    + "WHERE nit = ?");
            //dar valores a los ? con los datos del cliente y el nit anterior
            ps.setLong(1, cliente.getNit());
            ps.setString(2, cliente.getNombre());
            ps.setInt(3, cliente.getTelefono());
            ps.setLong(4, nitAnterior);
            if(ps.executeUpdate() <= 0){
                throw new SQLException();
            }
            Conector.CONEXION.commit();
            Conector.CONEXION.setAutoCommit(true);
            return true;
            
        } catch (SQLException e) {
            try {
                Conector.CONEXION.rollback();
            } catch (SQLException ex) {
            }
            return false;
        }
    }
}
