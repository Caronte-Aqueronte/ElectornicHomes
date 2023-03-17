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

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class MenuBodegaController extends Controller implements Initializable {

    @FXML
    private MFXScrollPane panelContenedor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        panelContenedor.setFitToWidth(true);
        panelContenedor.setFitToHeight(true);
    }    

    @FXML
    private void abrirBodega(ActionEvent event) {
        
    }

    @FXML
    private void abrirCompras(ActionEvent event) {
    }

    @FXML
    private void abrirIngresos(ActionEvent event) {
    }

    @FXML
    private void abrirProductos(ActionEvent event) {
        this.abrirMenuEnScrollPane(panelContenedor, "Productos", panelContenedor);
    }
    
}