/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.Empleado;
import services.EmpleadoService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class LoginController implements Initializable {

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
                abrirMenu("MenuVendedor", empleado);
                break;
            case "INVENTARIO":
                break;
            case "BODEGA":
                break;
            case "ADMINISTRACION":
                break;
            default:
                Alert alert = new Alert(Alert.AlertType.ERROR, "Rol desconocido.");
                alert.show();
                break;
        }
    }

    /**
     * Abre el menu que recibe como parametro. Ademas, adjunta la informacion
     * del usuario que se logeo.
     *
     * @param menu
     * @param info
     */
    private void abrirMenu(String menu, Empleado info) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/" + menu + ".fxml"));//cargamos el menu
            Parent parent = loader.load();//crear un pareinte
            Scene scene = new Scene(parent);//creamos la vista con el pareitne
            Stage stage = new Stage();//cremos la ventana
            stage.setUserData(info);//al stage le damos un user data
            stage.setScene(scene);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/aparato-electrico.png")));//le damos un icono a la ventana
            stage.show();//ensenamos la ventana
            stage.setMaximized(true);//la maximizamos
            //codigo para cerrar la ventana actual
            Stage stageActual = (Stage) this.btnEntrar.getScene().getWindow();//obtenemos la ventana actual
            stageActual.close();//cerramos la ventana actual
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
