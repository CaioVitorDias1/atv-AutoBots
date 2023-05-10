package com.autobots.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.sistema.entities.Mercadoria;
import com.autobots.sistema.entities.Servico;
import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.entities.Veiculo;
import com.autobots.sistema.repositories.MercadoriaRepository;
import com.autobots.sistema.repositories.ServicoRepository;
import com.autobots.sistema.repositories.UsuarioRepository;
import com.autobots.sistema.repositories.VeiculoRepository;

@RestController
@RequestMapping("/join")
@CrossOrigin
public class JoinController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private MercadoriaRepository mercadoriaRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping("/usuarios")
    public List<Usuario> listagemUsuario(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/mercadorias")
    public List<Mercadoria> listagemMercadoria(){
        return mercadoriaRepository.findAll();
    }

    @GetMapping("/servicos")
    public List<Servico> listagemServico(){
        return servicoRepository.findAll();
    }
    
    @GetMapping("/veiculos")
    public List<Veiculo> listagemVeiculo(){
        return veiculoRepository.findAll();
    }

}
