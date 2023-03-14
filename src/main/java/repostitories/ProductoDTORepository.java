/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repostitories;

import config.Conector;
import constructoresDeObjetos.ConstructorDeObjetoProductoDTO;
import dto.ProductoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Luis Monterroso
 */
public class ProductoDTORepository extends ConstructorDeObjetoProductoDTO {
    
    public ObservableList<ProductoDTO> mostrarProductosDtoPorSucursal(String sucursal) {
        String query = "SELECT a.codigo_barras, b.nombre, b.precio_venta FROM "
                + "RegistroRecursos.Compra a INNER JOIN RegistroRecursos.Producto "
                + "b ON a.producto =  b.nombre INNER JOIN RegistroRecursos.Inventario "
                + "c ON c.compra = a.codigo_barras WHERE c.sucursal = ? AND c.estado != ?;";
        try (PreparedStatement ps = Conector.CONEXION.prepareStatement(query)) {
            ps.setString(1, sucursal);
            ps.setString(2, "VENDIDO");
            ResultSet resultado = ps.executeQuery();
            return contruirLista(resultado);
        } catch (SQLException ex) {
            return FXCollections.observableArrayList();
        }
    }
}
