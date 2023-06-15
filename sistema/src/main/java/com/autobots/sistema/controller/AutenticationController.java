package com.autobots.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.models.AutenticationRequest;
import com.autobots.sistema.models.AutenticationResponse;
import com.autobots.sistema.models.RegisterRequest;
import com.autobots.sistema.repositories.UsuarioRepository;
import com.autobots.sistema.services.AutenticationService;

import lombok.RequiredArgsConstructor;

// @RestController
// @RequestMapping("/login")
// public class UsuarioController {
    
//     //private AuthenticationManager authenticationManager;

//    // private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//     @Autowired
//     private UsuarioRepository usuarioRepository;

//     //@PreAuthorize("hasAnyRole('VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
//     // @PostMapping("/")
//     // public Usuario login(@RequestBody Usuario usuario){
//     //    String password = passwordEncoder.encode(usuario.getSenha());
//     //     Usuario user = usuario;
//     //     user.setSenha(password);
//     //     usuarioRepository.save(usuario);
//     //     return usuario;
//     // } 

//     @PreAuthorize("hasAnyRole('CLIENTE', 'VENDEDOR', 'GERENTE', 'ADMINISTRADOR')")
//     @GetMapping("/all")
//     public List<Usuario> users(){
//         return usuarioRepository.findAll();
//     }
// }


@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class AutenticationController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    private final AutenticationService autenticacaoServico;

    @PostMapping("/cadastrar")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR')")
    public ResponseEntity<AutenticationResponse> cadastrar(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(autenticacaoServico.register(request));
    }

    @PostMapping("/")
    public ResponseEntity<AutenticationResponse> autenticar(@RequestBody AutenticationRequest request){
        return ResponseEntity.ok(autenticacaoServico.authenticate(request));
    }

    @PreAuthorize("hasAnyAuthority('GERENTE', 'ADMINISTRADOR')")
    @GetMapping("/all")
     public List<Usuario> users(){
         return usuarioRepository.findAll();
     }
}
