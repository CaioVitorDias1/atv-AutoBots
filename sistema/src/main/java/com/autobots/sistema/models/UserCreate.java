package com.autobots.sistema.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.autobots.sistema.entities.Cliente;
import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.repositories.UsuarioRepository;

@Service
public class UserCreate {
    @Autowired
	private UsuarioRepository usuarioRepository;
		

    
         
		

        public void gerarUser(){
            Usuario user = new Usuario();
            user.setUserEmail("user@gmail.com");
            user.setSenha(new BCryptPasswordEncoder().encode("senha"));
            usuarioRepository.save(user);
        }
}
