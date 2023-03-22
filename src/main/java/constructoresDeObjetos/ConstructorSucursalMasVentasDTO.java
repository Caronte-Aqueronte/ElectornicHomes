/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constructoresDeObjetos;

import dto.SucursalMasVentasDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Monterroso
 */
public class ConstructorSucursalMasVentasDTO implements ConstructorDeObjeto{
     /**
     * Crea una lista de objetos SucursalMasVentasDTO a partir de un ResultSet.
     *
     * @param resultado
     * @return Lista de Objetos SucursalMasVentasDTO.
     * @throws SQLException
     */
    @Override
    public ObservableList<SucursalMasVentasDTO> construirLista(ResultSet resultado) throws SQLException {
        ObservableList<SucursalMasVentasDTO> sucursales = FXCollections.observableArrayList();
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("sucursal");
            int numVentas = resultado.getInt("num_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto SucursalMasVentasDTO
            SucursalMasVentasDTO sucursal = new SucursalMasVentasDTO(numVentas, nombre);
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
    public SucursalMasVentasDTO construirObjeto(ResultSet resultado) throws SQLException {
        while (resultado.next()) {
            //Esxtraer las columnas de la tabla
            String nombre = resultado.getString("sucursal");
            int numVentas = resultado.getInt("num_ventas");
            //apartir de la extraccion de datos crear un nuevo objeto SucursalMasVentasDTO
            return new SucursalMasVentasDTO(numVentas, nombre);
        }
        return null;
    }
}
