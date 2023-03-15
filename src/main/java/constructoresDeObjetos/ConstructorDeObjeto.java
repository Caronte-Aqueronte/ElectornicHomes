/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luis Monterroso
 */
public interface ConstructorDeObjeto {

    /**
     * Los metodos deberan ser capaces de contruir una lista de objetos a partir
     * de un ResultSet.
     *
     * @param resultado
     * @return Lista de objetos creada.
     * @throws SQLException
     */
    public Object construirLista(ResultSet resultado) throws SQLException;

    /**
     * Los metodos deberan ser capaces de construir un objeto a partir de un
     * ResultSet.
     *
     * @param resultado
     * @return El objeto construido
     * @throws SQLException
     */
    public Object construirObjeto(ResultSet resultado) throws SQLException;

}
