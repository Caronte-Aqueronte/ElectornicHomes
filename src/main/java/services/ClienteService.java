/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

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
     * Invoca el metodo del repositorio que busca a un cliente por su numero de
     * nit
     *
     * @param cliente
     * @return El cliente encontrado.
     */
    public Cliente buscarClientePorNit(Cliente cliente) {
        return clienteRepository.buscarClientePorNit(cliente.getNit());
    }
}
