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
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Empleado;

/**
 *
 * @author Luis Monterroso
 */
public class EmpleadoRepository extends ContstructorDeObjetoEmpleado {

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

    /**
     * Se comunica con la base de datos y obtiene los empleados que cumplan con
     * la busqueda.
     *
     * @param nombre
     * @return Empleado obtenido.
     */
    public ObservableList<Empleado> buscarEmpleadoPorNombre(String nombre) {
        //String con la query de seleccion
        try (PreparedStatement st = Conector.CONEXION.prepareStatement("SELECT * FROM "
                + "RegistroPersonal.Empleado WHERE LOWER(nombre) LIKE LOWER(?);")) {
            //seteamos el valor de ? con el nombre que se recibe como paremetro
            st.setString(1, "%" + nombre + "%");
            //ejecucion de la query
            ResultSet resultado = st.executeQuery();//ejecutar query
            return construirLista(resultado);
        } catch (SQLException ex) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Se comunica con la base de datos y obtiene todos los empleados.
     *
     * @return Empleado obtenido.
     */
    public ObservableList<Empleado> traerEmpleados() {
        //String con la query de seleccion
        try (Statement st = Conector.CONEXION.createStatement()) {
            //ejecucion de la query
            ResultSet resultado = st.executeQuery("SELECT * FROM RegistroPersonal.Empleado;");//ejecutar query
            return construirLista(resultado);
        } catch (SQLException ex) {
            return FXCollections.observableArrayList();
        }
    }

    /**
     * Se comunica con la base de datos e inserta un nuevo empleado a paetir del
     * objeto Empleado enviado como parametro.
     *
     * @param empleado
     * @return
     */
    public boolean insertarEmpleado(Empleado empleado) {
        try {
            //es una tansaccion entonces quitamos el autocommit
            Conector.CONEXION.setAutoCommit(false);
            PreparedStatement ps = Conector.CONEXION.prepareStatement("INSERT INTO"
                    + " RegistroPersonal.Empleado(nombre, edad, sucursal, usuario, contra, rol) "
                    + "VALUES (?,?,?,?,?,?);");
            //damos vaores a los ? con los atributos d ela clase Empleado
            ps.setString(1, empleado.getNombre());
            ps.setInt(2, empleado.getEdad());
            ps.setString(3, empleado.getSucursal());
            ps.setString(4, empleado.getUsuario());
            ps.setString(5, empleado.getPassword());
            ps.setString(6, empleado.getRol());
            //vemos si al ejecutar la query se inserto algo
            if (ps.executeUpdate() <= 0) {
                throw new SQLException();
            }
            Conector.CONEXION.commit();
            Conector.CONEXION.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            try {

            } catch (Exception ex) {
            }
            return false;
        }
    }
}
