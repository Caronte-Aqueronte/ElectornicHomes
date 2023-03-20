/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repostitories;

import config.Conector;
import constructoresDeObjetos.ConstructorDeObjetoCompra;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Compra;

/**
 *
 * @author Luis Monterroso
 */
public class CompraRepository extends ConstructorDeObjetoCompra {

    /**
     * En la base de datos, crea una nueva compra, la inserta y luego la asocia
     * a la bodega.
     *
     * @param compra
     * @return
     */
    public boolean insertarCompraEnBodega(Compra compra) {
        try {
            Conector.CONEXION.setAutoCommit(false);//es una transaccion desactivamos el autocommit
            PreparedStatement ps = Conector.CONEXION.prepareStatement(""
                    + "INSERT INTO RegistroRecursos.Compra VALUES (?,?,?);");
            //damos valores a los ? con los atributos de compra
            ps.setInt(1, compra.getCodigoBarras());
            ps.setDate(2, Date.valueOf(compra.getFechaCompra()));
            ps.setString(3, compra.getNombre());
            if (ps.executeUpdate() <= 0) {//si no se inseeto nada entonces hacemos rolback
                throw new SQLException();
            }
            //query que inserta la compra en en la bodega
            ps = Conector.CONEXION.prepareStatement("INSERT INTO RegistroRecursos.Bodega VALUES (?);");
            ps.setInt(1, compra.getCodigoBarras());//damos valor a ? con el codigo de barras
            if (ps.executeUpdate() <= 0) {//si no se inseeto nada entonces hacemos rolback
                throw new SQLException();
            }
            Conector.CONEXION.commit();
            Conector.CONEXION.setAutoCommit(true);
            return true;

        } catch (SQLException ex) {
            try {
                Conector.CONEXION.rollback();
            } catch (SQLException e) {
            }
            return false;
        }
    }

    /**
     * Modifica una tupla de la tabla Compra.
     *
     * @param compra
     * @param codigoAnterior
     * @return
     */
    public boolean modificarCompra(Compra compra, int codigoAnterior) {
        try {
            Conector.CONEXION.setAutoCommit(false);//es una transaccion desactivamos el autocommit
            PreparedStatement ps = Conector.CONEXION.prepareStatement(""
                    + "UPDATE RegistroRecursos.Compra SET codigo_barras = ?, fecha_compra = ?,"
                    + " producto = ? WHERE codigo_barras = ?;");
            //damos valores a los ? con los atributos de compra
            ps.setInt(1, compra.getCodigoBarras());
            ps.setDate(2, Date.valueOf(compra.getFechaCompra()));
            ps.setString(3, compra.getNombre());
            ps.setInt(4, codigoAnterior);
            if (ps.executeUpdate() <= 0) {//si no se inseeto nada entonces hacemos rolback
                throw new SQLException();
            }
            Conector.CONEXION.commit();
            Conector.CONEXION.setAutoCommit(true);
            return true;
        } catch (SQLException ex) {
            try {
                Conector.CONEXION.rollback();
            } catch (SQLException e) {
            }
            return false;
        }
    }

    /**
     * Busca una compra en la base de datos segun un codigo de barras.
     *
     * @param codigoBarras
     * @return
     */
    public Compra buscarCompraPorCodigo(int codigoBarras) {
        //query que busca a partir de un codigo de barras
        String query = "SELECT * FROM RegistroRecursos.Compra WHERE codigo_barras = ?;";
        try (PreparedStatement ps = Conector.CONEXION.prepareStatement(query)) {
            //dar valor al ? con el codigo de barras
            ps.setInt(1, codigoBarras);
            ResultSet resultado = ps.executeQuery();//ejecutar la query
            return construirObjeto(resultado);
        } catch (SQLException ex) {
            return null;
        }
    }
}
