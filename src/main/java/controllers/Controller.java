/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import io.github.palexdev.materialfx.controls.MFXScrollPane;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Luis Monterroso
 */
public abstract class Controller {

    /**
     * Coloca una vita adentro de un ScrollPane
     *
     * @param contenedor
     * @param view
     * @param elemento
     */
    protected void abrirMenuEnScrollPane(MFXScrollPane contenedor, String view, Node elemento) {
        try {
            //obtener los datos del usuario
            Stage stage = (Stage) elemento.getScene().getWindow();//obtenemos el stage

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/" + view + ".fxml"));//cargador de las escenas
            Parent parent = loader.load();//cargamos la escena
            contenedor.setContent(parent);//adjuntamos la escena al panel
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Abre el menu que recibe como parametro.
     *
     * @param menu
     * @param info
     */
    protected void abrirMenu(String view, Node elemento) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/" + view + ".fxml"));//cargamos el menu
            Parent parent = loader.load();//crear un pareinte
            Scene scene = new Scene(parent);//creamos la vista con el pareitne
            Stage stage = new Stage();//cremos la ventana
            stage.setScene(scene);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/aparato-electrico.png")));//le damos un icono a la ventana
            stage.show();//ensenamos la ventana
            stage.setMaximized(true);//la maximizamos
            //codigo para cerrar la ventana actual
            Stage stageActual = (Stage) elemento.getScene().getWindow();//obtenemos la ventana actual
            stageActual.close();//cerramos la ventana actual
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
