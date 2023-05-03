package com.autobots.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.models.UserCreate;
import com.autobots.sistema.repositories.UsuarioRepository;

@SpringBootApplication
public class SistemaApplication {

	@Autowired
	private UserCreate userCreate;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaApplication.class, args);

		

		
		
		// final UsuarioRepository usuarioRepository;
		
		// private SistemaApplication (UsuarioRepository usuarioRepository){
		// 	this.usuarioRepository = usuarioRepository;
		// }




	}


	
	


}


