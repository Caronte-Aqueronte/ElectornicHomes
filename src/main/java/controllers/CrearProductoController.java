/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import models.Producto;
import services.ProductoService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class CrearProductoController implements Initializable {

    private ProductoService productoService;
    @FXML
    private MFXTextField txtNombre;
    @FXML
    private MFXTextField txtPrecioCompra;
    @FXML
    private MFXTextField txtPrecioVenta;
    @FXML
    private MFXButton btnEditar;
    @FXML
    private TextArea txtDescripcion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.productoService = new ProductoService();
    }

    @FXML
    private void crearProducto(ActionEvent event) {
        try {
            String nombre = txtNombre.getText().trim();
            String descripcion = txtDescripcion.getText().trim();
            double precioCompra = Double.parseDouble(txtPrecioCompra.getText());
            double precioVenta = Double.parseDouble(txtPrecioVenta.getText());
            String confirmacion = productoService.insertarProducto(new Producto(nombre, descripcion, precioCompra, precioVenta));
            new Alert(Alert.AlertType.INFORMATION, confirmacion).showAndWait();
            //eliminamos los campos
            eliminarCampos();
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.ERROR, "Parametros numericos con formato invalido.").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
    
    private void eliminarCampos(){
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecioCompra.setText("");
        txtPrecioVenta.setText("");
    }

}
