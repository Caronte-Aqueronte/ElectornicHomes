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
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import models.Cliente;
import services.ClienteService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class ClientesController extends Controller implements Initializable {

    private ClienteService clienteService;
    @FXML
    private TableColumn nitColumn;
    @FXML
    private TableColumn nombreColumn;
    @FXML
    private TableColumn telefonoColumn;
    @FXML
    private TableColumn accionesColumn;
    @FXML
    private TableView<Cliente> tableClientes;
    @FXML
    private MFXTextField txtBuscar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clienteService = new ClienteService();
        darModeloATabla();
        mostrarClientes();
    }

    /**
     * Da un modelo a las columnas de la tabla y adjunta el boton editar.S
     */
    private void darModeloATabla() {
        //le estamos dando modelos a la tabla de Clientes
        nitColumn.setCellValueFactory(new PropertyValueFactory("nit"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory("nombre"));
        telefonoColumn.setCellValueFactory(new PropertyValueFactory("telefono"));

        //esto se utiliza para darle botones a la celda de acciones, ademas de darles accion a los mismos
        Callback<TableColumn<Cliente, String>, TableCell<Cliente, String>> cellFoctory = (TableColumn<Cliente, String> param) -> {
            // make cell containing buttons
            final TableCell<Cliente, String> cell = new TableCell<Cliente, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {

                        ImageView botonMas = new ImageView(new Image("/img/edit.png"));
                        //damos el tipo de cursor al icono
                        botonMas.setCursor(Cursor.HAND);
                        //le damos un evento de click al boton de agregar
                        botonMas.setOnMouseClicked((MouseEvent event) -> {
                            cargarVentanaDeEdicion();
                        });
                        HBox managebtn = new HBox(botonMas);
                        managebtn.setStyle("-fx-alignment:center");
                        managebtn.setSpacing(10);
                        HBox.setMargin(botonMas, new Insets(2, 2, 0, 3));
                        setGraphic(managebtn);
                        setText(null);
                    }
                }

            };
            return cell;
        };
        accionesColumn.setCellFactory(cellFoctory);//anadimos los botones a la celda de acciones
    }

    /**
     * Muestra a todos los clientes mediante el metodo mostrarClientes de
     * ClienteService.
     */
    private void mostrarClientes() {
        ObservableList<Cliente> clientes = clienteService.mostrarClientes();
        tableClientes.setItems(clientes);
        tableClientes.refresh();
    }

    /**
     * Abre una ventana modal de edicion, pasa los datos del cliente
     * seleccionado, regresca la tabla para ver los cambios realizados.
     */
    private void cargarVentanaDeEdicion() {
        //obtenemos el cliente que se desea editar
        Cliente clienteEditar = tableClientes.getSelectionModel().getSelectedItem();
        //creamos el controlador
        EditarClienteController editarClienteController = new EditarClienteController();
        editarClienteController.setCliente(clienteEditar);
        //mandamos a abrir la vista con el controlador creado
        this.abrirDialogConControlador(editarClienteController, "Edición de clientes", "EditarCliente");
        //luego de abrir la ventana de edicion podemos actualizar la tabla
        mostrarClientes();
    }

    /**
     * Captura el tecleo dentro del txtBuscar, captura la entrada y manda a
     * buscar el producto el cliente.
     *
     * @param event
     */
    @FXML
    private void buscarCliente(KeyEvent event) {
        String busqueda = txtBuscar.getText();
        ObservableList<Cliente> clientes = clienteService.buscarClientesPorNombre(busqueda);
        tableClientes.setItems(clientes);
        tableClientes.refresh();
    }
}
