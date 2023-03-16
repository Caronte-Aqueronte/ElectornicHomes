/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import dto.BodegaDTO;
import dto.ProductoDTO;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
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
import models.Empleado;
import services.BodegaDTOService;
import services.ProductoDTOService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class PedidosController implements Initializable {

    private Empleado empleadoLogeado;
    private ProductoDTOService productoDtoService;
    private BodegaDTOService bodegaService;
    @FXML
    private TableColumn colCodigoB;
    @FXML
    private TableColumn colNombreB;
    @FXML
    private TableColumn colPrecioB;
    @FXML
    private TableColumn colAccionesB;
    @FXML
    private MFXTextField txtBuscarBodega;
    @FXML
    private TableColumn colCodigoOS;
    @FXML
    private TableColumn colNombreOS;
    @FXML
    private TableColumn colPrecioOS;
    @FXML
    private TableColumn colAccionesOS;
    @FXML
    private MFXTextField txtBuscarSucursal;
    @FXML
    private TableView<BodegaDTO> tablaBodega;
    @FXML
    private TableView<ProductoDTO> tablaSucursales;
    @FXML
    private TableColumn colSucursalOS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productoDtoService = new ProductoDTOService();
        bodegaService = new BodegaDTOService();
        this.empleadoLogeado = LoginController.empleadoLogeado;
        darModeloATablas();
        mostrarInventarios();
        mostrarBodega();
    }

    /**
     * Campa los tecleos dentro de txtBuscarSucursal y manda a buscar en la
     * bodega.
     *
     * @param event
     */
    @FXML
    private void buscarEnEnBodega(KeyEvent event) {
        String busqueda = txtBuscarBodega.getText();
        ObservableList<BodegaDTO> bodega = bodegaService.buscarEnBodegaPorCodigoBarras(busqueda);
        tablaBodega.setItems(bodega);
        tablaBodega.refresh();
    }

    /**
     * Campa los tecleos dentro de txtBuscarSucursal y manda a buscar en el
     * inventario de una sucursal.
     *
     * @param event
     */
    @FXML
    private void buscarEnSucursal(KeyEvent event) {
        String busqueda = txtBuscarSucursal.getText();
        ObservableList<ProductoDTO> inventario = productoDtoService.buscarProductoPorCodigoDeBarras(busqueda);
        tablaSucursales.setItems(inventario);
        tablaSucursales.refresh();
    }

    /**
     * Agrega un modelo a las tablas.
     */
    private void darModeloATablas() {
        //le estamos dando modelos a la tabla de Inventario
        colCodigoB.setCellValueFactory(new PropertyValueFactory("codigoBarras"));
        colNombreB.setCellValueFactory(new PropertyValueFactory("nombre"));
        colPrecioB.setCellValueFactory(new PropertyValueFactory("precioVenta"));

        //esto se utiliza para darle botones a la celda de acciones, ademas de darles accion a los mismos
        Callback<TableColumn<BodegaDTO, String>, TableCell<BodegaDTO, String>> cellFoctory = (TableColumn<BodegaDTO, String> param) -> {
            // make cell containing buttons
            final TableCell<BodegaDTO, String> cell = new TableCell<BodegaDTO, String>() {
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
                            hacerPedidoABodega();
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
        colAccionesB.setCellFactory(cellFoctory);//anadimos los botones a la celda de acciones

        //le estamos dando modelos a la tabla de Carrito
        colCodigoOS.setCellValueFactory(new PropertyValueFactory("codigoBarras"));
        colNombreOS.setCellValueFactory(new PropertyValueFactory("nombre"));
        colPrecioOS.setCellValueFactory(new PropertyValueFactory("precioVenta"));
        colSucursalOS.setCellValueFactory(new PropertyValueFactory("sucursal"));

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
                        ImageView btnMenos = new ImageView(new Image("/img/agregar.png"));
                        //damos el tipo de cursor al icnono
                        btnMenos.setCursor(Cursor.HAND);
                        //le damos un evento de click al botom menos
                        btnMenos.setOnMouseClicked((MouseEvent event) -> {
                            hacerPedidoASucursal();
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
        colAccionesOS.setCellFactory(cellFoctory2);
    }

    /**
     * Invoca a mostrarProductosDtoDeSucursales de ProductoDtoService encargado
     * de mostrar todos los productos de los inventarios de las sucursales.
     */
    private void mostrarInventarios() {
        ObservableList<ProductoDTO> inventario = productoDtoService.mostrarProductosDtoDeSucursales();
        tablaSucursales.setItems(inventario);
        tablaSucursales.refresh();
    }

    /**
     * Invoca a mostrarBodega de BodegaDTOService encargado de mostrar todos los
     * productos en la bodega.
     */
    private void mostrarBodega() {
        ObservableList<BodegaDTO> bodega = bodegaService.mostrarBodega();
        tablaBodega.setItems(bodega);
        tablaBodega.refresh();

    }

    /**
     * Invoca a distribuirBodegaASucursal de BodegaDTOService encargado de
     * eliminar el producto de la bodega e insertarlo al inventario.
     */
    private void hacerPedidoABodega() {
        //obtenemos el producto seleccionado
        BodegaDTO bodegaDTO = tablaBodega.getSelectionModel().getSelectedItem();
        //mandamos ha eliminar el producto de la bodega e insertarlo al inventario
        try {
            String confirmacion = this.bodegaService.distribuirBodegaASucursal(bodegaDTO,
                    empleadoLogeado.getSucursal());
            //mostramos la respuesta del metodo
            new Alert(Alert.AlertType.INFORMATION, confirmacion).show();
            //mostramos el nuevo inventario de sucursales
            mostrarBodega();
        } catch (Exception e) {
            //mostramos el error
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }

    }

    /**
     * Invoca a cambiarProductoDeSucursal de ProductoDtoService encargado de
     * cambiar un producto de sucursal.
     */
    private void hacerPedidoASucursal() {
        //obtenemos el producto seleccionado
        ProductoDTO productoDTO = tablaSucursales.getSelectionModel().getSelectedItem();
        //mandamos ha cambiarle la sucursal al producto dentro de la bd
        try {
            String confirmacion = productoDtoService.cambiarProductoDeSucursal(productoDTO, empleadoLogeado.getSucursal());
            //mostramos la respuesta del metodo
            new Alert(Alert.AlertType.INFORMATION, confirmacion).show();
            //mostramos el nuevo inventario de sucursales
            mostrarInventarios();
        } catch (Exception e) {
            //mostramos el error
            new Alert(Alert.AlertType.INFORMATION, e.getMessage()).show();
        }
    }
}
