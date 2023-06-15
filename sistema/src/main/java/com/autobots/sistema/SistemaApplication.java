package com.autobots.sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.autobots.sistema.entities.Usuario;
import com.autobots.sistema.enums.TipoUser;
import com.autobots.sistema.models.AuthenticationModel;
import com.autobots.sistema.repositories.UsuarioRepository;
import com.autobots.sistema.services.JwtService;

@SpringBootApplication
public class SistemaApplication implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepositorio;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	public static void main(String[] args) {
		SpringApplication.run(SistemaApplication.class, args);
	}

	

	@Override
	public void run(String... args) throws Exception {
		Usuario user = new Usuario();
		user.setUserEmail("admin@gmail.com");
		user.setNome("admin");
		user.setTipoUser(TipoUser.FUNCIONARIO);
		user.setSenha(passwordEncoder.encode("123"));
		user.setCargo("ADMINISTRADOR");
		usuarioRepositorio.save(user);
	}

}


