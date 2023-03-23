/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import dto.ClientesMasGananciaDTO;
import dto.EmpleadoMasIngresoDTO;
import dto.EmpleadoMasVentasDTO;
import dto.ProductoMasIngresoDTO;
import dto.ProductoMasIngresoPorSucursalDTO;
import dto.ProductoMasVendidoDTO;
import dto.ProductoMasVendidoPorSucursalDTO;
import dto.SucursalMasIngresoDTO;
import dto.SucursalMasVentasDTO;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXFilterComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.ReporteService;

/**
 * FXML Controller class
 *
 * @author Luis Monterroso
 */
public class ReportesController implements Initializable {

    private ReporteService reporteService;
    @FXML
    private MFXFilterComboBox<String> comboReporte;
    @FXML
    private TableView tablaReportes;
    @FXML
    private MFXComboBox<String> comboReporteD;
    @FXML
    private TableView tablaReporteDinamico;
    @FXML
    private MFXComboBox<String> comboSucursal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.reporteService = new ReporteService();
        llenarCombo();
    }

    /**
     * Se detecta el cambio dentro del combobox para mandar a traer el reporte
     * elegido.
     *
     * @param event
     */
    @FXML
    private void cambioReporte(ActionEvent event) {
        //traemos el index del reporte elegido tomando en cuenta que empieza desde el 0
        int index = comboReporte.getSelectedIndex();
        switch (index) {
            case 0://10 productos más vendidos
                ObservableList<ProductoMasVendidoDTO> productosMasVendidos = reporteService.productoMasVendido();
                cargar10ProductosMasVendidos(productosMasVendidos);
                break;
            case 1://10 de clientes que más ganancias generan
                ObservableList<ClientesMasGananciaDTO> clientes = reporteService.diezClientesMasIngreso();
                cargar10ClientesQueMasGananciaGeneran(clientes);
                break;
            case 2://3 sucursales con más ventas
                ObservableList<SucursalMasVentasDTO> sucursales = reporteService.sucursalesMasVentas();
                cargar3SucursalesConMasVentas(sucursales);
                break;
            case 3://3 sucursales con más ingresos
                ObservableList<SucursalMasIngresoDTO> sucursales2 = reporteService.sucursalesMasIngresos();
                cargar3SucursalesConMasIngreso(sucursales2);
                break;
            case 4://3 empleados con más ventas
                ObservableList<EmpleadoMasVentasDTO> empleados = reporteService.empleadosMasVentas();
                cargar3EmpleadosConMasVentas(empleados);
                break;
            case 5://3 empleados con más ingresos
                ObservableList<EmpleadoMasIngresoDTO> empleados2 = reporteService.empleadosMasIngresos();
                cargar3EmpleadosConMasIngreso(empleados2);
                break;
            case 6://10 productos con más ingresos
                ObservableList<ProductoMasIngresoDTO> productos2 = reporteService.productoMasIngresos();
                cargar10ProductosMasGanancia(productos2);
                break;
            default:
                throw new AssertionError();
        }
    }

    @FXML
    private void cambioReporteDinamico(ActionEvent event) {
        //traemos el index del reporte elegido tomando en cuenta que empieza desde el 0
        int index = comboReporteD.getSelectedIndex();
        String sucursal = comboSucursal.getSelectedItem();

        switch (index) {
            case 0://Top 5 productos más vendidos por sucursal
                ObservableList<ProductoMasVendidoPorSucursalDTO> productosMasVendidos = reporteService.productoMasVentasPorSucursal(sucursal);
                cargarTop5ProductosMasVendidosPorSucursal(productosMasVendidos);
                break;
            case 1://Top 5 productos con más ingresos por sucursal
                ObservableList<ProductoMasIngresoPorSucursalDTO> productosMasIngresos = reporteService.productoMasIngresoPorSucursal(sucursal);
                cargarTop5ProductosMasIngresoPorSucursal(productosMasIngresos);
                break;
        }
    }

    private void llenarCombo() {

        //items de los reportes estaticos
        ObservableList<String> reportesEstaticos = FXCollections.observableArrayList();
        //anadimos todos los strings correspondientes a los distintos reportes
        reportesEstaticos.addAll("10 productos más vendidos", "10 de clientes que más ganancias generan",
                "3 sucursales con más ventas", "3 sucursales con más ingresos",
                "3 empleados con más ventas", "3 empleados con más ingresos",
                "10 productos con más ingresos");
        //adjuntamos los strings al combo
        this.comboReporte.setItems(reportesEstaticos);

        //ahora creamos los items de los reportes dinamicos
        ObservableList<String> reportesDinamicos = FXCollections.observableArrayList();
        //anadimos todos los strings correspondientes a los distintos reportes
        reportesDinamicos.addAll("Top 5 productos más vendidos por sucursal",
                "Top 5 productos con más ingresos por sucursal");
        this.comboReporteD.setItems(reportesDinamicos);

        //ahora anadimos las sucursales al combo de sucursales
        ObservableList<String> sucursales = FXCollections.observableArrayList();
        sucursales.addAll("Sucursal Central", "Sucursal Norte", "Sucursal Sur");
        //anadimos los items al combo de sucursales
        this.comboSucursal.setItems(sucursales);
        this.comboSucursal.getSelectionModel().selectFirst();

    }

    private void cargar10ProductosMasVendidos(ObservableList<ProductoMasVendidoDTO> productosMasVendidos) {
        //borramos las columnas de la tabla
        tablaReportes.getColumns().clear();
        //creamos las columnas para el reporte y les damos un modelo
        TableColumn nombreProducto = new TableColumn("Nombre del producto");
        nombreProducto.setCellValueFactory(new PropertyValueFactory("nombreProducto"));

        TableColumn numVentas = new TableColumn("Numero de ventas");
        numVentas.setCellValueFactory(new PropertyValueFactory("numeroVentas"));

        //agregasmos las columnas a la tabla
        tablaReportes.getColumns().addAll(nombreProducto, numVentas);
        //le seteamos los items a la tabla
        tablaReportes.setItems(productosMasVendidos);
        tablaReportes.refresh();
    }

    private void cargar10ProductosMasGanancia(ObservableList<ProductoMasIngresoDTO> productosMasVendidos) {
        //borramos las columnas de la tabla
        tablaReportes.getColumns().clear();
        //creamos las columnas para el reporte y les damos un modelo
        TableColumn nombreProducto = new TableColumn("Nombre del producto");
        nombreProducto.setCellValueFactory(new PropertyValueFactory("nombreProducto"));

        TableColumn numVentas = new TableColumn("Total de ingresos por ventas");
        numVentas.setCellValueFactory(new PropertyValueFactory("totalIngresos"));

        //agregasmos las columnas a la tabla
        tablaReportes.getColumns().addAll(nombreProducto, numVentas);
        //le seteamos los items a la tabla
        tablaReportes.setItems(productosMasVendidos);
        tablaReportes.refresh();
    }

    private void cargar10ClientesQueMasGananciaGeneran(ObservableList<ClientesMasGananciaDTO> clientes) {
        //borramos las columnas de la tabla
        tablaReportes.getColumns().clear();
        //creamos las columnas para el reporte y les damos un modelo
        TableColumn nit = new TableColumn("NIT");
        nit.setCellValueFactory(new PropertyValueFactory("nit"));

        TableColumn nombreCliente = new TableColumn("Nombre del cliente");
        nombreCliente.setCellValueFactory(new PropertyValueFactory("nombre"));

        TableColumn totalVentas = new TableColumn("Total de ingresos del cliente");
        totalVentas.setCellValueFactory(new PropertyValueFactory("totalGastado"));
        //agregasmos las columnas a la tabla
        tablaReportes.getColumns().addAll(nit, nombreCliente, totalVentas);
        //le seteamos los items a la tabla
        tablaReportes.setItems(clientes);
        tablaReportes.refresh();
    }

    private void cargar3SucursalesConMasVentas(ObservableList<SucursalMasVentasDTO> sucursales) {
        //borramos las columnas de la tabla
        tablaReportes.getColumns().clear();
        //creamos las columnas para el reporte y les damos un modelo
        TableColumn sucursal = new TableColumn("Sucursal");
        sucursal.setCellValueFactory(new PropertyValueFactory("sucursal"));

        TableColumn numVentas = new TableColumn("Numero de ventas");
        numVentas.setCellValueFactory(new PropertyValueFactory("numVentas"));
        //agregasmos las columnas a la tabla
        tablaReportes.getColumns().addAll(sucursal, numVentas);
        //le seteamos los items a la tabla
        tablaReportes.setItems(sucursales);
        tablaReportes.refresh();
    }

    private void cargar3SucursalesConMasIngreso(ObservableList<SucursalMasIngresoDTO> sucursales) {
        //borramos las columnas de la tabla
        tablaReportes.getColumns().clear();
        //creamos las columnas para el reporte y les damos un modelo
        TableColumn sucursal = new TableColumn("Sucursal");
        sucursal.setCellValueFactory(new PropertyValueFactory("sucursal"));

        TableColumn numVentas = new TableColumn("Ingresos de ventas");
        numVentas.setCellValueFactory(new PropertyValueFactory("totalVentas"));
        //agregasmos las columnas a la tabla
        tablaReportes.getColumns().addAll(sucursal, numVentas);
        //le seteamos los items a la tabla
        tablaReportes.setItems(sucursales);
        tablaReportes.refresh();
    }

    private void cargar3EmpleadosConMasVentas(ObservableList<EmpleadoMasVentasDTO> empleados) {
        //borramos las columnas de la tabla
        tablaReportes.getColumns().clear();
        //creamos las columnas para el reporte y les damos un modelo
        TableColumn nombreEmpleado = new TableColumn("Nombre del empleado");
        nombreEmpleado.setCellValueFactory(new PropertyValueFactory("nombre"));

        TableColumn sucursal = new TableColumn("Sucursal en donde trabaja");
        sucursal.setCellValueFactory(new PropertyValueFactory("sucursal"));

        TableColumn numVentas = new TableColumn("Numero de ventas");
        numVentas.setCellValueFactory(new PropertyValueFactory("numVentas"));

        //agregasmos las columnas a la tabla
        tablaReportes.getColumns().addAll(nombreEmpleado, sucursal, numVentas);
        //le seteamos los items a la tabla
        tablaReportes.setItems(empleados);
        tablaReportes.refresh();
    }

    private void cargar3EmpleadosConMasIngreso(ObservableList<EmpleadoMasIngresoDTO> empleados) {
        //borramos las columnas de la tabla
        tablaReportes.getColumns().clear();
        //creamos las columnas para el reporte y les damos un modelo
        TableColumn nombreEmpleado = new TableColumn("Nombre del empleado");
        nombreEmpleado.setCellValueFactory(new PropertyValueFactory("nombre"));

        TableColumn sucursal = new TableColumn("Sucursal en donde trabaja");
        sucursal.setCellValueFactory(new PropertyValueFactory("sucursal"));

        TableColumn numVentas = new TableColumn("Ingresos por ventas");
        numVentas.setCellValueFactory(new PropertyValueFactory("totalIngresos"));

        //agregasmos las columnas a la tabla
        tablaReportes.getColumns().addAll(nombreEmpleado, sucursal, numVentas);
        //le seteamos los items a la tabla
        tablaReportes.setItems(empleados);
        tablaReportes.refresh();
    }

    private void cargarTop5ProductosMasVendidosPorSucursal(ObservableList<ProductoMasVendidoPorSucursalDTO> productos) {
        //borramos las columnas de la tabla
        tablaReporteDinamico.getColumns().clear();
        //creamos las columnas para el reporte y les damos un modelo
        TableColumn sucursal = new TableColumn("Sucursal");
        sucursal.setCellValueFactory(new PropertyValueFactory("sucursal"));

        TableColumn nombreProducto = new TableColumn("Producto");
        nombreProducto.setCellValueFactory(new PropertyValueFactory("nombreProducto"));

        TableColumn numeroVentas = new TableColumn("Numero de ventas");
        numeroVentas.setCellValueFactory(new PropertyValueFactory("numeroVentas"));

        //agregasmos las columnas a la tabla
        tablaReporteDinamico.getColumns().addAll(sucursal, nombreProducto, numeroVentas);
        //le seteamos los items a la tabla
        tablaReporteDinamico.setItems(productos);
        tablaReporteDinamico.refresh();
    }

    private void cargarTop5ProductosMasIngresoPorSucursal(ObservableList<ProductoMasIngresoPorSucursalDTO> productos) {
        //borramos las columnas de la tabla
        tablaReporteDinamico.getColumns().clear();
        //creamos las columnas para el reporte y les damos un modelo
        TableColumn sucursal = new TableColumn("Sucursal");
        sucursal.setCellValueFactory(new PropertyValueFactory("sucursal"));

        TableColumn nombreProducto = new TableColumn("Producto");
        nombreProducto.setCellValueFactory(new PropertyValueFactory("nombreProducto"));

        TableColumn numeroVentas = new TableColumn("Ingresos por ventas");
        numeroVentas.setCellValueFactory(new PropertyValueFactory("totalVentas"));

        //agregasmos las columnas a la tabla
        tablaReporteDinamico.getColumns().addAll(sucursal, nombreProducto, numeroVentas);
        //le seteamos los items a la tabla
        tablaReporteDinamico.setItems(productos);
        tablaReporteDinamico.refresh();
    }

}
