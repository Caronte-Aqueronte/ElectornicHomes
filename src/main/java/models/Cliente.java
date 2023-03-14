/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Luis Monterroso
 */
public class Cliente {

    private long nit;
    private String nombre;
    private int telefono;

    public Cliente(long nit, String nombre, int telefono) {
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Cliente(long nit) {
        this.nit = nit;
    }
   
    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
