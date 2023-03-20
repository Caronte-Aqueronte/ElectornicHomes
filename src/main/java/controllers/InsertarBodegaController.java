/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import models.Compra;
import models.Producto;
import services.CompraService;
import services.ProductoService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class InsertarBodegaController implements Initializable {

    private CompraService compraService;
    private ProductoService productoService;
    @FXML
    private MFXTextField txtCodigoBarras;
    @FXML
    private MFXDatePicker txtFecha;
    @FXML
    private MFXButton btnInsertar;
    @FXML
    private MFXComboBox<Producto> comboProducto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.compraService = new CompraService();
        this.productoService = new ProductoService();
        cargarCombo();
    }

    /**
     * Obtiene los textos del los textfields y los envia para insertar un nuevo
     * producto a la bodega.
     *
     * @param event
     */
    @FXML
    private void insertarEnBodega(ActionEvent event) {
        try {
            //obtenemos los valores de los textfield
            int codigoBarras = Integer.parseInt(txtCodigoBarras.getText().trim());
            LocalDate fecha = txtFecha.getValue();
            Producto productoSeleccionado = comboProducto.getSelectedItem();
            //creamos la compra a partir de los datos 
            Compra compra = new Compra(codigoBarras, fecha, productoSeleccionado.getNombre());
            //mandamos a insertar la compra a la bodega
            String confirmacion = compraService.insertarCompraEnBodega(compra);
            new Alert(Alert.AlertType.INFORMATION, confirmacion).showAndWait();
            //cerramos eliminamos los txt
            borrarTextFields();
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.ERROR, "Parámetros numéricos con formato invalido.").showAndWait();
        } catch (NullPointerException ex) {
            new Alert(Alert.AlertType.ERROR, "Parámetros nulos.").showAndWait();
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, ex.getMessage()).showAndWait();
        }
    }

    /**
     * Invoca mostrarProductos de ProductoService para obtener todos los
     * productos y cargarlos a comboProducto.
     */
    private void cargarCombo() {
        ObservableList<Producto> productos = this.productoService.mostrarProductos();
        this.comboProducto.setItems(productos);
    }

    /**
     * Setea todos los textfields con un texto vacio.
     */
    private void borrarTextFields() {
        txtCodigoBarras.setText("");
        txtFecha.setValue(null);
    }

}
