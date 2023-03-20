/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import dto.ProductoDTO;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import models.Empleado;
import services.ProductoDTOService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class InventarioController implements Initializable {

    private Empleado empleadoLogeado;
    private ProductoDTOService productoDTOService;
    @FXML
    private TableView<ProductoDTO> tablaInventario;
    @FXML
    private TableColumn codugoBarrasColumn;
    @FXML
    private TableColumn nombreColumn;
    @FXML
    private TableColumn precioColumns;
    @FXML
    private MFXTextField txtBuscar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.productoDTOService = new ProductoDTOService();
        empleadoLogeado = LoginController.empleadoLogeado;
        darModeloATabla();
        mostrarInventarioDeLaSucursal();
    }

    /**
     * Busca el inventario de la sucursal de vendedor mediante el metodo
     * buscarProductoDtoPorCodigoBarras de ProductoDTOService.
     */
    @FXML
    private void buscarProducto(KeyEvent event) {
        String busqueda = txtBuscar.getText();
        //mandamos a buscar el inventario de la sucursal del empleado
        ObservableList<ProductoDTO> inventario = productoDTOService.buscarProductoDtoPorCodigoBarras(
                empleadoLogeado.getSucursal(), busqueda);
        tablaInventario.setItems(inventario);
        tablaInventario.refresh();
    }

    /**
     * Busca el inventario de la sucursal de vendedor mediante el metodo
     * mostrarInventarioDeSucursal de ProductoDTOService.
     */
    private void mostrarInventarioDeLaSucursal() {
        Empleado empleado = LoginController.empleadoLogeado;
        //mandamos a buscar el inventario de la sucursal del empleado
        ObservableList<ProductoDTO> inventario = productoDTOService.mostrarInventarioDeSucursal(empleado.getSucursal());
        tablaInventario.setItems(inventario);
        tablaInventario.refresh();
    }

    /**
     * Le da un modelo a las TableColumn de la tablaInventario
     */
    private void darModeloATabla() {
        //le estamos dando modelos a la tabla de Inventario
        codugoBarrasColumn.setCellValueFactory(new PropertyValueFactory("codigoBarras"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory("nombre"));
        precioColumns.setCellValueFactory(new PropertyValueFactory("precioVenta"));
    }

}
