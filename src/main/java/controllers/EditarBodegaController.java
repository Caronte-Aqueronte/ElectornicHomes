/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXFilterComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import models.Compra;
import models.Producto;
import services.CompraService;
import services.ProductoService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class EditarBodegaController implements Initializable {

    private Compra compra;
    private ProductoService productoService;
    private CompraService compraService;
    @FXML
    private MFXTextField txtCodigoBarras;
    @FXML
    private MFXDatePicker txtFecha;
    @FXML
    private MFXButton btnInsertar;
    @FXML
    private MFXFilterComboBox<Producto> comboProducto;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.productoService = new ProductoService();
        this.compraService = new CompraService();
        cargarCombo();
        //mandamos a setear los txt con los valores de la compra
        setearTextFields();
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    /**
     * Recolecta las entradas, manda a editar el producto en bodega con el
     * codigo de barras de compra.
     *
     * @param event
     */
    @FXML
    private void editarBodega(ActionEvent event) {
        try {
            //obtemos las entradas de los txt
            int codigoBarras = Integer.parseInt(txtCodigoBarras.getText());
            LocalDate fecha = txtFecha.getValue();
            String nombre = comboProducto.getSelectedItem().getNombre();
            //creamos el objeto Comrpa a partir de las entradas
            Compra compraEdit = new Compra(codigoBarras, fecha, nombre);
            //mandamos a editar el registro en a base de datos
            String confirmacion = this.compraService.modificarCompra(compraEdit, compra.getCodigoBarras());
            new Alert(Alert.AlertType.INFORMATION, confirmacion).showAndWait();
            Stage stage = (Stage) txtCodigoBarras.getScene().getWindow();
            stage.close();

        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.ERROR, "Parámetros numéricos con formato invalido.").showAndWait();
        } catch (NullPointerException ex) {
            new Alert(Alert.AlertType.ERROR, "Parámetros nulos.").showAndWait();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }

    /**
     * Le da un valor inicial a los txt con los valores de compra.
     */
    private void setearTextFields() {
        txtCodigoBarras.setText(String.valueOf(compra.getCodigoBarras()));
        txtFecha.setValue(compra.getFechaCompra());
        //con un foreach iteramos entre todos los items del combo
        for (Producto item : comboProducto.getItems()) {
            //si los nombres coinciden entonces lo seleccionamos por defecto en el combo
            if (item.getNombre().equals(compra.getNombre())) {
                comboProducto.selectItem(item);
            }
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
}
