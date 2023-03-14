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
     * @return Retorna el cliente encontrado o nulo si algo falla o no se encuentra.
     */
    public Cliente buscarClientePorNit(long nit) {
        String query = "SELECT * FROM RegistroVentas.Cliente WHERE nit = ?;";
        try (PreparedStatement ps = Conector.CONEXION.prepareStatement(query)) {
            ps.setLong(1, nit);
            ResultSet resultado = ps.executeQuery();
            return contruirObjeto(resultado);
        } catch (SQLException ex) {
            return null;
        }
    }
}
