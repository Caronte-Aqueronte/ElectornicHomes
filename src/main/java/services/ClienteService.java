/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import javafx.collections.ObservableList;
import models.Cliente;
import repostitories.ClienteRepository;

/**
 *
 * @author Luis Monterroso
 */
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }

    /**
     * Invoca buscarClientePorNit de ClienteRepository que busca a un cliente
     * por su numero de nit
     *
     * @param cliente
     * @return El cliente encontrado.
     */
    public Cliente buscarClientePorNit(Cliente cliente) {
        return clienteRepository.buscarClientePorNit(cliente.getNit());
    }

    
    /**
     * Invoca buscarClientesPorNit de ClienteRepository que busca a un cliente
     * por su nombre
     *
     * @param cliente
     * @return El cliente encontrado.
     */
    public ObservableList<Cliente> buscarClientesPorNombre(String cliente) {
        return clienteRepository.buscarClientesPorNombre(cliente);
    }
    
    /**
     * Invoca el metodo mostrarClientes de ClienteRepository que muestra a todos
     * los clientes.
     *
     * @return Lista de clientes
     */
    public ObservableList<Cliente> mostrarClientes() {
        return clienteRepository.mostrarClientes();
    }

    /**
     * Valida la informacion del cliente,invoca el metodo editarCliente de
     * ClienteRepository para editar un cliente.
     *
     * @param cliente
     * @param antiguoNit
     * @return
     */
    public String editarCliente(Cliente cliente, long antiguoNit) throws Exception {
        //validamos que todos los campos esten llenos
        if (cliente.getNit() <= 0 || cliente.getNit() > 9999999) {
            throw new Exception("NIT invalido.\nEl NIT debe ser MENOR O IGUAL a 9999999 o MAYOR a 0.");
        }
        if (cliente.getNombre().isBlank() || cliente.getTelefono() <= 10000000) {
            throw new Exception("Parámetros vacíos o inválidos.");
        }
        //si todo esta bien mandamos a editar el cliente
        if (!clienteRepository.editarCliente(cliente, antiguoNit)) {
            throw new Exception("No se editó el cliente.");
        }
        return "Se editó el cliente con exito.";
    }
}
