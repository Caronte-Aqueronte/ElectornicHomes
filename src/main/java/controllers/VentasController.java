/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import dto.ProductoDTO;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.controls.MFXToggleButton;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import services.VentaService;
import models.Venta;
import javafx.scene.control.Label;
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
import models.Empleado;
import services.ClienteService;
import services.ProductoDTOService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class VentasController implements Initializable {

    private boolean estadoCf = false;
    private ClienteService clienteService;
    private ProductoDTOService productoDTOService;
    private VentaService ventaService;

    @FXML
    private TableColumn codugoBarrasColumn;
    @FXML
    private TableColumn nombreColumn;
    @FXML
    private TableColumn precioColumns;
    @FXML
    private TableColumn accionesColumn;
    @FXML
    private TableColumn carritoCodigoColumn;
    @FXML
    private TableColumn carritoNombreColumn;
    @FXML
    private TableColumn carritoPrecioColumn;
    @FXML
    private TableColumn carriotAccionesColumn;
    @FXML
    private MFXTextField txtNit;
    @FXML
    private MFXTextField txtNombre;
    @FXML
    private MFXTextField txtTelefono;
    @FXML
    private MFXDatePicker txtFecha;
    @FXML
    private MFXTextField txtTotal;
    @FXML
    private MFXTextField txtNumItems;
    @FXML
    private MFXButton btnPagar;
    @FXML
    private MFXToggleButton toggleCF;
    @FXML
    private Label labelNombre;
    @FXML
    private Label labelTelefono;
    @FXML
    private Label labelNit;
    @FXML
    private TableView<ProductoDTO> tablaInventario;
    @FXML
    private TableView<ProductoDTO> tablaCarrito;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clienteService = new ClienteService();
        productoDTOService = new ProductoDTOService();
        ventaService = new VentaService();
        darModeloALasTablas();
        mostrarInventarioDeLaSucursal();

    }

    /**
     * Busca el inventario de la sucursal de vendedor mediante el metodo
     * buscarProductoDtoPorCodigoBarras de ProductoDTOService.
     */
    private void mostrarInventarioDeLaSucursal() {
        Empleado empleado = LoginController.empleadoLogeado;
        //mandamos a buscar el inventario de la sucursal del empleado
        ObservableList<ProductoDTO> inventario = productoDTOService.mostrarInventarioDeSucursal(empleado.getSucursal());
        tablaInventario.setItems(inventario);
        tablaInventario.refresh();
    }

    /**
     * Recolecta los datos del formulario, valida si la venta es CF o no y a
     * partir de ello manda a registrar la venta con el metodo
     * registrarVentaConNit dentro de VentaService.
     */
    @FXML
    private void pagar() {
        String confirmacion = "Parámetros numéricos con formato incorrecto.";
        try {
            //obtenemos la lista del carrito
            ObservableList<ProductoDTO> carrito = tablaCarrito.getItems();
            //obtenemos la fecha de la compra
            LocalDate fecha = txtFecha.getValue();
            //obtener el total de la compra
            double total = Double.parseDouble(txtTotal.getText());
            //verificar que tipo de venta es CF o con cliente

            if (estadoCf) {
                //mandamos a hacer una compra cf
                Venta venta = new Venta("", LoginController.empleadoLogeado.getSucursal(),
                        LoginController.empleadoLogeado.getIdEmpleado(), total, 0, total, fecha);
                confirmacion = ventaService.registrarVentaSinNit(venta, carrito);
            } else {
                //obtenemos los datos del cliente
                long nit = Long.parseLong(txtNit.getText());
                String nombre = txtNombre.getText();
                int telefono = Integer.parseInt(txtTelefono.getText());
                //creamos un cliente a partir de esos datos
                Cliente cliente = new Cliente(nit, nombre, telefono);
                //creamos una venta con los datos 
                Venta venta = new Venta("", LoginController.empleadoLogeado.getSucursal(),
                        LoginController.empleadoLogeado.getIdEmpleado(), total, 0, total, fecha);
                //mandamos ha hacer la venta
                confirmacion = ventaService.registrarVentaConNit(cliente, venta, carrito);
            }

            new Alert(Alert.AlertType.INFORMATION, confirmacion).show();
            borrarTodosLosCampos();
            vaciarCarrito();
            mostrarInventarioDeLaSucursal();

        } catch (NumberFormatException ex) {
            new Alert(Alert.AlertType.ERROR, "Parámetros numéricos con formato incorrecto.").show();
        } catch (Exception ex) {
            new Alert(Alert.AlertType.ERROR, ex.getMessage()).show();
        }
    }

    /**
     * Cambia el UI en funcion de la bandera CF
     *
     * @param event
     */
    @FXML
    private void cambiarEstadoCF(ActionEvent event) {
        //hacemos el cambio
        this.estadoCf = !this.estadoCf;
        //si el cf esta activado entonces bloqueamos todos los txt
        if (this.estadoCf) {
            //dejamos los txt desactivados
            this.txtNit.setEditable(false);
            bloquearYBorrarDatosDelCliente();
            //borramos los campos
            this.txtNit.setText("");
            this.txtNombre.setText("");
            this.txtTelefono.setText("");
            //escondemos las labels
            this.labelNit.setVisible(false);
            this.labelNombre.setVisible(false);
            this.labelTelefono.setVisible(false);
        } else {
            this.txtNit.setEditable(true);
            habilitarDatosDelCliente();
            //mostramos las labels
            this.labelNit.setVisible(true);
            this.labelNombre.setVisible(true);
            this.labelTelefono.setVisible(true);
        }
    }

    /**
     * Invoca el servicio encargado de mandar a buscar un cliente por el nit.
     * Esto sucedera cada vez que el usuario cambia el texto del txtNit.
     *
     * @param event
     */
    @FXML
    private void buscarCliente(KeyEvent event) {
        if (!estadoCf) {
            try {
                if (!txtNit.getText().trim().isBlank()) {
                    //traermos el nit de la entrada
                    long nit = Long.parseLong(txtNit.getText().trim());
                    Cliente cliente = new Cliente(nit);
                    //mandamos a buscar al empleado
                    Cliente clienteEncontrado = clienteService.buscarClientePorNit(cliente);
                    //si el resultado no es nulo entonces mostramos sus parametros
                    if (clienteEncontrado != null) {
                        bloquearYBorrarDatosDelCliente();
                        //cargamos los datos del cliente en los campos bloqueados
                        txtNombre.setText(clienteEncontrado.getNombre());
                        txtTelefono.setText(String.valueOf(clienteEncontrado.getTelefono()));
                    } else {
                        habilitarDatosDelCliente();
                        //borramos los campos
                        this.txtNombre.setText("");
                        this.txtTelefono.setText("");
                    }
                }
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "NIT con formato incorrecto.");
                alert.show();
            }
        }
    }

    /**
     * Bloquea los Textfields de la informacion del cliente, luego los borra.
     */
    private void bloquearYBorrarDatosDelCliente() {
        //dejamos los txt desactivados
        this.txtNombre.setEditable(false);
        this.txtTelefono.setEditable(false);
        //borramos los campos
        this.txtNombre.setText("");
        this.txtTelefono.setText("");
    }

    /**
     * Habilita los Textfields de la informacion del cliente.
     */
    private void habilitarDatosDelCliente() {
        this.txtNombre.setEditable(true);
        this.txtTelefono.setEditable(true);
    }

    /**
     * Agrega el modelo de las tablas, asi como los botones de accion
     */
    private void darModeloALasTablas() {

        //le estamos dando modelos a la tabla de Inventario
        codugoBarrasColumn.setCellValueFactory(new PropertyValueFactory("codigoBarras"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory("nombre"));
        precioColumns.setCellValueFactory(new PropertyValueFactory("precioVenta"));

        //esto se utiliza para darle botones a la celda de acciones, ademas de darles accion a los mismos
        Callback<TableColumn<ProductoDTO, String>, TableCell<ProductoDTO, String>> cellFoctory = (TableColumn<ProductoDTO, String> param) -> {
            // make cell containing buttons
            final TableCell<ProductoDTO, String> cell = new TableCell<ProductoDTO, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {

                        ImageView botonMas = new ImageView(new Image("/img/agregar.png"));
                        //damos el tipo de cursor al icono
                        botonMas.setCursor(Cursor.HAND);
                        //le damos un evento de click al boton de agregar
                        botonMas.setOnMouseClicked((MouseEvent event) -> {
                            eliminarDelInventario();
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

        //le estamos dando modelos a la tabla de Carrito
        carritoCodigoColumn.setCellValueFactory(new PropertyValueFactory("codigoBarras"));
        carritoNombreColumn.setCellValueFactory(new PropertyValueFactory("nombre"));
        carritoPrecioColumn.setCellValueFactory(new PropertyValueFactory("precioVenta"));

        Callback<TableColumn<ProductoDTO, String>, TableCell<ProductoDTO, String>> cellFoctory2 = (TableColumn<ProductoDTO, String> param) -> {
            // make cell containing buttons
            final TableCell<ProductoDTO, String> cell = new TableCell<ProductoDTO, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        ImageView btnMenos = new ImageView(new Image("/img/menos.png"));
                        //damos el tipo de cursor al icnono
                        btnMenos.setCursor(Cursor.HAND);
                        //le damos un evento de click al botom menos
                        btnMenos.setOnMouseClicked((MouseEvent event) -> {
                            eliminarDelCarrito();
                        });
                        HBox managebtn = new HBox(btnMenos);
                        managebtn.setStyle("-fx-alignment:center");
                        managebtn.setSpacing(10);
                        HBox.setMargin(btnMenos, new Insets(2, 2, 0, 3));
                        setGraphic(managebtn);
                        setText(null);
                    }
                }
            };
            return cell;
        };
        carriotAccionesColumn.setCellFactory(cellFoctory2);
    }

    /**
     * elimina un producto del carrito y lo devuleve a la tabla de inventario.
     */
    private void eliminarDelCarrito() {
        //traer el producto seleccionado
        ProductoDTO productoDTO = tablaCarrito.getSelectionModel().getSelectedItem();
        //traemos los items del carrito
        ObservableList<ProductoDTO> carrito = tablaCarrito.getItems();
        //borramos el producto del carrito
        carrito.remove(productoDTO);
        tablaCarrito.setItems(carrito);//agregamos los elementos ya con la eliminacion
        tablaCarrito.refresh();
        //ahora hacemos el pase a la otra tabla
        ObservableList<ProductoDTO> inventario = tablaInventario.getItems();//traemos los items del inventario
        //anadimos el producto eleiminado del carrito a la lista del inventario
        inventario.add(productoDTO);
        //agregamos los elementos con la incercion a la tabla de inventario
        tablaInventario.setItems(inventario);
        //refrescamos la tabla
        tablaInventario.refresh();
        //por ultimos mandamos a regrescar el total y el numero de items apagar
        calcularTotalYNumeroDeItems();
    }

    /**
     * Elimina un producto del inventario y lo devuleve a la tabla del carrito.
     */
    private void eliminarDelInventario() {
        //traer el producto seleccionado en la tabla de inventario
        ProductoDTO productoDTO = tablaInventario.getSelectionModel().getSelectedItem();
        //traemos los items del inventario
        ObservableList<ProductoDTO> inventario = tablaInventario.getItems();
        //borramos el producto del inventario
        inventario.remove(productoDTO);
        //agregamos los elementos ya con la eliminacion
        tablaInventario.setItems(inventario);
        //refrescamos la tabla
        tablaInventario.refresh();
        //ahora hacemos el pase a la otra tabla
        ObservableList<ProductoDTO> carrito = tablaCarrito.getItems();//traemos los items del carrito
        //anadimos a la lista del carrito el producto eleiminado del inventario 
        carrito.add(productoDTO);
        //agregamos los elementos con la incercion a la tabla del carrito
        tablaCarrito.setItems(carrito);
        //refrescamos la tabla
        tablaCarrito.refresh();
        calcularTotalYNumeroDeItems();

    }

    /**
     * Obtiene el total de la compra iterando en la tabla, ademas obtiene el
     * numero de registros enla tabla con el metodo size().
     */
    private void calcularTotalYNumeroDeItems() {
        //mandamos a traer los items del carrito
        ObservableList<ProductoDTO> carrito = tablaCarrito.getItems();
        //con un forEach recoremos el array y vamos sumando el total
        double total = 0;
        for (ProductoDTO item : carrito) {
            total += item.getPrecioVenta();
        }
        //seteamos los campos con el total y el numero de items 
        txtTotal.setText(String.valueOf(total));
        txtNumItems.setText(String.valueOf(carrito.size()));
    }

    /**
     * Borra todos los campos de formulario y los habilita. El campo Nit sera
     * habilitado si el Switch CF no esta activado.
     */
    private void borrarTodosLosCampos() {
        if (this.estadoCf) {
            this.txtNit.setEditable(false);
            this.txtNombre.setEditable(false);
            this.txtTelefono.setEditable(false);
        } else {
            this.txtNit.setEditable(true);
            this.txtNombre.setEditable(true);
            this.txtTelefono.setEditable(true);

        }
        //borramos los campos
        this.txtNit.setText("");
        this.txtNombre.setText("");
        this.txtTelefono.setText("");
        this.txtFecha.setValue(null);
        this.txtTotal.setText("");
        this.txtNumItems.setText("");
    }

    /**
     * Elimina todos los registros del carrito.
     */
    private void vaciarCarrito() {
        ObservableList<ProductoDTO> carritoVacio = FXCollections.observableArrayList();
        tablaCarrito.setItems(carritoVacio);
        tablaCarrito.refresh();
    }

}
