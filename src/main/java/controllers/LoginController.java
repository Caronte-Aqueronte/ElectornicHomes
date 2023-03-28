/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import models.Empleado;
import services.EmpleadoService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class LoginController extends Controller implements Initializable {

    public static Empleado empleadoLogeado;
    private EmpleadoService empleadoService;
    @FXML
    private MFXPasswordField txtPassword;
    @FXML
    private Button btnEntrar;
    @FXML
    private MFXTextField txtUsuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.empleadoService = new EmpleadoService();
    }

    /**
     * Obtiene los valores de los campos, los valida e instancia el metodo de
     * login
     *
     * @param event
     */
    @FXML
    private void login(ActionEvent event) {
        //obtener los valores
        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText().trim();
        //construir el objeto dto para la busqueda dle suaurio
        Empleado empleado = new Empleado(usuario, password);
        try {
            Empleado empleadoEncontrado = empleadoService.login(empleado);
            empleadoLogeado = empleadoEncontrado;
            elegirMenu(empleadoEncontrado);
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
            alert.show();
        }
    }

    /**
     * Intancia al metodo abirMenu() y l envia el menu ha abrir.
     *
     * @param empleado
     */
    private void elegirMenu(Empleado empleado) {
        switch (empleado.getRol()) {
            case "VENDEDOR":
                abrirMenu("MenuVendedor", this.btnEntrar, true, true);
                break;
            case "INVENTARIO":
                abrirMenu("MenuInventario", this.btnEntrar, true, true);
                break;
            case "BODEGA":
                abrirMenu("MenuBodega", this.btnEntrar, true, true);
                break;
            case "ADMINISTRACION":
                abrirMenu("MenuAdmin", this.btnEntrar, true, true);
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Rol desconocido.").show();
                break;
        }
    }

}
