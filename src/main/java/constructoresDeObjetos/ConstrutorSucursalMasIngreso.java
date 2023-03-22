/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import dto.SucursalMasIngresoDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Monterroso
 */
public class ConstrutorSucursalMasIngreso  implements ConstructorDeObjeto{
     /**
     * Crea una lista de objetos SucursalMasVentasDTO a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos SucursalMasVentasDTO.
     * @throws SQLException
     */
    @Override
    public ObservableList<SucursalMasIngresoDTO> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<SucursalMasIngresoDTO> sucursales = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("sucursal");
            double totalVentas   = resultado.getInt("total_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto SucursalMasVentasDTO
            SucursalMasIngresoDTO sucursal = new SucursalMasIngresoDTO(totalVentas, nombre);
            sucursales.add(sucursal);//agregamos a la lista el objeto creado
        }
        return sucursales;
    }

    /**
     * Crea un objeto ClientesMasGanancia a partir de un ResultSet
     *
     * @param resultado
     * @return El objeto ClientesMasGanancia.
     * @throws SQLException
     */
    @Override
    public SucursalMasIngresoDTO construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("sucursal");
            double totalVentas   = resultado.getInt("total_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto SucursalMasVentasDTO
            return new SucursalMasIngresoDTO(totalVentas, nombre);
        }
        return null;
    }
}
