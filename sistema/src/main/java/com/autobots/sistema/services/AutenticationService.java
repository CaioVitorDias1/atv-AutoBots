package com.autobots.sistema.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.models.AutenticationRequest;
import com.autobots.sistema.models.AutenticationResponse;
import com.autobots.sistema.models.RegisterRequest;
import com.autobots.sistema.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutenticationService{

    private final UsuarioRepository usuarioRepositorio;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtServico;

    private final AuthenticationManager authenticationManager;


    public AutenticationResponse register(RegisterRequest request){
        var usuario = Usuario.builder()
            .userEmail(request.getEmail())
            .senha(passwordEncoder.encode(request.getSenha()))
            .cargo(request.getCargo())
            .build();
            usuarioRepositorio.save(usuario);

        var jwtToken = jwtServico.generateToken(usuario);
        return AutenticationResponse.builder()
        .token(jwtToken)
        .build();
    }

    public AutenticationResponse authenticate(AutenticationRequest request){
        authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()) 
        );

        var usuario = usuarioRepositorio.findByUserEmail(request.getEmail()).orElseThrow();
        String userRole = usuario.getCargo();
        var jwtToken = jwtServico.generateToken(usuario);
        return AutenticationResponse.builder()
        .token(jwtToken)
        .role(userRole)
        .build();
    }
    
}
