package com.api.contact.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.contact.entities.Mercadoria;
import com.api.contact.entities.Servico;
import com.api.contact.entities.Usuario;
import com.api.contact.entities.Veiculo;

@RestController
public class JoinSistema {
    
    @GetMapping
    public List<Usuario> listagemClientes(){
        List<Usuario> usuarios = new ArrayList<>();
        ResponseEntity<? extends List> resposta = new RestTemplate()
        .getForEntity("http://localhost:8080/join/usuarios", usuarios.getClass());
        usuarios = resposta.getBody();
        return usuarios;
    }

    @GetMapping
    public List<Mercadoria> listagemMercadoria(){
        List<Mercadoria> mercadorias = new ArrayList<>();
        ResponseEntity<? extends List> resposta = new RestTemplate()
        .getForEntity("http://localhost:8080/join/mercadorias", mercadorias.getClass());
        mercadorias = resposta.getBody();
        return mercadorias;
    }

    @GetMapping 
    public List<Servico> listagemServicos(){
        List<Servico> servicos = new ArrayList<>();
        ResponseEntity<? extends List> resposta = new RestTemplate()
        .getForEntity("http://localhost:8080/join/servicos ", servicos.getClass());
        servicos = resposta.getBody();
        return servicos;
    }

    @GetMapping
    public List<Veiculo> listagemVeiculos(){
        List<Veiculo> veiculos = new ArrayList<>();
        ResponseEntity<? extends List> resposta = new RestTemplate()
        .getForEntity("http://localhost:8080/join/veiculos", veiculos.getClass());
        veiculos = resposta.getBody();
        return veiculos;
    }
}
