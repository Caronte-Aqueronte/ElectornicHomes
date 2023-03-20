/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import dto.BodegaDTO;
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
import models.Compra;
import services.BodegaDTOService;
import services.CompraService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class BodegaController extends Controller implements Initializable {

    private BodegaDTOService bodegaService;
    private CompraService compraService;
    @FXML
    private TableView<BodegaDTO> tablaBodega;
    @FXML
    private TableColumn colCodigoB;
    @FXML
    private TableColumn colNombreB;
    @FXML
    private TableColumn colAccionesB;
    @FXML
    private MFXTextField txtBuscarBodega;
    @FXML
    private ImageView btnAgregar;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.bodegaService = new BodegaDTOService();
        this.compraService = new CompraService();
        //damos modelo a la tabla
        darModeloATabla();
        //mostramos la bodega
        mostrarBodega();
    }

    /**
     * Captura el tecleo dentro del txtBuscarBodega, captura la entrada y manda
     * a buscar el producto en la bodega.
     *
     * @param event
     */
    @FXML
    private void buscarEnBodega(KeyEvent event) {
        String busqueda = txtBuscarBodega.getText();//caturamos la entrada
        //mandamos a buscar el codigo de barras
        ObservableList<BodegaDTO> bodegaBusqueda = this.bodegaService.buscarEnBodegaPorCodigoBarras(busqueda);
        this.tablaBodega.setItems(bodegaBusqueda);
        this.tablaBodega.refresh();
    }

    /**
     * Utiliza abrirDialog para abrir InsertarBodega.fxml
     *
     * @param event
     */
    @FXML
    private void abrirMenuInsertar(MouseEvent event) {
        this.abrirDialog("InsertarBodega", "Insertar producto en bodega");
        mostrarBodega();
    }

    /**
     * Obtiene el objeto seleccionado en la tabla, crea un controlador, setea la
     * compra del controlador y adjunta un controlador a la vista.
     */
    private void abrirEditarBodegaDialog() {

        try {
            //obtener el objeto seleccionado en la tabla
            BodegaDTO bodegaDTO = tablaBodega.getSelectionModel().getSelectedItem();
            //mandamos a buscar la compra con el codigo de barras de la bodega
            Compra compra = this.compraService.buscarCompraPorCodigo(bodegaDTO.getCodigoBarras());
            //crear el controlador de la vista
            EditarBodegaController controller = new EditarBodegaController();
            controller.setCompra(compra);//adjuntamos la compra
            //mandamos a abrir la vista 
            this.abrirDialogConControlador(controller, "Editar producto en bodega", "EditarBodega");
            mostrarBodega();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
        }

    }

    /**
     * Utiliza mostrarBodega de BodegaDTOService para mostrar los productos en
     * bodega.
     */
    private void mostrarBodega() {
        ObservableList<BodegaDTO> bodega = this.bodegaService.mostrarBodega();
        this.tablaBodega.setItems(bodega);
        this.tablaBodega.refresh();
    }

    /**
     * Da un modelo a la tabla de Bodega y le agrega el boton de editar
     */
    private void darModeloATabla() {
        //le estamos dando modelos a la tabla de Bodega
        colCodigoB.setCellValueFactory(new PropertyValueFactory("codigoBarras"));
        colNombreB.setCellValueFactory(new PropertyValueFactory("nombre"));

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

                        ImageView botonEditar = new ImageView(new Image("/img/edit.png"));
                        //damos el tipo de cursor al icono
                        botonEditar.setCursor(Cursor.HAND);
                        //le damos un evento de click al boton de agregar
                        botonEditar.setOnMouseClicked((MouseEvent event) -> {
                            abrirEditarBodegaDialog();
                        });
                        HBox managebtn = new HBox(botonEditar);
                        managebtn.setStyle("-fx-alignment:center");
                        managebtn.setSpacing(10);
                        HBox.setMargin(botonEditar, new Insets(2, 2, 0, 3));
                        setGraphic(managebtn);
                        setText(null);
                    }
                }

            };
            return cell;
        };
        colAccionesB.setCellFactory(cellFoctory);//anadimos los botones a la celda de acciones
    }

}
