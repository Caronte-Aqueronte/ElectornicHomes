/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import models.Empleado;
import services.EmpleadoService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class TrabajadoresController extends Controller implements Initializable {

    private EmpleadoService empleadoService;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colSucursal;
    @FXML
    private TableColumn colRol;
    @FXML
    private ImageView btnAgregar;
    @FXML
    private TableView<Empleado> tablaEmpleados;
    @FXML
    private TableColumn colId;
    @FXML
    private MFXTextField txtBuscarEmpleado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.empleadoService = new EmpleadoService();
        darModeloATabla();
        mostrarEmpleados();
    }

    /**
     * Captura el tecleo dentro de txtBuscarEmpleado y utiliza
     * buscarEmpleadoPorNombre() de EmpleadoService para encontrar al usuario
     * buscado.
     *
     * @param event
     */
    @FXML
    private void buscarEmpleado(KeyEvent event) {
        String nombre = txtBuscarEmpleado.getText().trim();//capturamos la entrada
        ObservableList<Empleado> empleados = this.empleadoService.buscarEmpleadoPorNombre(nombre);
        this.tablaEmpleados.setItems(empleados);//seteamos los items de la tabla
        this.tablaEmpleados.refresh();//refrescamos la tabla
    }

    @FXML
    private void abrirMenuInsertar(MouseEvent event) {
        this.abrirDialog("InsertarEmpleado", "Crear empleado");
        mostrarEmpleados();
    }

    /**
     * Aplica un modelo a las columnas de la tabla.
     */
    private void darModeloATabla() {
        this.colId.setCellValueFactory(new PropertyValueFactory("idEmpleado"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colSucursal.setCellValueFactory(new PropertyValueFactory("sucursal"));
        this.colRol.setCellValueFactory(new PropertyValueFactory("rol"));
    }

    /**
     * Utiliza mostrarEmpleados() de EmpleadoService para mandar a traer a los
     * empleados de la empresa.
     */
    private void mostrarEmpleados() {
        ObservableList<Empleado> empleados = this.empleadoService.mostrarEmpleados();
        this.tablaEmpleados.setItems(empleados);//seteamos los items de la tabla
        this.tablaEmpleados.refresh();//refrescamos la tabla
    }

}
