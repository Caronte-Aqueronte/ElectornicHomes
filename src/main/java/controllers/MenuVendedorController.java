/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import io.github.palexdev.materialfx.controls.MFXScrollPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class MenuVendedorController extends Controller implements Initializable {

    @FXML
    private Button btnVentas;
    @FXML
    private Button btnClientes;
    @FXML
    private MFXScrollPane panelContenedor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //se configura el scrollpane para que el contenido se auto ajuste al tamanio del mismo
        panelContenedor.setFitToHeight(true);
        panelContenedor.setFitToWidth(true);

    }

    /**
     * Carga los datos del Empleado y abre el menu de ventas.
     *
     * @param event
     */
    @FXML
    private void abrirMenuVentas(ActionEvent event) {
        abrirMenuEnScrollPane(panelContenedor, "Ventas", btnVentas);
    }

    /**
     * Carga los datos del Empleado y abre el menu de clientes.
     *
     * @param event
     */
    @FXML
    private void abrirMenuClientes(ActionEvent event) {
        abrirMenuEnScrollPane(panelContenedor, "Clientes", btnVentas);
    }

}
