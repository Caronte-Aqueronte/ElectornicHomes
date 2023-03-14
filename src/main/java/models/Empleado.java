/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Luis Monterroso
 */
public class Empleado extends Sucursal {

    private int idEmpleado;
    private String nombre;
    private int edad;
    private String sucursal;
    private String usuario;
    private String password;
    private String rol;

    public Empleado(int idEmpleado, String nombre, int edad, String sucursal, String usuario, String password, String rol) {
        super(sucursal);
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.edad = edad;
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }

    /**
     * Contructor para inicializar un EmpleadoDTO
     *
     * @param usuario
     * @param password
     */
    public Empleado(String usuario, String password) {
        super("");
        this.usuario = usuario;
        this.password = password;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
