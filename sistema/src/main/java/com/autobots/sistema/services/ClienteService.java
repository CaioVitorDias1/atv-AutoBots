package com.autobots.sistema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.autobots.sistema.entities.Cliente;
import com.autobots.sistema.models.SelecionarCliente;
import com.autobots.sistema.repositories.ClienteRepository;

@Service
public class ClienteService {
    


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private SelecionarCliente selecionarCliente;


    public void cadastrarCliente (@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
    }
}
