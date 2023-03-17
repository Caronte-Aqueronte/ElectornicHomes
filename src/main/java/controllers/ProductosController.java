package controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import models.Producto;
import services.ProductoService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class ProductosController extends Controller implements Initializable {

    private ProductoService productoService;

    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colDescripcion;
    @FXML
    private TableColumn colPrecioCompra;
    @FXML
    private TableColumn colPrecioVenta;
    @FXML
    private MFXTextField txtBuscar;
    @FXML
    private ImageView btnAgregar;
    @FXML
    private TableView<Producto> tablaProductos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.productoService = new ProductoService();
        darModeloATabla();
        mostrarProductos();
    }

    /**
     * Invoca a buscarProducto de ProductoService para buscar un producto del
     * catalogo.
     *
     * @param event
     */
    @FXML
    private void buscarProducto(KeyEvent event) {
        String busqueda = txtBuscar.getText();//obtenemos la busqueda
        ObservableList<Producto> productos = this.productoService.buscarProducto(busqueda);
        this.tablaProductos.setItems(productos);
        this.tablaProductos.refresh();
    }

    @FXML
    private void abrirMenuInsertar(MouseEvent event) {
        abrirDialog("CrearProducto", "Crear producto");
        mostrarProductos();
    }

    /**
     * Invoca a mostrarProductos de ProductoService para mostrar todos los
     * productos del catalogo.
     */
    private void mostrarProductos() {
        ObservableList<Producto> productos = this.productoService.mostrarProductos();
        this.tablaProductos.setItems(productos);
        this.tablaProductos.refresh();
    }

    /**
     * Da un atributo de clase a una columna de la tabla.
     */
    private void darModeloATabla() {
        //le estamos dando modelos a la tabla de Productos
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.colPrecioCompra.setCellValueFactory(new PropertyValueFactory("precioCompra"));
        this.colPrecioVenta.setCellValueFactory(new PropertyValueFactory("precioVenta"));
    }

}
