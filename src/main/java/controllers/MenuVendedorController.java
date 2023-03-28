/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import io.github.palexdev.materialfx.controls.MFXScrollPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    @FXML
    private Label labelUsuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //setear la label con el nombre del usuario logeado
        labelUsuario.setText(LoginController.empleadoLogeado.getNombre() + ", " + LoginController.empleadoLogeado.getSucursal()
                + "\n" + LoginController.empleadoLogeado.getRol());
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

    @FXML
    private void logOut(ActionEvent event) {
        this.abrirMenu("Login", btnVentas, false, false);
    }

}
