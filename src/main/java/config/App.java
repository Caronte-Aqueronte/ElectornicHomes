package config;

import config.Conector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    /**
     * Incia la pantalla inicial
     *
     * @param primaryStage
     * @throws IOException
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/views/Login.fxml"));
            Pane ventana = (Pane) loader.load();//se crea la ventana en donde se cargara la primera vista
            Scene scene = new Scene(ventana);//se carga la ventana en la escena
            primaryStage.setScene(scene);
            //se carga el icono de la ventana
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/aparato-electrico.png")));
            primaryStage.show();//mostramos la ventana
            primaryStage.setResizable(false);//establecemos que no se pueda cambiar el tamanio de la ventana
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Acciona el metodo start
     * @param args 
     */
    public static void main(String[] args) {
        //Intentamos establecer conexion con la base de datos
        Conector conector = new Conector();
        if(!conector.conectar()){
            //lanzamos un error de coneccion
            JOptionPane.showMessageDialog(null, "No se pudo establecer la conexión con la base de datos.");   
            System.exit(0);
        }
        launch(); 
    }

}
