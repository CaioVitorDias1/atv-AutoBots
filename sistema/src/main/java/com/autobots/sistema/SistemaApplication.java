package com.autobots.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.enums.TipoUser;
import com.autobots.sistema.models.UserCreate;
import com.autobots.sistema.repositories.UsuarioRepository;

@SpringBootApplication
public class SistemaApplication implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(SistemaApplication.class, args);
	}

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		


		Usuario usuario = new Usuario();
		usuario.setNome("caio");
		usuario.setUserEmail("caio@gmail.com");
		usuario.setSenha(passwordEncoder.encode("senha"));
		usuario.setTipoUser(TipoUser.CLIENTE);
		usuario.setCargo("ADMINISTRADOR");
		usuarioRepository.save(usuario);
	}

}


