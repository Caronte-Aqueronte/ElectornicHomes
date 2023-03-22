/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repostitories;

import config.Conector;
import constructoresDeObjetos.ConstructorDeObjetoVenta;
import dto.ProductoDTO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.ObservableList;
import models.Cliente;
import models.Venta;

/**
 *
 * @author Luis Monterroso
 */
public class VentaRepository extends ConstructorDeObjetoVenta {

    /**
     * Registra una venta en la base de dados. Para ello, registra a venta
     * seguido del Cliente, Adquisicion, Desgloce y edicion del inventario.
     *
     * @param cliente
     * @param venta
     * @param carrito
     * @return
     */
    public boolean registrarVenta(Cliente cliente, Venta venta, ObservableList<ProductoDTO> carrito) {

        try {
            Conector.CONEXION.setAutoCommit(false);//al ser una transaccion desactivamos el autocommit
            PreparedStatement ps = Conector.CONEXION.prepareStatement("INSERT INTO "
                    + "RegistroVentas.Venta (id_venta, sucursal, empleado, total, "
                    + "descuento, importe_venta, fecha) "
                    + "VALUES(?,?,?,?,?,?,?);");

            //damos valores a los ? con los datos de la venta
            ps.setString(1, venta.getIdVenta());
            ps.setString(2, venta.getSucursal());
            ps.setInt(3, venta.getEmpleado());
            ps.setDouble(4, venta.getTotal());
            ps.setDouble(5, venta.getDescuento());
            ps.setDouble(6, venta.getImporteVenta());
            ps.setDate(7, Date.valueOf(venta.getFecha()));
            //ejecutamos la query si no se inserto nada entonces devolvemos un sqlexception
            if (ps.executeUpdate() <= 0) {
                throw new SQLException();
            }

            //Insertamos el cliente si no existe dentro de la bd
            ps = Conector.CONEXION.prepareStatement("INSERT INTO RegistroVentas.Cliente "
                    + "VALUES(?,?,?) ON CONFLICT DO NOTHING;");
            //damos valores a los ? con los datos del cliente
            ps.setLong(1, cliente.getNit());
            ps.setString(2, cliente.getNombre());
            ps.setInt(3, cliente.getTelefono());
            ps.executeUpdate();//insertamos el cliente, no se valida pues puiede insertarse o no

            //insertamos la adquisicion del cliente
            ps = Conector.CONEXION.prepareStatement("INSERT INTO RegistroVentas.Adquisicion "
                    + "VALUES (?,?);");
            //damos valores a los ? con los datos del usuario y de la venta
            ps.setString(1, venta.getIdVenta());
            ps.setLong(2, cliente.getNit());
            //ejecutamos la query si no se inserto nada entonces devolvemos un sqlexception
            if (ps.executeUpdate() <= 0) {
                throw new SQLException();
            }

            //el desgloce de la venta, para ello iteramos en el arreglo del carrito y vamos insertando cada registro
            for (ProductoDTO item : carrito) {
                ps = Conector.CONEXION.prepareStatement("INSERT INTO RegistroVentas.Desgloce "
                        + "VALUES (?,?,?);");
                ps.setString(1, venta.getIdVenta());
                ps.setInt(2, item.getCodigoBarras());
                ps.setDouble(3, item.getPrecioVenta());

                if (ps.executeUpdate() <= 0) {
                    throw new SQLException();
                }
                //marcamos el producto vendido como VENDIDO en el inventario

                ps = Conector.CONEXION.prepareStatement("UPDATE RegistroRecursos.Inventario"
                        + " SET estado = ? WHERE compra = ?;");
                ps.setString(1, "VENDIDO");
                ps.setInt(2, item.getCodigoBarras());
                if (ps.executeUpdate() <= 0) {
                    throw new SQLException();
                }
            }
            Conector.CONEXION.commit();
            Conector.CONEXION.setAutoCommit(true);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                Conector.CONEXION.rollback(); //si hay algo malo en la transaccion entonces hacemos rollback()
            } catch (SQLException e) {

            }
            return false;
        }
    }

    /**
     * Trae la ultima compra de un cliente a partir de su nit.
     *
     * @param cliente
     * @return
     */
    public Venta traerUltimaCompraDeUnCliente(Cliente cliente) {
        String query = "SELECT *  FROM RegistroVentas.Venta a INNER JOIN RegistroVentas.Adquisicion b"
                + " ON b.venta = a.id_venta WHERE b.cliente = ? ORDER BY a.num_venta DESC LIMIT 1;";
        try (PreparedStatement ps = Conector.CONEXION.prepareCall(query)) {
            ps.setLong(1, cliente.getNit());
            ResultSet resultado = ps.executeQuery();
            return construirObjeto(resultado);
        } catch (SQLException ex) {
            return null;
        }
    }

}
