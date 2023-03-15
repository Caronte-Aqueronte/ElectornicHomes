/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

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
     * @return Correcto: Si el usuario existe en la base de datos. Mensaje de
     * fallo: Si el usuario no se encuentra en la base de datos.
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
}
