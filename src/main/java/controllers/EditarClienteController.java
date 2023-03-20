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
import javafx.stage.Stage;
import models.Cliente;
import services.ClienteService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class EditarClienteController implements Initializable {

    private Cliente cliente;
    private ClienteService clienteService;
    @FXML
    private MFXTextField txtNit;
    @FXML
    private MFXTextField txtNombre;
    @FXML
    private MFXTextField txtTelefono;
    @FXML
    private MFXButton btnEditar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //cargamos los parametros del cliente a editar
        cargarLaInfoDelCliente();
        this.clienteService = new ClienteService();
    }

    /**
     * Setea el texto de los TextFields con los atributos del cliente
     * seleccionado para edicion.
     */
    public void cargarLaInfoDelCliente() {
        txtNit.setText(String.valueOf(cliente.getNit()));
        txtNombre.setText(cliente.getNombre());
        txtTelefono.setText(String.valueOf(cliente.getTelefono()));
    }

    /**
     * Setea cliente con el objeto enviado.
     *
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;

    }

    /**
     * Recauda las entradas de los TextFields, crea un objeto Cliente, envia a
     * editar al cliente en base a la nueva infomacion y su nit actual.
     *
     * @param event
     */
    @FXML
    private void editarCliente(ActionEvent event) {
        try {
            long nit = Long.parseLong(txtNit.getText());
            String nombre = txtNombre.getText();
            int telefono = Integer.parseInt(txtTelefono.getText());
            Cliente clienteEditar = new Cliente(nit, nombre, telefono);
            new Alert(Alert.AlertType.INFORMATION,
                    clienteService.editarCliente(clienteEditar, cliente.getNit())).show();
            //cerramos la ventana de edicion
            Stage stageActual = (Stage) this.btnEditar.getScene().getWindow();//obtenemos la ventana actual
            stageActual.close();
        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.ERROR, "Parámetros numéricos con formato incorrecto.").show();
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
        }
    }

}
