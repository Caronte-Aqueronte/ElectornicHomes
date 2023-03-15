/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repostitories;

import config.Conector;
import constructoresDeObjetos.ContstructorDeObjetoEmpleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Empleado;

/**
 *
 * @author Luis Monterroso
 */
public class EmpleadoRepository extends ContstructorDeObjetoEmpleado{

    /**
     * Se comunica con la base de datos y obtiene un Empleado a partir de su
     * usuario y password.
     *
     * @param empleado
     * @return Empleado obtenido.
     */
    public Empleado traerEmpleadoPorUsuarioYPassword(Empleado empleado) {
        //String con la query de seleccion
        String query = "SELECT * FROM RegistroPersonal.Empleado WHERE usuario = ? AND contra = ?;";
        try (PreparedStatement pr = Conector.CONEXION.prepareStatement(query)) {
            pr.setString(1, empleado.getUsuario());//damos valores a los ?
            pr.setString(2, empleado.getPassword());
            ResultSet resultado = pr.executeQuery();//ejecutar query
            return construirObjeto(resultado);
        } catch (SQLException ex) {
            return null;
        }
    }
}
