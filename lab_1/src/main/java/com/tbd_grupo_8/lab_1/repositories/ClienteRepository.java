package com.tbd_grupo_8.lab_1.repositories;

import com.tbd_grupo_8.lab_1.entities.Cliente;

import java.util.List;

public interface ClienteRepository {
    public List<Cliente> getAllClientes();
    public String createCliente(Cliente cliente);
    public Cliente findByUsername(String username);
    public String login(String username,String password);
}
