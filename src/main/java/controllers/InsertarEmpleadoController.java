/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import models.Empleado;
import services.EmpleadoService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class InsertarEmpleadoController implements Initializable {

    private EmpleadoService empleadoService;
    @FXML
    private MFXTextField txtNombre;
    @FXML
    private MFXTextField txtEdad;
    @FXML
    private MFXComboBox<String> comboSucursal;
    @FXML
    private MFXTextField txtUsuario;
    @FXML
    private MFXComboBox<String> comboRol;
    @FXML
    private MFXButton btnGuardar;
    @FXML
    private MFXPasswordField txtPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.empleadoService = new EmpleadoService();
        llenarCombos();
    }

    /**
     * Recuada os textos ingresados en los TextFields, crea un objeto Empleado a
     * partir de ellos y lo envia a insertar.
     *
     * @param event
     */
    @FXML
    private void insertarEnBodega(ActionEvent event) {
        try {
            //capturamos todas las entradas del usuario
            String nombre = txtNombre.getText().trim();
            int edad = Integer.parseInt(txtEdad.getText().trim());
            String sucursal = comboSucursal.getSelectedItem();
            String usuario = txtUsuario.getText().trim();
            String password = txtPassword.getText().trim();
            String rol = comboRol.getSelectedItem();
            //cremaos un Empleado a partir de las entradas de los txt
            Empleado empleado = new Empleado(0, nombre, edad, sucursal, usuario, password, rol);
            //mandamos a insertar el usuario
            new Alert(Alert.AlertType.INFORMATION, empleadoService.crearEmpleado(empleado)).show();
            borrarTextFields();
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Parámetros numéricos con formato invalido.").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    /**
     * Setea en vacio los TextFields.
     */
    public void borrarTextFields() {
        txtNombre.setText("");
        txtEdad.setText("");
        txtUsuario.setText("");
        txtPassword.setText("");
    }

    /**
     * Crea los items para los ComboBoxs.
     */
    private void llenarCombos() {
        //llenando el combobox de sucursales
        ObservableList<String> sucursales = FXCollections.observableArrayList();
        sucursales.add("Sucursal Central");
        sucursales.add("Sucursal Norte");
        sucursales.add("Sucursal Sur"); 
        //anadimos los items al combo de sucursales
        comboSucursal.setItems(sucursales);
        comboSucursal.getSelectionModel().selectFirst();

        //llenando el combobox de trabajadores
        ObservableList<String> rol = FXCollections.observableArrayList();
        rol.add("VENDEDOR");
        rol.add("INVENTARIO");
        rol.add("BODEGA");
        rol.add("ADMINISTRACION");
        //anadimos los items al combo de sucursales
        comboRol.setItems(rol);
        comboRol.getSelectionModel().selectFirst();
    }
}
