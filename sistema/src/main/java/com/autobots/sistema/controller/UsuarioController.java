package com.autobots.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.repositories.UsuarioRepository;

@RestController
@RequestMapping("/login")
public class UsuarioController {
    
    private AuthenticationManager authenticationManager;

    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/")
    public Usuario login(@RequestBody Usuario usuario){
       String password = passwordEncoder.encode(usuario.getSenha());
        Usuario user = usuario;
        user.setSenha(password);
        usuarioRepository.save(usuario);
        return usuario;
    } 
}
