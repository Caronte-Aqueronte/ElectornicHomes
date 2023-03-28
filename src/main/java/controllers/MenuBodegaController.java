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
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class MenuBodegaController extends Controller implements Initializable {

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
     * Utiliza abrirMenuEnScrollPane para abrir la vista Bodega.fxml dentro de
     * MFXScrollPane panelContenedor.
     *
     * @param event
     */
    @FXML
    private void abrirBodega(ActionEvent event) {
        this.abrirMenuEnScrollPane(panelContenedor, "Bodega", panelContenedor);

    }

    /**
     * Utiliza abrirMenuEnScrollPane para abrir la vista Productos.fxml dentro
     * de MFXScrollPane panelContenedor.
     *
     * @param event
     */
    @FXML
    private void abrirProductos(ActionEvent event) {
        this.abrirMenuEnScrollPane(panelContenedor, "Productos", panelContenedor);
    }

    @FXML
    private void logOut(ActionEvent event) {
        this.abrirMenu("Login", labelUsuario, false, false);
    }

}
