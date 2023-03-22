/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import javafx.collections.ObservableList;
import models.Empleado;
import repostitories.EmpleadoRepository;

/**
 *
 * @author Luis Monterroso
 */
public class EmpleadoService {

    private EmpleadoRepository empleadoRepository;

    public EmpleadoService() {
        this.empleadoRepository = new EmpleadoRepository();
    }

    /**
     * Valida los campos, intancia el metodo de autenticacion y regresa una
     * respuesta.
     *
     * @param empleadoDTO
     * @return Retorna el objeto encontrado en la base de datos
     * @throws java.lang.Exception si la busqueda fallo o las credenciales son
     * invalidas.
     */
    public Empleado login(Empleado empleadoDTO) throws Exception {
        //si los parametros no estan en blanco instanciamos el metodo autenticador del repositorio
        if (empleadoDTO.getUsuario().isBlank() || empleadoDTO.getPassword().isBlank()) {
            throw new Exception("Credenciales invalidas o vacías.");
        }
        //si al buscar el usuario devuelve null, las credenciales son incorrectas o el usuairo no existe.
        Empleado empleado = empleadoRepository.traerEmpleadoPorUsuarioYPassword(empleadoDTO);
        if (empleado == null) {
            throw new Exception("Credenciales incorrectas.");
        }
        return empleado;
    }

    /**
     * Hace las verificaciones de la informacion, utiliza insertarEmpleado() de
     * EmpleadoRepository para crear un nuevo empleado en la base de datos y
     * retorna una respuesta.
     *
     * @param empleado
     * @return
     * @throws Exception
     */
    public String crearEmpleado(Empleado empleado) throws Exception {
        if (empleado.getNombre().isBlank() || empleado.getEdad() <= 0 || empleado.getSucursal().isBlank()
                || empleado.getUsuario().isBlank() || empleado.getPassword().isBlank() || empleado.getRol().isBlank()) {
            throw new Exception("Parámetros vacíos o inválidos.");
        }
        if (!empleadoRepository.insertarEmpleado(empleado)) {
            throw new Exception("No se guardó el empleado.");
        }
        return "Se guardó el empleado con exito.";
    }

    /**
     * Utiliza traerEmpleados() de EmpleadoRepository para traer todos los
     * empleados de la base de datos.
     *
     * @return
     */
    public ObservableList<Empleado> mostrarEmpleados() {
        return empleadoRepository.traerEmpleados();
    }

    /**
     * Utiliza buscarEmpleadoPorNombre() de EmpleadoRepository para traer todos
     * los empleados que coincidan con la entrada.
     *
     * @param nombre
     * @return
     */
    public ObservableList<Empleado> buscarEmpleadoPorNombre(String nombre) {
        return empleadoRepository.buscarEmpleadoPorNombre(nombre);
    }
}
